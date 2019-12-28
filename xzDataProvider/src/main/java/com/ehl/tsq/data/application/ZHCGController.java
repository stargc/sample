package com.ehl.tsq.data.application;

import com.ehl.tsq.data.business.common.vo.BaseResponse;
import com.ehl.tsq.data.business.service.ZHCG.muck.MuckService;
import com.ehl.tsq.data.business.service.ZHCG.station.StationsService;
import com.ehl.tsq.data.business.service.ZHCG.toilets.ToiletService;
import com.ehl.tsq.data.business.service.ZHCG.trashe.TrasheService;
import com.ehl.tsq.data.business.service.ZHCG.vehicles.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.Oneway;

/**
 * 对接智慧城管
 * @author created by guanchen on 2019/12/28 10:25
 */
@RestController
public class ZHCGController {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ToiletService toiletService;
    @Autowired
    private StationsService stationsService;
    @Autowired
    private TrasheService trasheService;
    @Autowired
    private MuckService muckService;

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
    @GetMapping("ZHCG/gettoilet")
    public BaseResponse gettoilet(){
        toiletService.queryToiletInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
    @GetMapping("ZHCG/getStation")
    public BaseResponse getStation(){
        stationsService.queryStationInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
    @GetMapping("ZHCG/getTrashe")
    public BaseResponse getTrashe(){
        trasheService.queryTransheInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
    @GetMapping("ZHCG/queryMuckCarInfo")
    public BaseResponse queryMuckCarInfo(){
        muckService.queryMuckCarInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
    @GetMapping("ZHCG/queryMuckCarTrack")
    public BaseResponse queryMuckCarTrack(){
        muckService.queryMuckCarTrack();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
}
