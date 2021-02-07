package com.ehualu.data.business;

import io.minio.MinioClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author created by guanchen on 2020/10/9 15:22
 */
@Configuration
public class MinIOConfig {

    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.username}")
    private String username;
    @Value("${minio.password}")
    private String password;

    @Bean
    @SneakyThrows
    public MinioClient getMinioClient() {
        return new MinioClient(endpoint, username, password);
    }

    @SneakyThrows
    public static void main(String[] args) {
        MinioClient client = new MinioClient("http://172.38.40.163:50000", "minioadmin", "minioadmin");
        client.makeBucket("performance-test");
        System.out.println("performanceTest bucket Exists " + client.bucketExists("performance-test"));
        client.listBuckets().stream().forEach(bucket -> {
            System.out.println(String.format("bucket [%s],size[%s]",bucket.name(),bucket.size()));
        });
    }
}
