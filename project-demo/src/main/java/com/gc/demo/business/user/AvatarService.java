package com.gc.demo.business.user;

import com.gc.demo.infrastructure.exception.LogicErrorException;
import com.gc.demo.infrastructure.persistence.mapper.UserInfoMapper;
import com.gc.demo.infrastructure.persistence.po.UserInfo;
import com.gc.demo.infrastructure.persistence.po.UserInfoExample;
import com.gc.demo.infrastructure.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author created by guanchen on 2021/5/6 15:05
 */
@Service
@Slf4j
public class AvatarService {

    @Value("${avatarPath}")
    private String avatarPath;
    @Value("${server.hostName}")
    private String ip;
    @Value("${server.port}")
    private String port;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public void uploadAvatar(MultipartFile file,int userId){
        File path = new File(avatarPath);
        if (!path.isDirectory()){
            path.mkdirs();
        }
        String newName = userId + "-" +  System.currentTimeMillis() + NumberUtil.getRandomNickname(5)
                + file.getOriginalFilename();
        try {
            file.transferTo(new File(avatarPath + File.separator + newName));
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw new LogicErrorException("头像上传失败");
        }

        UserInfo info = new UserInfo();
        info.setAvatarUrl(String.format("http://%s:%s/user/showAvatar/%s",ip,port,newName));

        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andIdEqualTo(userId);
        userInfoMapper.updateByExampleSelective(info,example);
    }


    public void showAvatar(String name, HttpServletResponse response) throws IOException {

        File file = new File(avatarPath + File.separator + name);
        if (!file.exists()){
            throw new FileNotFoundException("图片不存在");
        }
        ImageIO.write(ImageIO.read(new FileInputStream(file)),"jpg",response.getOutputStream());

    }
}
