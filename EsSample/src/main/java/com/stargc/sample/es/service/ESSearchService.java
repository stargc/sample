package com.stargc.sample.es.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author created by guanchen on 2020/3/9 10:35
 */
@Service
@Slf4j
public class ESSearchService {

    @Resource
    RestHighLevelClient restHighLevelClient;


    public List<Map<String, Object>> multiSearch(String searchText) {
        if (StringUtils.isBlank(searchText)) {
            searchText = "*";
        }
        searchText = searchText.replace("%", "*");

        List<String> texts = Arrays.stream(searchText.split(" ")).collect(Collectors.toList());
        List<Map<String, Object>> result = Collections.emptyList();
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            SearchRequest request = new SearchRequest();
            //索引
            request.indices("test22");
            //分页
            sourceBuilder.from(0);
            sourceBuilder.size(10);

//            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//            boolQueryBuilder.must(QueryBuilders.wildcardQuery("bussiness","test1"));
//            sourceBuilder.query(boolQueryBuilder);
//            MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(searchText);
//            QueryStringQueryBuilder qb = QueryBuilders.queryStringQuery(searchText);

            //全文检索
            BoolQueryBuilder query = QueryBuilders.boolQuery();
            texts.forEach(text ->
                    query.must(QueryBuilders.boolQuery()
                            .filter(QueryBuilders.wildcardQuery("all_text", text)))
            );

            sourceBuilder.query(query);

            //按评分排序
            sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));

            //各种组合条件
            request.source(sourceBuilder);
            //请求
            log.info(String.format("查询条件：%s", request.source().toString()));
            SearchResponse response = restHighLevelClient.search(request);
            //解析返回
            if (response.status() != RestStatus.OK || response.getHits().getTotalHits() <= 0) {
                return result;
            }
            log.info("获取结果总数：{}", response.getHits().getTotalHits());
            //获取source
            result = Arrays.stream(response.getHits().getHits()).map(SearchHit::getSourceAsMap).collect(Collectors.toList());
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }
}
