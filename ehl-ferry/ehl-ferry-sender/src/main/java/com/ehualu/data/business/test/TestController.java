package com.ehualu.data.business.test;

import com.ehualu.data.business.ftp.FileStoreJob;
import com.ehualu.data.kafka.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@RestController
public class TestController {

    @Autowired
    private TestServer testServer;
    @Autowired
    private KafkaConsumer consumer;
    @Autowired
    private FileStoreJob fileStoreJob;

    @GetMapping("send")
    public String send(String msg){
        testServer.send(msg);
        return "Success";
    }

    @GetMapping("receivePause")
    public boolean receivePause(){
        return consumer.pause();
    }
    @GetMapping("receiveRestart")
    public boolean receiveRestart(){
        return consumer.restart();
    }

    @GetMapping("ftpPause")
    public boolean ftpPause(){
        return fileStoreJob.pause();
    }
    @GetMapping("ftpRestart")
    public boolean ftpRestart(){
        return fileStoreJob.restart();
    }

    @GetMapping("ftpTest")
    public String ftpTest(){
        fileStoreJob.checkLocalFile();
        return "SUCCESS";
    }
}
