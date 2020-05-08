package com.stargc.sample.es.controller;

import com.stargc.sample.es.entity.LogInfo;
import com.stargc.sample.es.service.ESIndexService;
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
    private ESIndexService esIndexService;
    @Autowired
    private ESSearchService esSearchService;

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

    @GetMapping("search")
    public List<Map<String, Object>> search(@RequestParam String searchText){
        return esSearchService.multiSearch(searchText);
    }

}
