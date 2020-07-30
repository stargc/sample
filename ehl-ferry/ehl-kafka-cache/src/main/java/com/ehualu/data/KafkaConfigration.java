package com.ehualu.data;

import com.ehualu.data.kafka.handler.KafkaCacheHandlerFactory;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author created by guanchen on 2020/7/22 15:32
 */
@Configuration
public class KafkaConfigration {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${kafka.producer.acks:all}")
    private String acks;
    @Value("${kafka.producer.key-serializer}")
    private String keySerializer;
    @Value("${kafka.producer.value-serializer}")
    private String valueerializer;
    @Value("${kafka.consumer.group-id}")
    private String groupId;
    @Value("${kafka.consumer.enable-auto-commit:true}")
    private String enableAutoCommit;
    @Value("${kafka.consumer.auto-commit-interval:1000}")
    private String autoCommitIntervalMs;
    @Value("${kafka.consumer.key-deserializer}")
    private String keyDeserializer;
    @Value("${kafka.consumer.value-deserializer}")
    private String valueDeserializer;
    @Value("${kafka.consumer.max-poll-records}")
    private int maxPollRecords;


    @Value("${ftp.local.temp-path}")
    private String localTempPath;

    @Autowired
    private KafkaCacheHandlerFactory handlerFactory;


    @Bean
    public KafkaProducer getKafkaProducer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("acks", acks);// acks=0 配置适用于实现非常高的吞吐量 , acks=all 这是最安全的模式
        props.put("key.serializer", keySerializer);
        props.put("value.serializer", valueerializer);
        return new KafkaProducer<String, String>(props);
    }

    @Bean
    public KafkaConsumer getKafkaConsumer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("group.id", groupId);
        props.put("enable.auto.commit", enableAutoCommit);
        props.put("auto.commit.interval.ms", autoCommitIntervalMs);
        props.put("key.deserializer", keyDeserializer);
        props.put("value.deserializer", valueDeserializer);
        props.put("max.poll.records",maxPollRecords);//每次消费最大数量
        return new KafkaConsumer<>(props);
    }
}
