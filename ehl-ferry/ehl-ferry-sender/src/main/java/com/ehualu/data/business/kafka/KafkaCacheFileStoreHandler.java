package com.ehualu.data.business.kafka;

import com.ehualu.data.kafka.handler.KafkaCacheHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author created by guanchen on 2020/7/23 17:27
 */
public class KafkaCacheFileStoreHandler extends KafkaCacheHandler {
    private static final Logger logger = LoggerFactory.getLogger(KafkaCacheFileStoreHandler.class);

    private String localTempPath;

    public KafkaCacheFileStoreHandler(String localTempPath) {
        this.localTempPath = localTempPath;
    }

    @Override
    public void run() {
        byte[] data;
        while (true) {
            try {
                data = queue.take();
                if (data == null || data.length < 0) continue;

                logger.info("start - dispose queue data " + data);
                Files.write(Paths.get(localTempPath + UUID.randomUUID() + ".file"), data);
                logger.info("end - dispose queue data " + data);
            } catch (InterruptedException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            } catch (IOException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        }
    }

}
