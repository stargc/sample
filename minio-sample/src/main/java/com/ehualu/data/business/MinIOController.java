package com.ehualu.data.business;

import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@Slf4j
@RestController
public class MinIOController {
    @Autowired
    private MinIOServer minIOServer;

    @RequestMapping("upload")
    public Message upload(@RequestParam String fileName,@RequestParam String objectName){
        return new MessageBuilder.Builder<Boolean>().setStatus(Message.Code.OK).setData(minIOServer.upload(fileName, objectName)).builder();
    }

    @RequestMapping("download")
    public Message<Boolean> download(@RequestParam String fileDownloadName,@RequestParam String objectName){
        return new MessageBuilder.Builder<Boolean>().setStatus(Message.Code.OK).setData(minIOServer.download(fileDownloadName, objectName)).builder();
    }

    @RequestMapping("uploadFile")
    public Message upload(@RequestParam("sourceFile") MultipartFile file, @RequestParam String objectName){
        return new MessageBuilder.Builder<Boolean>().setStatus(Message.Code.OK).setData(minIOServer.upload(file, objectName)).builder();
    }

    @SneakyThrows
    @RequestMapping("show")
    public void show(@RequestParam String objectName, @RequestParam String objectType, HttpServletResponse response){
//        response.setContentType("application/octet-stream");
//        response.setContentType("image/png");
//        response.setHeader("Content-Disposition", "attachment;filename="+objectName);
        minIOServer.show(objectName,objectType,response.getOutputStream());
    }
}