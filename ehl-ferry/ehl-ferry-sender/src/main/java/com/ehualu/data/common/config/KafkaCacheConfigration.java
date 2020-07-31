package com.ehualu.data.common.config;

import com.ehualu.data.business.kafka.KafkaCacheFileStoreHandler;
import com.ehualu.data.kafka.handler.KafkaCacheHandlerFactory;
import com.ehualu.data.kafka.handler.KafkaCacheQueueAgent;
import com.ehualu.data.kafka.handler.impl.KafkaCacheDefaultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author created by guanchen on 2020/7/22 15:32
 */
@Configuration
public class KafkaCacheConfigration {

    @Value("${ftp.local.temp-path}")
    private String localTempPath;
    @Value("${ehl.kafka.consumer.max-poll-records}")
    private int maxPollRecords;

    @Autowired
    private KafkaCacheHandlerFactory handlerFactory;

    @Bean
    public KafkaCacheDefaultHandler initHandler(){
        //创建队列
        KafkaCacheQueueAgent.init(maxPollRecords - 1);
        //装载handler
        handlerFactory.setHandle(new KafkaCacheFileStoreHandler(localTempPath),
                new KafkaCacheFileStoreHandler(localTempPath),
                new KafkaCacheFileStoreHandler(localTempPath));

        return new KafkaCacheDefaultHandler();
    }

}
