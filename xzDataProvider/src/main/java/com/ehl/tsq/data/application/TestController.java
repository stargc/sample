package com.ehl.tsq.data.application;

import com.ehl.tsq.data.business.common.vo.BaseResponse;
import com.ehl.tsq.data.business.service.test.TestSservice;
import com.ehl.tsq.data.business.service.test.vo.ValidatorRequest;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Slf4j
@Validated
@RestController
public class TestController {

    @Autowired
    private TestSservice testSservice;

    @PostMapping("/test1")
    public BaseResponse test1(@RequestBody @Valid ValidatorRequest demo){
        return testSservice.doTest();
    }

    @GetMapping(value = "/{room}")
    public BaseResponse test2(@PathVariable @Range(min = 1, max = 9, message = "教室只能从1-9") int room, @RequestParam @Email String email) {
        log.info(email + "," + room);
        return testSservice.doTest();
    }


    @GetMapping("restTest/{phone}")
    public BaseResponse restTest(@PathVariable String phone){
        return testSservice.restTest(phone);
    }

    @GetMapping("/cacheTest/{key}")
    public String cacheTest(@PathVariable String key) {
        log.info("do cacheTest");
        return testSservice.cacheTest(key);
    }

    @GetMapping("/cachePutTest/{key}")
    public String cachePutTest(@PathVariable String key) {
        log.info("do cachePutTest");
        return testSservice.cachePutTest(key);
    }

    @GetMapping("/caffeineTest/{key}")
    public String caffeineTest(@PathVariable String key) {
        log.info("do caffeineTest");
        return testSservice.caffeineTest(key);
    }

}
