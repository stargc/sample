package com.ehualu.data.business.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

@Component
public class FtpUtil {
    private static Logger logger = LoggerFactory.getLogger(FtpUtil.class);

    public static void upload(FTPClient client, Path path){
        File file = new File(path.toUri());

        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
            client.storeFile("a.zip.temp",fis);
            client.rename("a.zip.temp","a.zip.ok");
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
}
