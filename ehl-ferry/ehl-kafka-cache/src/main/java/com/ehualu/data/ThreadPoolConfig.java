package com.ehualu.data;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author created by guanchen on 2019/12/30 16:37
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {

    @Value("${ehl.kafka.threadPool.corePoolSize}")
    private int corePoolSize;
    @Value("${ehl.kafka.threadPool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${ehl.kafka.threadPool.queueCapacity}")
    private int queueCapacity;
    @Value("${ehl.kafka.threadPool.keepAliveSeconds}")
    private int keepAliveSeconds;

    @Override
    @Bean(value = "kafkaThreadExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 常驻核心线程数，低于这个数，新建线程,如果大于0，即使本地任务执行完也不会被销毁
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        // 最大线程池
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        // 持有等待执行的任务队列大小
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        // 空闲线程的存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        // 配置线程池中的线程的名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("ehl-kafka-thread-");
        // 该属性用来控制是否允许核心线程超时退出,true:核心线程等待时间超过限制后，销毁。
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);

        // 任务执行策略-处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}
