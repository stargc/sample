package com.ehualu.data.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/3/19 10:53
 */
@Controller
public class LoginPage {

    @RequestMapping("/page/login")
    public String login(Model model){
        model.addAttribute("serverInfo", "aaaa");
        return "login";
    }
}
