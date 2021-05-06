package com.gc.demo.business.user;

import com.gc.demo.business.user.vo.LoginRequest;
import com.gc.demo.business.user.vo.RegisterRequest;
import com.gc.demo.infrastructure.exception.LogicErrorException;
import com.gc.demo.infrastructure.persistence.mapper.UserInfoMapper;
import com.gc.demo.infrastructure.persistence.po.UserInfo;
import com.gc.demo.infrastructure.persistence.po.UserInfoExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * @author created by guanchen on 2021/5/6 14:39
 */
@Service
@Slf4j
public class BaseService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Value("${server.hostName}")
    private String ip;
    @Value("${server.port}")
    private String port;

    public boolean login(LoginRequest request){

        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserNameEqualTo(request.getUserName()).andPasswordEqualTo(request.getPassword());
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if (list.isEmpty()){
            throw new LogicErrorException("用户名或者密码错误");
        }
        return true;
    }

    public boolean register(RegisterRequest request) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserNameEqualTo(request.getUserName());
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if (!list.isEmpty()){
            throw new LogicErrorException(String.format("用户%s已存在",request.getUserName()));
        }
        UserInfo info = request.tran2UserInfo();
        info.setCreateTime(new Date());
        if (StringUtils.isBlank(info.getAvatarUrl())) {
            info.setAvatarUrl(String.format("http://%s:%s/img/avatar_default.png",ip,port));
        }
        userInfoMapper.insertSelective(info);
        return true;
    }
}
