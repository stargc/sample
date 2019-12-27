package com.ehl.tsq.data.application;

import com.ehl.tsq.data.business.common.vo.BaseResponse;
import com.ehl.tsq.data.business.service.mock.MockService;
import com.ehl.tsq.data.business.service.statCityManager.StatCMCaseService;
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
    private StatCMCaseService statCMCaseService;

    @Autowired
    private MockService mockService;

    @GetMapping("CityManager/statStreetCause")
    public BaseResponse statStreetNum(@RequestParam int year){
        statCMCaseService.statStreetNumYear(year);
        statCMCaseService.statStreetNumMonth();
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }

    @GetMapping("CityManager/statTypeTop5Num")
    public BaseResponse statTypeTop5Num(){
        statCMCaseService.statTypeTop5Num();
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }

    @GetMapping("CityManager/statStatusNum")
    public BaseResponse statStatusNum(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        statCMCaseService.statStatusNum(date);
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }

    @GetMapping("CityManager/statTypeNum")
    public BaseResponse statTypeNum(@RequestParam int year,@RequestParam int month){
        statCMCaseService.statTypeNum(year,month);
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }

    @GetMapping("CityManager/statCauseNum")
    public BaseResponse statCauseNum(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        statCMCaseService.statCauseNumByDay(date);
        statCMCaseService.statCauseNumByMonth(date);
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }

    @GetMapping("mock/CityManager/breakDevice")
    public BaseResponse breakDevice(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        mockService.breakDevice(date);
        return new BaseResponse(BaseResponse.SUCCESS,"Success");
    }
}
