package com.ehualu.data.business.test;

import com.ehualu.data.business.ftp.FtpUtil;
import com.ehualu.data.common.config.FtpConfigration;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * @author created by guanchen on 2020/7/22 10:25
 */
@Service
public class TestServer {

    @Autowired
    private KafkaProducer kafkaProducer;

    public void send(String msg) {
        ProducerRecord<Object, byte[]> record = new ProducerRecord<>("demo", msg.getBytes());
        kafkaProducer.send(record);

    }

    @Qualifier("customExecutor")
    @Autowired
    private Executor executor;


    @Autowired
    private FtpUtil ftpUtil;
    @Autowired
    private FtpConfigration connect;

    public void ftpTest(){

        FTPClient ftpClient = connect.getFTPClient();
        ftpClient.enterLocalPassiveMode();
        System.out.println("获得指定目录下的文件夹和文件信息");
        try {
            FTPFile[] ftpFiles = ftpClient.listFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
