package com.ehl.tsq.data.application;

import com.ehl.tsq.data.business.common.vo.BaseResponse;
import com.ehl.tsq.data.business.strategy.statCityManager.StatCMCaseStrategy;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author created by guanchen on 2019/12/20 17:11
 */
@Slf4j
@Validated
@RestController
public class CityManagerController {

    @Autowired
    private StatCMCaseStrategy statCMCaseStrategy;

    @GetMapping("CityManager/statStreetCause")
    public BaseResponse statStreetNum(@RequestParam int year){
        statCMCaseStrategy.statStreetNumYear(year);
        statCMCaseStrategy.statStreetNumMonth();
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }

    @GetMapping("CityManager/statTypeNum")
    public BaseResponse statTypeNum(){
        statCMCaseStrategy.statTypeNum();
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }


    @GetMapping("CityManager/statStatusNum")
    public BaseResponse statStatusNum(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        statCMCaseStrategy.statStatusNum(date);
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }
}
