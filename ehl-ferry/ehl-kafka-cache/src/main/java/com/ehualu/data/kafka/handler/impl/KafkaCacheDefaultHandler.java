package com.ehualu.data.kafka.handler.impl;

import com.ehualu.data.kafka.handler.KafkaCacheHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author created by guanchen on 2020/7/23 17:27
 */
public class KafkaCacheDefaultHandler extends KafkaCacheHandler {
    private static final Logger logger = LoggerFactory.getLogger(KafkaCacheDefaultHandler.class);

    @Override
    public void run() {
        byte[] data;
        while (true && !Thread.currentThread().isInterrupted()) {
            try {
                data = queue.take();
                if (data.length > 0) {
                    logger.info("dispose queue data " + data);
                }
            } catch (InterruptedException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        }
    }

}
