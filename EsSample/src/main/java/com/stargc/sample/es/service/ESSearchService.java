package com.stargc.sample.es.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.util.CollectionUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author created by guanchen on 2020/3/9 10:35
 */
@Service
@Slf4j
public class ESSearchService {

    @Resource
    RestHighLevelClient restHighLevelClient;

    public List<Map<String, Object>> search() {
        List<Map<String, Object>> result = Collections.EMPTY_LIST;
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            SearchRequest request = new SearchRequest();
            //索引
            request.indices("systemlog");
            sourceBuilder.from(0);
            sourceBuilder.size();

            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("bussiness","test1"));
            sourceBuilder.query(boolQueryBuilder);

            sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
            sourceBuilder.fetchSource(new String[]{"bussiness","operationDescription"},null);

            //各种组合条件
            request.source(sourceBuilder);
            //请求
            log.info(String.format("查询条件：%s",request.source().toString()));
            SearchResponse response = restHighLevelClient.search(request);
            //解析返回
            if (response.status() != RestStatus.OK || response.getHits().getTotalHits() <= 0) {
                result = Collections.emptyList();
            }
            //获取source
            result = Arrays.stream(response.getHits().getHits()).map(b -> b.getSourceAsMap()).collect(Collectors.toList());
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }


    public List<Map<String, Object>> multiSearch(String searchText) {
        List<Map<String, Object>> result = Collections.EMPTY_LIST;
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            SearchRequest request = new SearchRequest();
            //索引
            request.indices("systemlog");
            //分页
            sourceBuilder.from(0);
            sourceBuilder.size(10);

//            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//            boolQueryBuilder.must(QueryBuilders.wildcardQuery("bussiness","test1"));
//            sourceBuilder.query(boolQueryBuilder);

            //全文检索
            MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(searchText);
            sourceBuilder.query(multiMatchQueryBuilder);

            //按评分排序
            sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));

            //各种组合条件
            request.source(sourceBuilder);
            //请求
            log.info(String.format("查询条件：%s",request.source().toString()));
            SearchResponse response = restHighLevelClient.search(request);
            //解析返回
            if (response.status() != RestStatus.OK || response.getHits().getTotalHits() <= 0) {
                result = Collections.emptyList();
            }
            log.info("获取结果总数：{}",response.getHits().getTotalHits() );
            //获取source
            result = Arrays.stream(response.getHits().getHits()).map(b -> b.getSourceAsMap()).collect(Collectors.toList());
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    /**
     * @param index
     * @param from
     * @param size
     * @param where
     * @param sortFieldsToAsc
     * @param includeFields
     * @param excludeFields
     * @param timeOut
     * @return
     */
    public List<Map<String, Object>> searchIndex(String index, int from, int size, Map<String, Object> where,
                                                 Map<String, Boolean> sortFieldsToAsc, String[] includeFields, String[] excludeFields,
                                                 int timeOut) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            //条件
            if (where != null && !where.isEmpty()) {
                BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
                where.forEach((k, v) -> {
                    if (v instanceof Map) {
                        //范围选择map  暂定时间
                        Map<String, Date> mapV = (Map<String, Date>) v;
                        if (mapV != null) {
                            boolQueryBuilder.must(
                                    QueryBuilders.rangeQuery(k).
                                            gte(format.format(mapV.get("start"))).
                                            lt(format.format(mapV.get("end"))));
                        }
                    } else {
                        //普通模糊匹配
                        boolQueryBuilder.must(QueryBuilders.wildcardQuery(k, v.toString()));
                    }
                });
                sourceBuilder.query(boolQueryBuilder);
            }

            //分页
            from = from <= -1 ? 0 : from;
            size = size >= 1000 ? 1000 : size;
            size = size <= 0 ? 15 : size;
            sourceBuilder.from(from);
            sourceBuilder.size(size);

            //超时
            sourceBuilder.timeout(new TimeValue(timeOut, TimeUnit.SECONDS));

            //排序
            if (sortFieldsToAsc != null && !sortFieldsToAsc.isEmpty()) {
                sortFieldsToAsc.forEach((k, v) -> {
                    sourceBuilder.sort(new FieldSortBuilder(k).order(v ? SortOrder.ASC : SortOrder.DESC));
                });
            } else {
                sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
            }

            //返回和排除列
            if (!CollectionUtils.isEmpty(includeFields) || !CollectionUtils.isEmpty(excludeFields)) {
                sourceBuilder.fetchSource(includeFields, excludeFields);
            }

            SearchRequest request = new SearchRequest();
            //索引
            request.indices(index);
            //各种组合条件
            request.source(sourceBuilder);

            //请求
            log.info(String.format("查询条件：%s",request.source().toString()));
            SearchResponse rp = restHighLevelClient.search(request);

            //解析返回
            if (rp.status() != RestStatus.OK || rp.getHits().getTotalHits() <= 0) {
                return Collections.emptyList();
            }

            //获取source
            return Arrays.stream(rp.getHits().getHits()).map(b -> {
                return b.getSourceAsMap();
            }).collect(Collectors.toList());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.emptyList();
    }
}
