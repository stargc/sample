package com.ehl.tsq.data.business.service.ZHCG.trash;

import com.alibaba.fastjson.JSON;
import com.ehl.tsq.data.business.service.ZHCG.trash.vo.TrashAlarmMessage;
import com.ehl.tsq.data.business.service.ZHCG.vo.DeviceTypeCodeEnum;
import com.ehl.tsq.data.infrastructure.persistence.mapper.DtsjCsglCsjcssjcMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGTrashMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGTrashWarningMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class TrashMQConsumer {

    @Autowired
    private ZHCGTrashWarningMapper warningMapper;
    @Autowired
    private ZHCGTrashMapper trashMapper;
    @Autowired
    private DtsjCsglCsjcssjcMapper dtsjCsglCsjcssjcMapper;

    @JmsListener(destination = "trash_alarm_topic_public", containerFactory = "topicListenerContainerFactory")
    public void handleMessage(final ActiveMQTextMessage json) {
        String result = "";
        try {
            result = json.getText();
        } catch (JMSException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        log.info("MQ 获取垃圾桶告警信息" + result);
        if (StringUtils.isBlank(result)){
            log.error("接收到 垃圾桶信息 内容为空");
            return;
        }
        TrashAlarmMessage alarmMessage = JSON.parseObject(result, TrashAlarmMessage.class);

        ZHCGTrashWarning alarm = alarmMessage.alarm2Bean();
        ZHCGTrashExample example = new ZHCGTrashExample();
        example.createCriteria().andSensorIdEqualTo(alarm.getTrashSensorId());
        List<ZHCGTrash> trashList = trashMapper.selectByExample(example);
        if (trashList.isEmpty()){
            log.error("没有找到对应的垃圾桶编号,传感器ID：" + alarm.getTrashSensorId());
            return;
        }
        alarm.setTrashId(trashList.get(0).getTrashId());
        alarm.setCreateTime(new Date());
        warningMapper.insertSelective(alarm);

        DtsjCsglCsjcssjcExample warnExample = new DtsjCsglCsjcssjcExample();
        warnExample.createCriteria().andTypeCodeEqualTo(DeviceTypeCodeEnum.LJT.getCode())
                .andDeviceIdEqualTo(alarm.getTrashId());
        List<DtsjCsglCsjcssjc> deviceList = dtsjCsglCsjcssjcMapper.selectByExample(warnExample);
        if (deviceList.isEmpty()){
            log.error("没有找到对应的垃圾桶,垃圾桶ID：" + alarm.getTrashId());
            return;
        }
        boolean isAlarm = (1 == alarm.getFull());
        //判断当前是否有报警 和 新消息是否有报警 结果是否一致。若不一致则需要更新基础设施表
        if (Boolean.compare(!StringUtils.isBlank(deviceList.get(0).getWarning()),
                isAlarm) != 0){
            DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
            bean.setWarningTime(isAlarm ? new Date() : null);
            bean.setWarning(isAlarm ? "垃圾桶发生满溢" : "\"\"");
            bean.setUpdateTime(new Date());
            dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean,warnExample);
        }

    }
}
