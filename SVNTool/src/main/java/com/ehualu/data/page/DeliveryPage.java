package com.ehualu.data.page;

import com.ehualu.data.business.product.service.ProductService;
import com.ehualu.data.business.svnuser.service.SvnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author created by guanchen on 2020/3/19 16:33
 */
@Controller
public class DeliveryPage {

    @Autowired
    private ProductService productService;
    @Autowired
    private SvnUserService svnUserService;

    @RequestMapping("/page/delivery")
    public String login(Model model){

        model.addAttribute("now", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        model.addAttribute("productList",productService.searchAll());
        model.addAttribute("userList",svnUserService.searchAll());
        return "delivery";
    }
}
