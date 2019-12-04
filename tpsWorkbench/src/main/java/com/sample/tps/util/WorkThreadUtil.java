package com.sample.tps.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author created by guanchen on 2019/12/4 15:34
 */
public class WorkThreadUtil {

    private static ExecutorService executorService = Executors.newFixedThreadPool(50);

    public static void doWork(Runnable task){
        if (executorService.isShutdown()){
            executorService = Executors.newFixedThreadPool(200);
        }
        executorService.submit(task);
    }

    public static void stop(){
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
