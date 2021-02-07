package com.ehualu.data.business.fastdfs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.csource.fastdfs.StorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author created by guanchen on 2020/10/9 10:58
 */
@Service
@Slf4j
public class FastDFSService {
//    @Autowired
    private StorageClient storageClient;

    @SneakyThrows
    public FastDFSResponse upload(String filePath) {
        String[] strings = storageClient.upload_file(filePath, "jpg",
                null);
        FastDFSResponse response = new FastDFSResponse();
        response.setGroupName(strings[0]);
        response.setFileName(strings[1]);
        return response;
    }

    @SneakyThrows
    public boolean download(String groupName,String remoteFilename,String fileDownloadPath) {
        File file = new File(fileDownloadPath);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            byte[] content = storageClient.download_file(groupName, remoteFilename);
            if (content == null || content.length == 0) {
                log.error("文件大小为空！");
                boolean flag = file.delete();
                log.info("删除文件结果：{}", flag);
                return false;
            }
            bos.write(content);
            log.info("成功下载文件： " + fileDownloadPath);
            return true;
        }
    }
}
