package com.ehl.tsq.data.application;

import com.ehl.tsq.data.business.service.statCityManager.StatCMCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author created by guanchen on 2019/12/20 15:22
 */
@Service
@Slf4j
public class CityManagerJob {

    @Autowired
    private StatCMCaseService statCMCaseService;

    /***
     * 案件高发地
     */
//    @Scheduled(cron = "0 30 * * * ?")
    public void statStreetNum(){
        statCMCaseService.statStreetNumYear(2019);
        statCMCaseService.statStreetNumMonth();
    }

    /***
     * 类型 top5
     */
//    @Scheduled(cron = "0 30 * * * ?")
    public void statTypeTop5Num(){
        statCMCaseService.statTypeTop5Num();
    }

    /***
     * 更新当日案件进度数量
     */
//    @Scheduled(cron = "0 30 * * * ?")
    public void statStatusNum(){
        statCMCaseService.statStatusNum(null);
    }

    /***
     * 上报案件分类
     */
//    @Scheduled(cron = "0 30 * * * ?")
    public void statTypeNum(){
        statCMCaseService.statTypeNum(0,0);
    }

    /***
     * 统计当月 当年上报实时动态
     */
//    @Scheduled(cron = "0 30 * * * ?")
    public void statCauseNum(){
        statCMCaseService.statCauseNumByDay(null);
        statCMCaseService.statCauseNumByMonth(null);
    }
}
