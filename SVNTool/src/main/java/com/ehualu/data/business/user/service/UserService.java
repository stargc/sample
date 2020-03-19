package com.ehualu.data.business.user.service;

import com.ehualu.data.business.user.dao.UserMapper;
import com.ehualu.data.business.user.model.User;
import com.ehualu.data.business.user.model.UserExample;
import com.ehualu.data.common.exception.MessageException;
import com.ehualu.data.common.util.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author created by guanchen on 2020/3/18 15:07
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private static final String SYMBOL = ".";
    private static final String SYMBOL_SPILT = "\\.";
    private static final long overdue = 30 * 60 * 1000;

    public String login(String userName,String password){
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.isEmpty()){
            log.info(String.format("用户%s不存在",userName));
            throw new MessageException("登录失败");
        }
        long overdueTime = System.currentTimeMillis() + overdue;
        String token = null;
        try {
            token = new  StringBuilder()
                    .append(AESUtil.encrypt(userName))
                    .append(SYMBOL)
                    .append(AESUtil.encrypt(String.valueOf(userList.get(0).getId())))
                    .append(SYMBOL)
                    .append(AESUtil.encrypt(String.valueOf(overdueTime)))
                    .toString();
        } catch (Exception e) {
            log.error("生成token错误：" + ExceptionUtils.getStackTrace(e));
            throw new MessageException("登录错误");
        }

        return token;
    }

    public boolean checkToken(String token){
        String[] info = token.split(SYMBOL_SPILT);
        if (info.length != 3){
            throw new MessageException("token 格式错误");
        }
        long overdueTime = 0;
        try {
            String userName = AESUtil.decrypt(info[0]);
            String userId = AESUtil.decrypt(info[1]);
            overdueTime = Long.valueOf(AESUtil.decrypt(info[2]));
        } catch (Exception e) {
            throw new MessageException("token 不存在");
        }

        return overdueTime > System.currentTimeMillis();
    }
}
