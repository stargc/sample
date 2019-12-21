package com.ehl.tsq.data.application;

import com.ehl.tsq.data.infrastructure.persistence.mapper.CsglDtsjJcyjSjxxMapper;
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


    @Scheduled(cron = "0/5 * * * * ?")
    public void statCityManagerCase(){

    }
}
