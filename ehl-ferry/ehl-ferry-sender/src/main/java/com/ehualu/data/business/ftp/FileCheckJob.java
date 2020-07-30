package com.ehualu.data.business.ftp;

import com.ehualu.data.common.config.FtpConfigration;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author created by guanchen on 2020/7/28 16:16
 */
@Component
public class FileCheckJob {
    private static Logger logger = LoggerFactory.getLogger(FileCheckJob.class);

    @Value("${ftp.local.temp-path}")
    private String localTempPath;
    @Value("${ftp.local.size-limit}")
    private long sizeLimit;

    //    @Scheduled(cron = "1 * * * * ?")
    public void checkLocalFile() {
        logger.info("do checkLocalFile");
        AtomicLong fileSize = new AtomicLong();
        List<Path> files = new ArrayList<>();
        try {
            Files.list(Paths.get(localTempPath))
                    .filter(file -> file.getFileName().toString().endsWith(".file"))
                    .forEach(path -> {
                        try {
                            logger.info(String.format("文件 %s 大小为 %d", path.toString(), Files.size(path)));
                            if (fileSize.longValue() < sizeLimit * 1024 * 1024) {
                                files.add(path);
                                fileSize.addAndGet(Files.size(path));
                            }
                        } catch (IOException e) {
                            logger.info(ExceptionUtils.getStackTrace(e));
                        }
                    });
        } catch (IOException e) {
            logger.info(ExceptionUtils.getStackTrace(e));
        }
        if (fileSize.longValue() > sizeLimit * 1024 * 1024 && !files.isEmpty()) {
            String zipFoldName = String.valueOf(System.currentTimeMillis());
            Path zipFold = Paths.get(localTempPath, zipFoldName);
            try {
                Files.createDirectory(zipFold);
                files.stream().forEach(file -> {
                    try {
                        Files.move(file, Paths.get(localTempPath, zipFoldName, file.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                zip(zipFold, Paths.get(localTempPath, zipFoldName + ".zip"));
                Files.walk(zipFold).filter(path -> zipFold.compareTo(path) != 0).forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                Files.deleteIfExists(zipFold);
            } catch (IOException e) {
                e.printStackTrace();
            }
            FtpUtil.upload(ftpConnect.getFTPClient(),Paths.get(localTempPath, zipFoldName + ".zip"));
            try {
                Files.deleteIfExists(Paths.get(localTempPath, zipFoldName + ".zip"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Autowired
    private FtpConfigration ftpConnect;

    public void zip(Path sourceDirPath, Path zipFilePath) throws IOException {
        Path zipFile = Files.createFile(zipFilePath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
        Files.walk(sourceDirPath).filter(path -> !Files.isDirectory(path))
                .forEach(path -> {
                    ZipEntry zipEntry = new ZipEntry(sourceDirPath.relativize(path).toString());
                    try {
                        zipOutputStream.putNextEntry(zipEntry);
                        Files.copy(path, zipOutputStream);
                        zipOutputStream.closeEntry();
                    } catch (IOException e) {
                        logger.error(ExceptionUtils.getStackTrace(e));
                    }
                });

        if (zipOutputStream != null) {
            zipOutputStream.close();
        }
    }
}
