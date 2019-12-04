package com.ehl.ambari.metric.workbench;

import java.math.RoundingMode;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.ehl.ambari.metric.content.ESHttpClientServer;
import com.ehl.ambari.metric.content.ESRestClientServer;
import com.google.common.math.LongMath;

/**
 * 每秒事物执行次数统计
 *
 * @author Xie le
 * @date 2016/7/9
 */
public class TpsWorkbench {

    /**
     * 线程数量
     */
    public int N_THRESHOLDS = 5;

    /**
     * 30 秒总时间
     */
    public int TIME_THRESHOLDS = 30;

    /**
     * 用原子变量来统计执行时间，便于作原子递减
     */
    private AtomicInteger totalTime = null;

    /**
     * 用于统计执行的事物总数，用原子方式累加记录
     */
    private AtomicLong totalExecCount = new AtomicLong(0L);

    /**
     * 需要到等到所有线程都在同一起跑线，才开始统计计数，类似于发令枪
     */
    private CyclicBarrier barrier = null;

    /**
     * 执行时间到达时，所有的线程需要依次退出，主线程才开始统计执行事物总数
     */
    private CountDownLatch countDownLatch = null;

    /**
     * 线程执行标记 , 用volatile修饰，使变量修改具有线程可见性
     */
    private volatile boolean runnning = true;

    /**
     * 用线程池来执行统计
     */
    private ExecutorService executorService;

    /**
     * 用接口来作模拟统计
     */
    interface Job {
        void execute() throws Exception;
    }

    /**
     * 具体Job，模拟完成一次Http请求 BTW:内部类用static修饰
     */
    class JobDetail implements Job {

        public void execute() throws Exception {
            ESRestClientServer.getmInstance().addData();
//            ESHttpClientServer.getmInstance().sendData();
        }
    }

    /**
     * Worker执行Job
     */
    class Worker implements Runnable {

        private Job job;

        Worker(Job job) {
            this.job = job;
        }

        // 每个线程执行的事物统计量
        int innerCount = 0;

        public void run() {
            try {
                barrier.await(); // 等到所有线程都在起跑线
                while (runnning) {
                    this.job.execute();
                    innerCount++;
                }
            } catch (Exception e) {
                System.out.println("线程Id：" + Thread.currentThread().getId() + " " + e.getMessage());
            } finally {
                // 累加到总记录统计量
                System.out.println("线程Id：" + Thread.currentThread().getId() + " 执行事物次数为：" + innerCount);
                totalExecCount.getAndAdd(innerCount);
                // 线程结束后，依次计数, 便于主线程继续执行
                countDownLatch.countDown();
            }
        }
    }

    private void init(int runThreadNum, int runTimeSecond) {
        N_THRESHOLDS = runThreadNum;
        TIME_THRESHOLDS = runTimeSecond;

        //需要到等到所有线程都在同一起跑线，才开始统计计数，类似于发令枪
        barrier = new CyclicBarrier(N_THRESHOLDS);

        //执行时间到达时，所有的线程需要依次退出，主线程才开始统计执行事物总数
        countDownLatch = new CountDownLatch(N_THRESHOLDS);

        // 新建固定大小线程的池子
        executorService = Executors.newFixedThreadPool(N_THRESHOLDS);

        //用原子变量来统计执行时间，便于作原子递减
        totalTime = new AtomicInteger(TIME_THRESHOLDS);
    }

    public String run(int runThreadNum, int runTimeSecond) throws Exception {
        init(runThreadNum, runTimeSecond);
        Job job = new JobDetail(); // 创建Job
        for (int i = 0; i < N_THRESHOLDS; i++) {
            executorService.submit(new Worker(job)); // 提交线程到池子中
        }
        // 还需要一个线程，用于周期检查执行时间是否到达
        final ScheduledExecutorService scheduledExcutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExcutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (totalTime.decrementAndGet() == 0) { // 执行时间递减到0
                    runnning = false; // 告诉线程，时间到了，所有线程不再执行
                    scheduledExcutor.shutdownNow();
                }
            }
        }, 1L, 1L, TimeUnit.SECONDS);

        // 主线程等到所有的线程都退出，则开始统计
        countDownLatch.await();

        long totalExeCount = totalExecCount.get();

        StringBuilder sb = new StringBuilder();
        long tps = LongMath.divide(totalExeCount, TIME_THRESHOLDS, RoundingMode.HALF_EVEN);
        executorService.shutdownNow(); // 关闭线程池

        sb.append(N_THRESHOLDS).append(" 个线程，")
                .append(TIME_THRESHOLDS).append(" 秒内总共执行的事物数量：").append(totalExeCount)
                .append("\r\n").append("执行的TPS: ").append(tps);
        System.out.println(sb);

        return sb.toString();

    }

    public static void main(String[] args) throws Exception {
        ESHttpClientServer.getmInstance();
        ESRestClientServer.getmInstance();

        TpsWorkbench tpsWorkbench = new TpsWorkbench();
        tpsWorkbench.run(1, 1);


        ESHttpClientServer.getmInstance().destroy();
        ESRestClientServer.getmInstance().destroy();
    }

}

