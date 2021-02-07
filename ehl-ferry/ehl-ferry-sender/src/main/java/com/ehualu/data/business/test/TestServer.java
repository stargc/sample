package com.ehualu.data.business.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @author created by guanchen on 2020/7/22 10:25
 */
@Service
public class TestServer {

    @Autowired
    private KafkaProducer kafkaProducer;

    public void send(String msg) {

        ProducerRecord<Object, byte[]> record = new ProducerRecord<>("swkj_house", msg.getBytes());
        kafkaProducer.send(record);


        Properties props = new Properties();
        props.put("bootstrap.servers", "172.38.40.146:9092");
        props.put("acks", "all");// acks=0 配置适用于实现非常高的吞吐量 , acks=all 这是最安全的模式
        props.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        KafkaProducer producer = new KafkaProducer<>(props);
        producer.send(record);
    }


    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "172.38.40.146:9092");
        props.put("acks", "0");// acks=0 配置适用于实现非常高的吞吐量 , acks=all 这是最安全的模式
        props.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        KafkaProducer producer = new KafkaProducer<>(props);
        ProducerRecord<Object, byte[]> record = new ProducerRecord<>("swkj_house", "sss".getBytes());
        producer.send(record);
//        producer.flush();
    }

}
