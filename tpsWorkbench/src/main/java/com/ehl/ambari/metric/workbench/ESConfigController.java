package com.ehl.ambari.metric.workbench;

import com.ehl.ambari.metric.content.ESRestClientServer;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author created by guanchen on 2019/11/19 9:29
 */
@RestController
@Log4j2
public class ESConfigController {


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
        if (ESRestClientServer.getmInstance().isRunning()){
            return "正在运行 ，请稍后再试";
        }

        int finalThreadTime = threadTime;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ESRestClientServer.getmInstance().init();

                    TpsWorkbench tpsWorkbench = new TpsWorkbench();
                    String result = tpsWorkbench.run(threadNum, finalThreadTime);

                    loadFile(result,resultNum);

                    ESRestClientServer.getmInstance().destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        String path = System.getProperty("user.dir") + File.separator + "result_" + resultNum + ".txt";
        return "job 已经启动，结果保存在：" + path;
    }

    private void loadFile(String sb,String resultNum){
        try {
            FileOutputStream fileOutputStream = null;
            File file = new File(System.getProperty("user.dir") + File.separator + "result_" + resultNum + ".txt");
            System.out.println(file.getPath());
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(sb.getBytes("utf-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
