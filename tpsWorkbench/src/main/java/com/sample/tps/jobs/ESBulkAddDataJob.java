package com.sample.tps.jobs;

import com.sample.tps.util.GlobalValueUtil;
import com.sample.tps.util.WorkThreadUtil;
import com.sample.tps.util.FileUtil;
import com.sample.tps.workbench.TpsJob;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @author created by guanchen on 2019/12/4 14:13
 */
@Component
public class ESBulkAddDataJob implements TpsJob{

    private static String data = "{\"GCXH\":\"19324ac18fbb410da7356cb9a9331132\",\"KKBH\":\"999\",\"FXLX\":\"9534\",\"CDH\":\"3\",\"GC_RQSJ\":\"2019-11-28 17:10:56\",\"JDCHPZLDM\":\"0\",\"JDCHPHM\":\"冀Ajxazy\",\"JDCHPYSDM\":\"0\",\"CL_SD\":\"17\",\"JDCCSYSDM\":\"0\"}";

    private RestHighLevelClient restClient = null;
    private BulkRequest request = null;

    private boolean isRunning = false;

    @Override
    public boolean isRuning() {
        return isRunning;
    }

    @Override
    public boolean init() {
        request = new BulkRequest();
        for (int i = 0; i < 20; i++) {
            request.add(new IndexRequest("api_test1", "doc", "1").source(data, XContentType.JSON));
        }

        restClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.28.206.213", 9200, "http")
                        ,new HttpHost("10.28.206.215", 9200, "http")
                        ,new HttpHost("10.28.206.216", 9200, "http")
                )
        );
        isRunning = true;

        return true;
    }

    @Override
    public void execute(String resultFlag) throws Exception {
        String result = "";
        if (!isRunning){
            throw  new RuntimeException("请先执行 init");
        }
        long threadID = Thread.currentThread().getId();
        long useTime = 0;
        int responseCode = 0;
        try {
            long startTime = System.currentTimeMillis();
            BulkResponse responses = restClient.bulk(request, RequestOptions.DEFAULT);
            useTime = (System.currentTimeMillis() - startTime);
            responseCode = responses.status().getStatus();
            result = String.format("threadID<%s>---resultCode<%s>---useTime<%s>",threadID,responseCode,String.valueOf(useTime));
        } catch (Exception e) {
            e.printStackTrace();
            result = String.format("threadID<%s>---resultCode<Exception>---exception<%s>",threadID,e.getMessage());
        }
        System.out.println(result);
        String finalResult = result + "\r\n";

        int finalResponseCode = responseCode;
        long finalUseTime = useTime;
        WorkThreadUtil.doWork(new Runnable() {
            @Override
            public void run() {
                ESBulkAddDataResultBean bean = new ESBulkAddDataResultBean(threadID, finalResponseCode, finalUseTime);
                GlobalValueUtil.addEsBulkResult(bean);
                FileUtil.writeInFile(finalResult,resultFlag);
            }
        });

    }

    @Override
    public boolean destory() {
        isRunning = false;
        if (restClient != null){
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
