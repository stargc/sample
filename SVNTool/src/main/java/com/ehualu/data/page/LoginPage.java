package com.ehualu.data.page;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/3/19 10:53
 */
@RestController
@RequestMapping("/page")
public class LoginPage {

    @RequestMapping("login")
    public String login(Model model){
        return "login";
    }
}
