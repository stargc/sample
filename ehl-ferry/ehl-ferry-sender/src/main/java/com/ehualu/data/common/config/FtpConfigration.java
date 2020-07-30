package com.ehualu.data.common.config;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FtpConfigration {
    private static Logger logger = LoggerFactory.getLogger(FtpConfigration.class);

    // FTP 登录用户名
    @Value("${ftp.client.username}")
    private String userName;
    // FTP 登录密码
    @Value("${ftp.client.password}")
    private String pwd;
    // FTP 服务器地址IP地址
    @Value("${ftp.client.host}")
    private String host;
    // FTP 端口
    @Value("${ftp.client.port}")
    private int port;

    @Bean
    public FTPClient getFTPClient() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(host, port);// 连接FTP服务器
            ftpClient.login(userName, pwd);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                logger.error("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                logger.info("FTP连接成功。");
            }
        } catch (SocketException e) {
            logger.error("连接ftp失败！");
            logger.error(ExceptionUtils.getStackTrace(e));
        } catch (IOException e) {
            logger.error("连接ftp失败！");
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return ftpClient;
    }

    public void close(FTPClient ftpClient) {
        try {
            if (ftpClient != null) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            logger.error("ftp连接关闭失败！");
            logger.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
