package com.ehl.tsq.data.business.service.ZHCG.toilets;

import com.alibaba.fastjson.JSON;
import com.ehl.tsq.data.business.service.ZHCG.vo.DeviceTypeCodeEnum;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.DtsjCsglCsjcssjcMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGToiletsMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGToiletsValueMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.validator.routines.BigDecimalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
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

    @JmsListener(destination = "toilet_alarm_topic_public", containerFactory = "topicListenerContainerFactory")
    public void handleMessage(Message json) {
        String result = "";
        try {
            result = ((TextMessage)json).getText();
        } catch (JMSException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        log.info("MQ 获取公厕告警信息" + result);
        if (StringUtils.isBlank(result)){
            log.error("接收到 公厕告警信息 内容为空");
            return;
        }
        ZHCGResp<ZHCGToiletsValue> resp = JSON.parseObject(result, ZHCGResp.class);
        if (resp == null || resp.getData() == null){
            log.error("接收到 公厕信息 内容为空");
            return;
        }
        ZHCGToiletsValue alarmMessage = JSON.parseObject(JSON.toJSONString(resp.getData()),ZHCGToiletsValue.class);

        ZHCGToiletsExample example = new ZHCGToiletsExample();
        example.createCriteria().andSensorIdManEqualTo(alarmMessage.getDeviceNum());
        example.or(example.createCriteria().andSensorIdWomanEqualTo(alarmMessage.getDeviceNum()));
        List<ZHCGToilets> toiletsList = toiletsMapper.selectByExample(example);
        if (toiletsList.isEmpty()){
            log.error("没有找到对应的公厕编号,：" + alarmMessage.getDeviceNum());
            return;
        }
        alarmMessage.setToiletId(toiletsList.get(0).getId());
        alarmMessage.setCreateTime(new Date());
        warningMapper.insertSelective(alarmMessage);

        DtsjCsglCsjcssjcExample warnExample = new DtsjCsglCsjcssjcExample();
        warnExample.createCriteria().andTypeCodeEqualTo(DeviceTypeCodeEnum.GC.getCode()).
                andDeviceIdEqualTo(alarmMessage.getToiletId());
        List<DtsjCsglCsjcssjc> deviceList = dtsjCsglCsjcssjcMapper.selectByExample(warnExample);
        if (deviceList.isEmpty()){
            log.error("没有找到对应的公厕,：" + alarmMessage.getDeviceNum());
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
    private boolean isIn(String value,String min,String max){
        Assert.isTrue(BigDecimalValidator.getInstance().isValid(value),"value 不是数字类型");
        Assert.isTrue(BigDecimalValidator.getInstance().isValid(min),"min 不是数字类型");
        Assert.isTrue(BigDecimalValidator.getInstance().isValid(max),"max 不是数字类型");

        BigDecimal numberValue = new BigDecimal(value);
        BigDecimal minValue = new BigDecimal(min);
        BigDecimal maxValue = new BigDecimal(max);
        return BigDecimalValidator.getInstance().isInRange(numberValue,minValue.doubleValue(),maxValue.doubleValue());
    }
}
