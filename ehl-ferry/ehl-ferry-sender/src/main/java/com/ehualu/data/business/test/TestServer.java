package com.ehualu.data.business.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author created by guanchen on 2020/7/22 10:25
 */
@Service
public class TestServer {

    @Autowired
    private KafkaProducer kafkaProducer;

    public void send(String msg) {



        ProducerRecord<Object, byte[]> record = new ProducerRecord<>("demo", msg.getBytes());
        kafkaProducer.send(record);

    }

}
