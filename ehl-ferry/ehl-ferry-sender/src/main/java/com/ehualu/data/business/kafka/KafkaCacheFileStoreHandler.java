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
        while (true) {
            try {
                byte[] data = queue.take();
                if (data == null || data.length < 0) continue;
                logger.info("start - dispose queue data " + data);
                //TODO: 解析信息 1. 大图改URL，2. 小图bindata没值的话 解析图片存到bindata里面
                Files.write(Paths.get(localTempPath + UUID.randomUUID() + ".file.temp"), data);
                Files.move(Paths.get(localTempPath + UUID.randomUUID() + ".file.temp"), Paths.get(localTempPath + UUID.randomUUID() + ".file"));
                logger.info("end - dispose queue data " + data);
            } catch (InterruptedException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            } catch (IOException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        }
    }

}
