package com.ehualu.data.business.delivery.controller;

import com.ehualu.data.business.delivery.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author created by guanchen on 2020/3/19 14:17
 */
@Component
@Slf4j
public class DeliveryJob {

    @Autowired
    private DeliveryService deliveryService;
    /***
     * 案件高发地
     */
//    @Scheduled(cron = ""0 30 0 * * ?")// 每天中午12点触发
    public void deleteOverdue(){
        deliveryService.deleteOverdue();
    }
}
