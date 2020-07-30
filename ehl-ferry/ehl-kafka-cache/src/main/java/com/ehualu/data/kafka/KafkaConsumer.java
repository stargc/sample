package com.ehualu.data.kafka;

import com.ehualu.data.kafka.handler.KafkaCacheHandler;
import com.ehualu.data.kafka.handler.KafkaCacheHandlerFactory;
import com.ehualu.data.kafka.handler.KafkaCacheQueueAgent;
import com.ehualu.data.kafka.handler.impl.KafkaCacheDefaultHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/**
 * @author created by guanchen on 2020/7/23 15:48
 */
@Component
public class KafkaConsumer implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);


    @Qualifier("customExecutor")
    @Autowired
    private Executor executor;
    @Autowired
    private org.apache.kafka.clients.consumer.KafkaConsumer kafkaConsumer;
    @Autowired
    private KafkaCacheHandlerFactory handlerFactory;

    @Value("${kafka.handler.thread-num}")
    private int handlerNum;

    private KafkaCacheQueueAgent<byte[]> queue;
    private boolean pauseKey;
    private Queue<KafkaCacheHandler> handlerQueue;

    @Autowired
    private KafkaCacheDefaultHandler kafkaCacheDefaultHandler;

    @PostConstruct
    public void init(){
        queue = KafkaCacheQueueAgent.getInstance();
        executor.execute(this);
        pauseKey = true;

        handlerQueue = new LinkedList<>();

        handlerFactory.getHandlers().stream().forEach(handler -> {
            handlerQueue.add(handler);
            executor.execute(handler);
        });
    }

    @Override
    public void run() {
        kafkaConsumer.subscribe(Arrays.asList("demo"));
        while (true && !Thread.currentThread().isInterrupted()) {
            while (pauseKey) {
                ConsumerRecords<String, byte[]> records = kafkaConsumer.poll(Duration.ofMillis(200));
                records.forEach(record -> {
                    logger.info(String.format("value is %s",new String(record.value())));
                    try {
                        queue.put(record.value());
                    } catch (InterruptedException e) {
                        logger.error(ExceptionUtils.getStackTrace(e));
                    }
                    logger.info(String.format("%s value put in queue ",new String(record.value())));
                });
            }
        }
    }

    public boolean pauseKey(){
        pauseKey = !pauseKey;
        return pauseKey;
    }
}
