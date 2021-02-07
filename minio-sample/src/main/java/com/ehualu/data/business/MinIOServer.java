package com.ehualu.data.business;

import io.minio.MinioClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author created by guanchen on 2020/10/9 15:20
 */
@Slf4j
@Service
public class MinIOServer {
    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String bucketName;


    @SneakyThrows
    public boolean upload(String fileName,String objectName)  {
        minioClient.putObject(bucketName,objectName,fileName);
        return true;
    }

    @SneakyThrows
    public boolean download(String fileName,String objectName)  {
        minioClient.getObject(bucketName,objectName,fileName);
        return true;
    }

    @SneakyThrows
    public boolean upload(MultipartFile file, String objectName)  {
        minioClient.putObject(bucketName,objectName,file.getInputStream(),file.getSize(), "application/octet-stream");
        return true;
    }

    @SneakyThrows
    public void show(String objectName,String objectType, OutputStream outputStream){
        InputStream stream = minioClient.getObject(bucketName,objectName);
//
//        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
//        int ch;
//        while ((ch = stream.read()) != -1) {
//            swapStream.write(ch);
//        }
//        outputStream.write(swapStream.toByteArray());

        ImageIO.write(ImageIO.read(stream),objectType,outputStream);
    }

}
