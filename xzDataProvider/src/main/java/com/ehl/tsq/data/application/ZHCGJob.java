package com.ehl.tsq.data.application;

import com.ehl.tsq.data.business.common.vo.BaseResponse;
import com.ehl.tsq.data.business.service.ZHCG.muck.MuckService;
import com.ehl.tsq.data.business.service.ZHCG.station.StationsService;
import com.ehl.tsq.data.business.service.ZHCG.toilets.ToiletService;
import com.ehl.tsq.data.business.service.ZHCG.trash.TrasheService;
import com.ehl.tsq.data.business.service.ZHCG.vehicles.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author created by guanchen on 2019/12/29 10:30
 */
@Component
@Slf4j
public class ZHCGJob {
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

//    @Scheduled(cron = "0 0 23 ? * MON")//每次周一 晚上23点 运行一次
    public BaseResponse getVehicles(){
        vehicleService.queryVehicleInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

    @Scheduled(cron = "0 0 20 ? * *")
    public BaseResponse getVehicleTrack(){
        vehicleService.queryVehicleTrack();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

//    @Scheduled(cron = "0 0 23 ? * MON")
    public BaseResponse gettoilet(){
        toiletService.queryToiletInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

//    @Scheduled(cron = "0 0 23 ? * MON")
    public BaseResponse getStation(){
        stationsService.queryStationInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

//    @Scheduled(cron = "0 0 23 ? * MON")
    public BaseResponse getTrashe(){
        trasheService.queryTransheInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

//    @Scheduled(cron = "0 0 23 ? * MON")
    public BaseResponse queryMuckCarInfo(){
        muckService.queryMuckCarInfo();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

//    @Scheduled(cron = "0 0 23 ? * MON")
    public BaseResponse queryMuckCarTrack(){
        muckService.queryMuckCarTrack();
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }
}
