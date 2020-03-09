package com.stargc.sample.es.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.stargc.sample.es.entity.LogInfo;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class ESIndexService {

    @Resource
    RestHighLevelClient restHighLevelClient;

    private static final String TYPE = "properties";

    public boolean createIndex(String indexName,Class classType){
//        CreateIndexRequest request = new CreateIndexRequest(indexName);
//        request.settings(Settings.builder()
//                .put("index.number_of_shards", 3)
//                .put("index.number_of_replicas", 2)
//        );
//
//        Map<String, Object> properties = Maps.newHashMap();
//        Arrays.stream(classType.getDeclaredFields()).forEach(field -> {
//            String type = javaType2EsType(field.getType().toString());
//            Map<String, Object> keyProperties = Maps.newHashMap();
//            keyProperties.put("type",type);
//            keyProperties.put("store", "yes");
//            if ("data".equals(type)){
//                keyProperties.put("format","yyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis");
//            }
//            properties.put(field.getName(),keyProperties);
//        });
//
//        Map<String,Object> mapping = ImmutableMap.<String, Object>builder().
//                put(TYPE,properties).build();
//
//        request.mapping(mapping);
//        log.info(JSON.toJSONString(mapping));
//
//        CreateIndexResponse createIndexResponse = null;
//        try {
//            createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
//        } catch (IOException e) {
//            log.error(e);
//        }
//        return createIndexResponse.isAcknowledged();


        try {
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("properties")
                    .startObject()
//                    .field("name").startObject().field("index", "true").field("type", "string").endObject()
//                    .field("age").startObject().field("index", "true").field("type", "integer").endObject()
                    .field("money")
//                    .field("address").startObject().field("index", "true").field("type", "text").field("analyzer", "ik_max_word").endObject()
//                    .field("birthday").startObject().field("index", "true").field("type", "date").field("format", "strict_date_optional_time||epoch_millis").endObject()
                    .endObject()
                    .endObject();
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
            createIndexRequest.mapping(builder);
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            return createIndexResponse.isAcknowledged();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    private String javaType2EsType(String typeString){
        switch (typeString){
            case "class java.lang.String":
                return "text";
            case "class java.lang.Long":
            case "long":
                return "long";
            case "class java.util.Date":
                return "date";
            default:
                return "keyword";
        }
    }

    /**
     * 判断索引是否存在
     *
     * @param indexName
     * @return
     */
    public boolean isIndexExists(String indexName) {
        boolean exists = false;
        try {
            GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
            getIndexRequest.humanReadable(true);
            exists = restHighLevelClient.indices().exists(getIndexRequest,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exists;
    }

    /**
     * 删除索引
     *
     * @param indexName
     * @return
     */
    public boolean deleteIndex(String indexName) {
        boolean acknowledged = false;
        try {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
            deleteIndexRequest.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);
            AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            acknowledged = delete.isAcknowledged();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acknowledged;
    }

}
