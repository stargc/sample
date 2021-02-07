package com.ehualu.data.business.fastdfs;

import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@Slf4j
@RestController
public class FastDFSController {

    @Autowired
    private FastDFSService testService;

    @RequestMapping("upload")
    public Message<FastDFSResponse> upload(@RequestParam String filePath){
        return new MessageBuilder.Builder<FastDFSResponse>().setStatus(Message.Code.OK).setData(testService.upload(filePath)).builder();
    }

    @RequestMapping("download")
    public Message<Boolean> download(@RequestParam String groupName,@RequestParam String remoteFilename,@RequestParam String fileDownloadPath){
        return new MessageBuilder.Builder<Boolean>().setStatus(Message.Code.OK).setData(testService.download(groupName,remoteFilename,fileDownloadPath)).builder();
    }
}
