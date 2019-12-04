package com.ehl.ambari.metric.content;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author created by guanchen on 2019/12/2 9:51
 */
@Log4j2
public class ESRestClientServer {
    private static String data = "{\"GCXH\":\"19324ac18fbb410da7356cb9a9331132\",\"KKBH\":\"999\",\"FXLX\":\"9534\",\"CDH\":\"3\",\"GC_RQSJ\":\"2019-11-28 17:10:56\",\"JDCHPZLDM\":\"0\",\"JDCHPHM\":\"冀Ajxazy\",\"JDCHPYSDM\":\"0\",\"CL_SD\":\"17\",\"JDCCSYSDM\":\"0\"}";

    private RestHighLevelClient restClient = null;
    private BulkRequest request = null;


    private static ESRestClientServer mInstance;

    private boolean isRunning = false;

    private ESRestClientServer() {
    }

    public boolean isRunning() {
        return isRunning;
    }

    public static ESRestClientServer getmInstance() {
        if (mInstance == null){
            System.out.println("do  init =============================================================");
            mInstance = new ESRestClientServer();
        }
        return mInstance;
    }
    public void init(){

        request = new BulkRequest();
        request.add(new IndexRequest("api_test", "doc", "1").source(data, XContentType.JSON));

        restClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.28.206.213", 9200, "http")
                        ,new HttpHost("10.28.206.215", 9200, "http")
                        ,new HttpHost("10.28.206.216", 9200, "http")
                )
        );
        isRunning = true;
    }

    public void destroy(){
        isRunning = false;
        if (restClient != null){
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addData() {
        if (!isRunning){
            throw  new RuntimeException("请先执行 init");
        }
        long threadID = Thread.currentThread().getId();

        try {
            long startTime = System.currentTimeMillis();
            BulkResponse responses = restClient.bulk(request,RequestOptions.DEFAULT);
            log.info(threadID + "----" + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ESRestClientServer.getmInstance().init();
        for (int i = 0; i < 1; i++) {
            ESRestClientServer.getmInstance().addData();
        }
        ESRestClientServer.getmInstance().destroy();
    }

}
