package com.ehl.tsq.data.business.service.test;

import com.ehl.tsq.data.business.common.vo.BaseResponse;
import com.ehl.tsq.data.infrastructure.persistence.mapper.BaseStatisticsMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatistics;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatisticsExample;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author guanchen
 * @version $Id TestService.java, v 0.1 2019-04-23 10:58 star Exp $$
 */
@Service
@Slf4j
public class TestSservice {

    @Value("${testValue}")
    private String testValue;

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private BaseStatisticsMapper baseStatisticsMapper;

    public BaseResponse doTest(){
        log.info(testValue);
        BaseResponse response = new BaseResponse();
        response.setResultCode(BaseResponse.SUCCESS);
        response.setResultMsg("SUCCESS：" + testValue);
        BaseStatisticsExample example = new BaseStatisticsExample();
        example.createCriteria().andNameEqualTo("SY-SCJG-YPAQ-HGL");
        List<BaseStatistics> ad = baseStatisticsMapper.selectByExample(example);
        return response;
    }


    public BaseResponse restTest(String phone){
        String url = String.format("http://apis.juhe.cn/mobile/get?phone=%s&key=b8c3c0asdwab284ca6cd9a51fee15c76",phone);
        String result = restTemplate.getForObject(url,String.class);

        BaseResponse response = new BaseResponse();
        response.setResultCode(BaseResponse.SUCCESS);
        response.setResultMsg(result);
        return response;
    }

    @Cacheable(value = "IZUUL", key = "#key")
    public String cacheTest(String key) {
        log.info("cacheIZUUL()方法执行");
        return getCache(key);
    }

    @CachePut(value = "IZUUL", key = "#key")
    public String cachePutTest(String key) {
        log.info("cachePutIZUUL()方法执行");
        return "cachePutIZUUL--" + key;
    }
    private String getCache(String key) {
        try {
            log.info("getCache()方法执行");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return key;
    }

    public String caffeineTest(String key){
        LoadingCache<String, String> build = Caffeine.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key)  {
                        return "aaa";
                    }
                });
        String a = build.get(key);
        build.refresh(key);
        build.invalidateAll();
        return a;
    }
}
