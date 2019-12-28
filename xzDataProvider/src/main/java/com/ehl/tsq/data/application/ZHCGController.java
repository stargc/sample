package com.ehl.tsq.data.application;

import com.ehl.tsq.data.business.common.vo.BaseResponse;
import com.ehl.tsq.data.business.service.ZHCG.vehicles.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对接智慧城管
 * @author created by guanchen on 2019/12/28 10:25
 */
@Slf4j
@Validated
@RestController
public class ZHCGController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("ZHCG/getVehicles")
    public BaseResponse getVehicles(){
        vehicleService.queryVehicleInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

    @GetMapping("ZHCG/getVehicleTrack")
    public BaseResponse getVehicleTrack(){
        vehicleService.queryVehicleTrack();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
}
