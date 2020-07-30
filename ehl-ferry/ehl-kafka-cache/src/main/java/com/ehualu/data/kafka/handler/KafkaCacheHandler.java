package com.ehualu.data.kafka.handler;


/**
 *
 * 用法：继承该类，在run方法中 消费额queue中的数据
 * 如不继承则使用 KafkaCacheDefaultHandler
 *
 * @author created by guanchen on 2020/7/23 17:27
 */
public abstract class KafkaCacheHandler implements Runnable {

    public KafkaCacheQueueAgent<byte[]> queue = KafkaCacheQueueAgent.getInstance();

}
