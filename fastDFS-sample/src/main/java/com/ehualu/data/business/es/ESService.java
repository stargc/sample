package com.ehualu.data.business.es;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpStatus;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author created by guanchen on 2020/10/10 17:23
 */
@Slf4j
@Service
public class ESService {
    @Autowired
    private RestHighLevelClient client;

    /**
     * 查看index是否存在
     * @param index
     * @return
     */
    public boolean exitHighIndex(String index) {
        GetIndexRequest request = new GetIndexRequest();
        try {
            request.indices(index);
            boolean exits = client.indices().exists(request, RequestOptions.DEFAULT);
            if (exits){
                log.info("Check index successful,index is exist : " + index);
                return true;
            }else {
                log.info("index is not exist : " + index);
                return false;
            }
        } catch (IOException e) {
            log.error("Check index failed, exception occurred.",e);
        }
        return false;
    }

    /**
     * 创建index
     * @param index
     */
    public void createHighIndexWithShardNum(String index){
        CreateIndexRequest request = new CreateIndexRequest(index);
        request.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 5));
//        request.mapping("{\"properties\":{\"name\":{\"type\":\"text\"},\"author\":{\"type\":\"text\"},\"pubinfo\":{\"type\":\"text\"},\"pubtime\":{\"type\":\"text\"},\"desc\":{\"type\":\"text\"}}", XContentType.JSON);

        try {
            CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
            if (response.isAcknowledged()){
                System.out.println("CreateIndexWithShardNum successful.");
            }else {
                log.error("CreateIndexWithShardNum failed.");
            }
            log.info("CreateIndexWithShardNum response entity is : " + response.index());
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    /**
     * 插入数据
     */
    public void putHighData(String index,String id) {
        String jsonString = "{" + "\"name\":\"Happy\"," + "\"author\":\"Alex Yang \","
                + "\"pubinfo\":\"Beijing,China. \"," + "\"pubtime\":\"2016-07-16\","
                + "\"desc\":\"Elasticsearch is a highly scalable open-source full-text search and analytics engine.\""
                + "}";
        IndexRequest request = new IndexRequest(index,"doc",id);
        request.source(jsonString, XContentType.JSON);
        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            if (HttpStatus.SC_OK == indexResponse.status().getStatus()|| HttpStatus.SC_CREATED==indexResponse.status().getStatus()){
                System.out.println("PutData successful.");
            }else {
                log.error("PutData failed.");
            }
            log.info("PutData response entity is : " + indexResponse.getResult());
        } catch (IOException e) {
            log.error("PutData failed, exception occurred.",e);
        }
    }

    /**
     * 查询数据
     */
    public String queryData(String index,String id){
        GetRequest request = Requests.getRequest(index).id(id);
        try {
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            if (response.isExists()){
                System.out.println("QueryData successful.");
            }else {
                log.error("QueryData failed.");
            }
            log.info("QueryData response entity is : " + response.getSourceAsString());
            return response.getSourceAsString();
        } catch (IOException e) {
            log.error("QueryData failed, exception occurred.",e);
        }
        return "ERROR";
    }
}
