package com.ehl.tsq.data.business.service.ZHCG.muck;

import com.alibaba.fastjson.JSONObject;
import com.ehl.tsq.data.business.service.ZHCG.trash.vo.TrashAlarmMessage;
import com.ehl.tsq.data.business.service.ZHCG.trash.vo.TrashStateData;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author created by guanchen on 2019/12/29 11:54
 */
@Component
public class MockMQProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String quere,String msg) {
        this.jmsMessagingTemplate.convertAndSend(
                new ActiveMQQueue(quere),
                msg);
    }

    public static void main(String[] args) {
        TrashAlarmMessage message = new TrashAlarmMessage();
        TrashStateData data = new TrashStateData();

        data.setBattary(2);
        data.setDistance(2);
        data.setFull(1);
        data.setPassTime(222);
        data.setBattary(2);
        data.setSequence(222);
        data.setTemperature(3);

        message.setCmd("cmd");
        message.setData(data);
        message.setDeviceID("869029037503231");
        message.setTime("sss");
        message.setVersion("22");

        Map<String,Object> bean = new HashMap<>();
        bean.put("code","200");
        bean.put("message","SUCCESS");
        bean.put("data",message);

        System.out.println(JSONObject.toJSONString(bean));
    }
}
