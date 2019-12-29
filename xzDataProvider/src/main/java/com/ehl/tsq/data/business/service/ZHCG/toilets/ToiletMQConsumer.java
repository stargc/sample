package com.ehl.tsq.data.business.service.ZHCG.toilets;

import com.alibaba.fastjson.JSONObject;
import com.ehl.tsq.data.business.service.ZHCG.trash.vo.TrashAlarmMessage;
import com.ehl.tsq.data.business.service.ZHCG.vo.DeviceTypeCodeEnum;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.*;
import com.ehl.tsq.data.infrastructure.persistence.po.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class ToiletMQConsumer {

    @Autowired
    private ZHCGToiletsValueMapper warningMapper;
    @Autowired
    private ZHCGToiletsMapper toiletsMapper;
    @Autowired
    private DtsjCsglCsjcssjcMapper dtsjCsglCsjcssjcMapper;

    @JmsListener(destination = "toilet_alarm_topic_public")
    public void handleMessage(final ActiveMQTextMessage json) {
        String result = "";
        try {
            result = json.getText();
        } catch (JMSException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        if (StringUtils.isBlank(result)){
            log.error("接收到 公厕告警信息 内容为空");
            return;
        }
        ZHCGResp<ZHCGToiletsValue> resp = JSONObject.parseObject(result, ZHCGResp.class);
        if (resp == null || resp.getData() == null){
            log.error("接收到 垃圾桶信息 内容为空");
            return;
        }
        ZHCGToiletsValue alarmMessage = JSONObject.parseObject(JSONObject.toJSONString(resp.getData()),ZHCGToiletsValue.class);

        ZHCGToiletsExample example = new ZHCGToiletsExample();
        example.createCriteria().andSensorIdManEqualTo(alarmMessage.getDeviceNum());
        example.or(example.createCriteria().andSensorDWomanEqualTo(alarmMessage.getDeviceNum()));
        List<ZHCGToilets> toiletsList = toiletsMapper.selectByExample(example);
        if (toiletsList.isEmpty()){
            log.error("没有找到对应的垃圾桶编号,：" + alarmMessage.getDeviceNum());
            return;
        }
        alarmMessage.setToiletId(toiletsList.get(0).getId());
        alarmMessage.setCreateTime(new Date());
        warningMapper.insertSelective(alarmMessage);

        DtsjCsglCsjcssjcExample warnExample = new DtsjCsglCsjcssjcExample();
        warnExample.createCriteria().andTypeCodeEqualTo(DeviceTypeCodeEnum.GC.getCode()).
                andDeviceIdEqualTo(Integer.valueOf(alarmMessage.getToiletId()));
        List<DtsjCsglCsjcssjc> deviceList = dtsjCsglCsjcssjcMapper.selectByExample(warnExample);
        if (deviceList.isEmpty()){
            log.error("没有找到对应的垃圾桶,：" + alarmMessage.getDeviceNum());
            return;
        }
        DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
        String warningMsg = getWarningMsg(alarmMessage);
        if (StringUtils.isBlank(warningMsg)){
            bean.setWarning("");
            bean.setWarningTime(null);
        } else {
            bean.setWarningTime(new Date());
            bean.setWarning("公厕报警：" + warningMsg);
        }
        bean.setUpdateTime(new Date());
        dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean,warnExample);
    }

    private String getWarningMsg(ZHCGToiletsValue alarmMessage){
        StringBuilder alarm = new StringBuilder("");
        if (isIn(alarmMessage.getTemp(),"-20","80")){
            alarm.append(String.format("温度%s℃超标;",alarmMessage.getTemp()));
        }
        if (isIn(alarmMessage.getH2(),"0","100")){
            alarm.append(String.format("湿度度%s%sRH超标;",alarmMessage.getH2(),"%"));
        }
        if (isIn(alarmMessage.getH2s(),"0","10")){
            alarm.append(String.format("硫化氢%sPPM超标;",alarmMessage.getH2s()));
        }
        if (isIn(alarmMessage.getNh3(),"0","50")){
            alarm.append(String.format("氨气%sPPM超标;",alarmMessage.getNh3()));
        }
        return alarm.toString();
    }

    /***
     * 判断value 是否在 min, max范围内
     * @param value
     * @param min
     * @param max
     * @return
     */
    private boolean isIn(String value,String min,String max) throws RuntimeException{
        BigDecimal v = new BigDecimal(value);
        BigDecimal maxValue = new BigDecimal(max);
        BigDecimal minValue = new BigDecimal(min);
        if (v.compareTo(maxValue) > 0 || v.compareTo(minValue) < 0){
            return true;
        }
        return false;
    }
}
