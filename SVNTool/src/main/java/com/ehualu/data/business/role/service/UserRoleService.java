package com.ehualu.data.business.role.service;

import com.ehualu.data.business.role.dao.UserRoleMapper;
import com.ehualu.data.business.role.model.UserRole;
import com.ehualu.data.common.filter.RequestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author created by guanchen on 2020/3/19 14:41
 */
@Service
public class UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    public void add(UserRole bean){
        bean.setCreateTime(new Date());
        bean.setCreateUserId(RequestHolder.getUserId());
        userRoleMapper.insert(bean);
    }
}
