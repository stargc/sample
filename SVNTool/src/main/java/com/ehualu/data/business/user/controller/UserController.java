package com.ehualu.data.business.user.controller;

import com.ehualu.data.business.user.service.UserService;
import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author created by guanchen on 2020/3/18 14:59
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("_login")
    public Message login(@RequestParam String userName, @RequestParam String password) {
        String token = userService.login(userName, password);
        return new MessageBuilder.Builder<String>()
                .setStatus(Message.Code.OK)
                .setData(token)
                .builder();
    }

    @GetMapping("checkToken")
    public Message checkToken(@RequestHeader("token") String token) {
        boolean result = userService.checkToken(token);
        return new MessageBuilder.Builder<String>()
                .setStatus(result ? Message.Code.OK : Message.Code.ERROR)
                .builder();
    }
}
