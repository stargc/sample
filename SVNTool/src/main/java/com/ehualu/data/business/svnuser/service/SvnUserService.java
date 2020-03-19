package com.ehualu.data.business.svnuser.service;

import com.ehualu.data.business.repositories.model.RepositoriesConfig;
import com.ehualu.data.business.repositories.service.RepositoriesService;
import com.ehualu.data.business.svn.service.SVNPermissionService;
import com.ehualu.data.business.svnuser.dao.SvnUserMapper;
import com.ehualu.data.business.svnuser.model.SvnUser;
import com.ehualu.data.business.svnuser.model.SvnUserExample;
import com.ehualu.data.common.exception.MessageException;
import com.ehualu.data.common.filter.RequestHolder;
import com.ehualu.data.common.util.HtpasswdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author created by guanchen on 2020/3/18 16:18
 */
@Service
@Slf4j
public class SvnUserService {

    @Autowired
    private SvnUserMapper svnUserMapper;

    @Autowired
    private SVNPermissionService svnPermissionService;
    @Autowired
    private RepositoriesService repositoriesService;

    public List<SvnUser> searchAll(){
        SvnUserExample example = new SvnUserExample();
        example.setOrderByClause("real_name");
        List<SvnUser> userList = svnUserMapper.selectByExample(example);
        if (userList.isEmpty()) throw new MessageException("svn 用户内容为空");
        return userList;
    }

    public boolean addUser(SvnUser user){
        String htpasswd = HtpasswdUtil.getInstance().getHtpasswd(user.getUserName(),user.getPassword());

        RepositoriesConfig config = repositoriesService.getRepConfig();

        svnPermissionService.addUser(config.getDbBasePath() + "../htpasswd",htpasswd);
        user.setCreateUserId(RequestHolder.getUserId());
        user.setCreateTime(new Date());
        svnUserMapper.insertSelective(user);
        return true;
    }

    public boolean update(SvnUser user){
        SvnUserExample example = new SvnUserExample();
        example.createCriteria().andIdEqualTo(user.getId());

        svnUserMapper.updateByExampleSelective(user,example);
        return true;
    }

    public SvnUser selectById(int id){
        SvnUserExample example = new SvnUserExample();
        example.createCriteria().andIdEqualTo(id);
        List<SvnUser> userList = svnUserMapper.selectByExample(example);
        if (userList.isEmpty()) return null;
        return userList.get(0);
    }
}
