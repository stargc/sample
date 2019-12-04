package com.sample.tps.controller;

import com.sample.tps.jobs.ESBulkAddDataJob;
import com.sample.tps.jobs.ESBulkAddDataResultBean;
import com.sample.tps.util.FileUtil;
import com.sample.tps.util.GlobalValueUtil;
import com.sample.tps.workbench.TpsWorkbench;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author created by guanchen on 2019/11/19 9:29
 */
@RestController
@Log4j2
public class TPSController {

    @Autowired
    private ESBulkAddDataJob esBulkAddDataJob;

    @GetMapping("testTps")
    public String testTps(@RequestParam int threadNum, @RequestParam int threadTime, @RequestParam String unit,@RequestParam String resultNum) {
        switch (unit){
            case "hour":
                threadTime = threadTime * 60 * 60;
                break;
            case "min":
                threadTime = threadTime  * 60;
                break;
            case "sec":
                threadTime = threadTime;
                break;
            case "day":
                threadTime = threadTime * 24 * 60 * 60;
                break;
            default:
                return "error unit";
        }
        if (esBulkAddDataJob.isRuning()){
            return "正在运行 ，请稍后再试";
        }

        int finalThreadTime = threadTime;
        String resultTimeFile = System.getProperty("user.dir") + File.separator + "resultTime_" + resultNum + ".txt";
        FileUtil.deleteAllFilesOfDir(new File(resultTimeFile));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    TpsWorkbench tpsWorkbench = new TpsWorkbench();
                    String result = tpsWorkbench.run(threadNum, finalThreadTime,esBulkAddDataJob,resultTimeFile);
                    FileUtil.createInFile(result,System.getProperty("user.dir") + File.separator + "result_" + resultNum + ".txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        String path = System.getProperty("user.dir") + File.separator + "result_" + resultNum + ".txt";
        return "job 已经启动，结果保存在：" + path;
    }

}
