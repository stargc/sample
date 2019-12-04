package com.sample.tps.workbench;

import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.sample.tps.jobs.ESBulkAddDataJob;
import com.google.common.math.LongMath;
import com.sample.tps.jobs.ESBulkAddDataResultBean;
import com.sample.tps.util.GlobalValueUtil;
import com.sample.tps.util.WorkThreadUtil;

/**
 * 每秒事物执行次数统计
 *
 * @author Xie le
 * @date 2016/7/9
 */
public class TpsWorkbench {

    public int N_THRESHOLDS = 5;
    public int TIME_THRESHOLDS = 30;

    private AtomicInteger totalTime = null;
    private AtomicLong totalExecCount = new AtomicLong(0L);
    private CyclicBarrier barrier = null;
    private CountDownLatch countDownLatch = null;
    private volatile boolean runnning = true;

    private ExecutorService executorService;

        class Worker implements Runnable {

        private TpsJob job;
        private String ResultFlag;

        Worker(TpsJob job,String ResultFlag) {
            this.job = job;
            this.ResultFlag = ResultFlag;
        }

        // 每个线程执行的事物统计量
        int innerCount = 0;

        public void run() {
            try {
                barrier.await(); // 等到所有线程都在起跑线
                while (runnning) {
                    this.job.execute(ResultFlag);
                    innerCount++;
                }
            } catch (Exception e) {
                System.out.println("线程Id：" + Thread.currentThread().getId() + " " + e.getMessage());
            } finally {
                // 累加到总记录统计量
                totalExecCount.getAndAdd(innerCount);
                // 线程结束后，依次计数, 便于主线程继续执行
                countDownLatch.countDown();
            }
        }
    }

    private void init(int runThreadNum, int runTimeSecond,TpsJob job) {
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
        job.init();
    }

    public String run(int runThreadNum, int runTimeSecond,TpsJob job,String resultFlag) throws Exception {
        init(runThreadNum, runTimeSecond,job);

        for (int i = 0; i < N_THRESHOLDS; i++) {
            executorService.submit(new Worker(job,resultFlag)); // 提交线程到池子中
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


        executorService.shutdownNow(); // 关闭线程池
        job.destory();

        return result(totalExeCount);

    }

    private String result(long totalExeCount){
        StringBuilder sb = new StringBuilder();
        long tps = LongMath.divide(totalExeCount, TIME_THRESHOLDS, RoundingMode.HALF_EVEN);

        sb.append(N_THRESHOLDS).append(" 个线程，")
                .append(TIME_THRESHOLDS).append(" 秒内总共执行的事务数量：").append(totalExeCount)
                .append("\r\n").append("执行的TPS: ").append(tps).append("\r\n");

        List<ESBulkAddDataResultBean> resultList = GlobalValueUtil.getEsBulkResult();
        double max = resultList.stream().mapToDouble(ESBulkAddDataResultBean::getResponseTime).max().getAsDouble();
        double min = resultList.stream().mapToDouble(ESBulkAddDataResultBean::getResponseTime).min().getAsDouble();
        double avg = resultList.stream().mapToDouble(ESBulkAddDataResultBean::getResponseTime).average().getAsDouble();

        sb.append(String.format("消耗时间统计：min(%s秒),max(%s秒),avg(%s秒）",
                Math.round(min),Math.round(max),Math.round(avg)))
                .append("\r\n");

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        ESBulkAddDataJob esJob = new ESBulkAddDataJob();
        TpsWorkbench tpsWorkbench = new TpsWorkbench();
        tpsWorkbench.run(100, 2,esJob,"1");

        WorkThreadUtil.stop();
    }

}

