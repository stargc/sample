package com.stargc.sample.es.controller;

import com.stargc.sample.es.entity.LogInfo;
import com.stargc.sample.es.service.ESIndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2019/12/20 17:11
 */
@Slf4j
@RestController
public class ESController {

    @Autowired
    private ESIndexService esIndexService;

    private String indexName = "test22";

    @GetMapping("createIndex")
    public boolean createIndex(){
        return esIndexService.createIndex(indexName, LogInfo.class);
    }

    @GetMapping("isIndexExists")
    public boolean isIndexExists(){
        return esIndexService.isIndexExists(indexName);
    }

    @GetMapping("deleteIndex")
    public boolean deleteIndex(){
        return esIndexService.deleteIndex(indexName);
    }

}
