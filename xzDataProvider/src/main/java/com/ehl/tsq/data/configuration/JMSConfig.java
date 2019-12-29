//package com.ehl.tsq.data.configuration;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//
//import javax.jms.ConnectionFactory;
//
///**
// * @author created by guanchen on 2019/12/29 11:19
// */
//@Configuration
//public class JMSConfig {
//    @Autowired
//    private ConnectionFactory connectionFactory;
//
//    @Bean
//    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory() {
//        DefaultJmsListenerContainerFactory factory =
//                new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        //设置连接数
//        factory.setConcurrency("3-10");
//        //重连间隔时间
//        factory.setRecoveryInterval(1000L);
//        return factory;
//
//    }
//}
