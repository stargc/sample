package com.ehualu.data.business.ftp;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * @author created by guanchen on 2020/7/28 16:16
 */
@Component
public class FileStoreJob {
    private static Logger logger = LoggerFactory.getLogger(FileStoreJob.class);

    @Value("${ftp.local.temp-path}")
    private String localTempPath;
    @Value("${ftp.local.size-limit}")
    private long sizeLimit;
    @Value("${ftp.enable}")
    private boolean ftpEnable;


    @Qualifier("kafkaThreadExecutor")
    @Autowired
    private Executor executor;
    @Autowired
    private FTPClient client;

    private static final String ZIP_SUFFIX = ".zip";
    private AtomicLong jobId = new AtomicLong(0);
    private AtomicInteger threadQueueNum = new AtomicInteger(0);


    @Scheduled(cron = "*/30 * * * * ?")
    public void checkLocalFile() {
        if (!checkStart()) return;

        jobId.incrementAndGet();
        long startTime = System.nanoTime();

        //计算文件总大小
        AtomicLong fileSize = new AtomicLong();
        List<Path> files = new ArrayList<>();
        Stream<Path> fileListStream = null;
        try {
            fileListStream =  Files.list(Paths.get(localTempPath));
            fileListStream.filter(file -> file.getFileName().toString().endsWith(".file"))
                    .forEach(path -> {
                        try {
                            if (fileSize.longValue() < sizeLimit * 1024 * 1024) {
                                files.add(path);
                                fileSize.addAndGet(Files.size(path));
                            }
                        } catch (IOException e) {
                            logger.error(ExceptionUtils.getStackTrace(e));
                        }
                    });
        } catch (IOException e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        } finally {
            if (fileListStream != null) fileListStream.close();
        }

        if (fileSize.longValue() <= sizeLimit * 1024 * 1024 || files.isEmpty()) {
            logger.info(String.format("任务%s- 目标文件夹中文件总量不足%dM",jobId.get(), sizeLimit));
            return;
        }

        //如果文件满足要求 则进行以下步骤整理
        logger.info(String.format(String.format("任务%s- 目标文件夹中文件总量已足%dM，开始进行文件迁移", jobId.get(), sizeLimit)));
        String zipFoldName = System.currentTimeMillis() + "-" + UUID.randomUUID();
        Path zipFold = Paths.get(localTempPath, zipFoldName);

        //1. 创建一个新文件夹,存储需要处理的文件
        try {
            Files.createDirectory(zipFold);
        } catch (IOException e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        //2. 把需要整理的文件move到新文件夹中
        files.stream().forEach(file -> {
            try {
                Files.move(file, Paths.get(localTempPath, zipFoldName, file.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        });
        logger.info(String.format(String.format("任务%s- 目标文件迁移完成", jobId.get())));

        threadQueueNum.incrementAndGet();
        //3. 文件打包上传ftp,并清理文件夹
        executor.execute(() ->{
                try {
                    logger.info(String.format(String.format("任务%s- 开始进行打包上传", jobId.get())));
                    storeFiles(zipFoldName, zipFold);
                    logger.info(String.format(String.format("任务%s- 目标上传完成,用时%ds",
                            jobId.get(),(System.nanoTime() - startTime)/1000000/1000)));
                    threadQueueNum.decrementAndGet();
                } catch (IOException e) {
                    logger.error(ExceptionUtils.getStackTrace(e));
                }

        });

    }

    /***
     * 整理文件到ftp
     * 1. 文件夹整体打包为zip文件
     * 2. zip上传ftp
     * 3. 删除zip文件
     * 4. 删除文件夹
     */
    private void storeFiles(String zipFoldName, Path zipFold) throws IOException {
        FileStoreUtil.zip(zipFold, Paths.get(localTempPath, zipFoldName + ZIP_SUFFIX));
        FileStoreUtil.upload(client, Paths.get(localTempPath, zipFoldName + ZIP_SUFFIX));
        Files.deleteIfExists(Paths.get(localTempPath, zipFoldName + ZIP_SUFFIX));
        Stream<Path> fileListStream = Files.walk(zipFold);
        fileListStream.filter(path -> zipFold.compareTo(path) != 0).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        });
        fileListStream.close();
        Files.deleteIfExists(zipFold);
    }

    /***
     * 如果线程队列数据过多，则暂停从FTP任务
     * @return
     */
    private boolean checkStart(){
        if (threadQueueNum.get() > 100){
            ftpEnable  = pause();
            logger.error("FTP bug，大量ftp任务囤积，请尽快处理问题。累计数量：" + threadQueueNum.get());
        }
        if (!ftpEnable && threadQueueNum.get() < 50){
            ftpEnable  = restart();
        }
        return ftpEnable;
    }

    public boolean pause(){
        ftpEnable = false;
        return ftpEnable;
    }

    public boolean restart(){
        ftpEnable = true;
        return ftpEnable;
    }
}
