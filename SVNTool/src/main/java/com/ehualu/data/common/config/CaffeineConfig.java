package com.ehualu.data.common.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author created by guanchen on 2020/03/18
 * 驱逐策略: 基于大小(200MB) + 基于时间(1天)
 */
@Configuration
@EnableCaching
public class CaffeineConfig {

    public enum CacheType {
        SVNCONFIG(1),
        SVNMANAGER(1)
        ;

        private int expires;
        CacheType(int expires) {
            this.expires = expires;
        }

        public int getExpires() {
            return expires;
        }
    }

    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caffeineCaches = new ArrayList<>();
        for (CacheType cacheType : CacheType.values()) {
            caffeineCaches.add(new CaffeineCache(cacheType.name(),
                    Caffeine.newBuilder()
                            // cache的初始容量值
                            .initialCapacity(100)
                            // maximumSize用来控制cache的最大缓存数量
                            .maximumSize(200)
                            .expireAfterWrite(cacheType.getExpires(), TimeUnit.DAYS)
                            .build()));
        }
        cacheManager.setCaches(caffeineCaches);
        return cacheManager;
    }
}
