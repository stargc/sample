package com.ehualu.data.business.product.controller;

import com.ehualu.data.business.product.model.Product;
import com.ehualu.data.business.product.service.ProductService;
import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author created by guanchen on 2020/3/19 9:53
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("_searchAll")
    public Message<List<Product>> searchSvnUser(){
        List<Product> productList = productService.searchAll();
        return new MessageBuilder.Builder<List<Product>>()
                .setStatus(Message.Code.OK)
                .setData(productList)
                .builder();
    }
}
