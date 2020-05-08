package com.stargc.sample.es.controller;

import com.stargc.sample.es.service.ESSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2019/12/20 17:11
 */
@Slf4j
@RestController
public class ESController {

    @Autowired
    private ESSearchService esSearchService;

    @GetMapping("search")
    public List<Map<String, Object>> search(@RequestParam String searchText){
        return esSearchService.multiSearch(searchText);
    }

}
