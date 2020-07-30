package com.ehualu.data.kafka.handler;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author created by guanchen on 2020/7/23 17:12
 */
public class KafkaCacheQueueAgent<T> {

    @Autowired
    private ArrayBlockingQueue<T> KafkaCacheQueue;

    private static KafkaCacheQueueAgent mInstance;
    public static KafkaCacheQueueAgent init(int size){
        if (mInstance == null) {
            ArrayBlockingQueue<String> KafkaCacheQueue = new ArrayBlockingQueue<>(size);
            mInstance = new KafkaCacheQueueAgent(KafkaCacheQueue);
        }
        return mInstance;
    }

    public static KafkaCacheQueueAgent getInstance() {
        if (mInstance == null) {
            throw new RuntimeException("kafka cache queue need init first!");
        }
        return mInstance;
    }

    public KafkaCacheQueueAgent(ArrayBlockingQueue<T> kafkaCacheQueue) {
        KafkaCacheQueue = kafkaCacheQueue;
    }

    public void put(T data) throws InterruptedException {
        KafkaCacheQueue.put(data);
    }

    public T take() throws InterruptedException {
        return KafkaCacheQueue.take();
    }
}
