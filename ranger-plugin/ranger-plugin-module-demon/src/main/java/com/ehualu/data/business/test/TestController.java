package com.ehualu.data.business.test;

import com.ehualu.data.business.test.auth.RangerTestAuthorizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("test")
    public boolean createIndex(@RequestParam String path, @RequestParam String accessType, @RequestParam String username){
        RangerTestAuthorizer authorizer = new RangerTestAuthorizer();
        return authorizer.checkPermission(path, accessType, username);
    }
}
