package com.ehualu.data.business.ftp;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileStoreUtil {
    private static Logger logger = LoggerFactory.getLogger(FileStoreUtil.class);

    public static void upload(FTPClient client, Path path){
        File file = new File(path.toUri());

        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
            client.storeFile(path.getFileName() + ".temp",fis);
            client.rename(path.getFileName() + ".temp",path.getFileName() + ".ok");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /***
     * 文件夹 进行打包操作
     * @param sourceDirPath
     * @param zipFilePath
     * @throws IOException
     */
    public static void zip(Path sourceDirPath, Path zipFilePath) throws IOException {
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
