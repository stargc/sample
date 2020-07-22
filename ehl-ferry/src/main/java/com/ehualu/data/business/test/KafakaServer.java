package com.ehualu.data.business.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author created by guanchen on 2020/7/22 10:25
 */
@Service
public class KafakaServer {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public String send(String msg){
        kafkaTemplate.send("demo", msg); //使用kafka模板发送信息
        return "success";
    }

    @KafkaListener(topics = "demo")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }

}
