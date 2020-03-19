package com.ehualu.data.business.svnuser.controller;

import com.ehualu.data.business.svnuser.model.SvnUser;
import com.ehualu.data.business.svnuser.service.SvnUserService;
import com.ehualu.data.common.exception.MessageException;
import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author created by guanchen on 2020/3/18 15:04
 */
@RestController
@RequestMapping("/api/svnuser")
public class SvnUserController {

    @Autowired
    private SvnUserService svnUserService;

    @GetMapping("_searchAll")
    public Message<List<SvnUser>> searchSvnUser(){
        List<SvnUser> userList = svnUserService.searchAll();
        return new MessageBuilder.Builder<List<SvnUser>>()
                .setStatus(Message.Code.OK)
                .setData(userList)
                .builder();
    }

    @PostMapping("addUser")
    public Message addSVNUser(@RequestBody SvnUser svnUser){
        if (0 == svnUser.getId()) throw new MessageException("用户ID不能为空");
        boolean result = svnUserService.addUser(svnUser);
        return new MessageBuilder.Builder<String>()
                .setStatus(result ? Message.Code.OK : Message.Code.ERROR)
                .builder();
    }


    @PostMapping("updateUser")
    public Message updateUser(@RequestBody SvnUser svnUser){
        if (0 == svnUser.getId()) throw new MessageException("用户ID不能为空");
        boolean result = svnUserService.update(svnUser);
        return new MessageBuilder.Builder<String>()
                .setStatus(result ? Message.Code.OK : Message.Code.ERROR)
                .builder();
    }
}
