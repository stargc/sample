package com.ehl.ambari.metric.content;

import lombok.extern.log4j.Log4j2;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author created by guanchen on 2019/12/2 11:30
 */
@Service
@Log4j2
public class ESHttpClientServer {

    private static String url = "http://10.150.27.245:9200/_bulk?pretty";
    private static String data = "{\"GCXH\":\"19324ac18fbb410da7356cb9a9331132\",\"KKBH\":\"999\",\"FXLX\":\"9534\",\"CDH\":\"3\",\"GC_RQSJ\":\"2019-11-28 17:10:56\",\"JDCHPZLDM\":\"0\",\"JDCHPHM\":\"冀Ajxazy\",\"JDCHPYSDM\":\"0\",\"CL_SD\":\"17\",\"JDCCSYSDM\":\"0\"}";

    private CloseableHttpClient httpClient = null;
    private HttpPost post = null;
    private CloseableHttpResponse response = null;

    private static ESHttpClientServer mInstance;

    private ESHttpClientServer() {
        init();
    }

    public static ESHttpClientServer getmInstance() {
        if (mInstance == null){
            mInstance = new ESHttpClientServer();
        }
        return mInstance;
    }

    public void init(){
        httpClient = HttpClientBuilder.create().build();
        post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity entity = new StringEntity(data, "utf-8");
        post.setEntity(entity);
    }

    public void destroy(){
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendData() {
        long threadID = Thread.currentThread().getId();
        try {;
            long startTime = System.currentTimeMillis();
            CloseableHttpResponse response = httpClient.execute(post);
            long endTime = System.currentTimeMillis();
            log.info(threadID + "---" + response.getStatusLine().getStatusCode() + "---" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ESHttpClientServer.getmInstance().sendData();
    }
}
