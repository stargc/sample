package com.ehualu.data.business.fastdfs;

import lombok.SneakyThrows;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;

/**
 * @author created by guanchen on 2020/10/9 10:35
 */
//@Configuration
public class FastDFSConfig {
    @SneakyThrows
    @Bean
    public StorageClient getStorageClient(){

        File file = ResourceUtils.getFile("classpath:config/fdfs_client.conf");
        ClientGlobal.init(file.getAbsolutePath());
        // 2、创建一个 TrackerClient 对象。直接 new 一个。
        TrackerClient trackerClient = new TrackerClient();
        // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 4、创建一个 StorageServer 的引用，值为 null
        StorageServer storageServer = null;
        // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
        return new StorageClient(trackerServer, storageServer);
    }
}
