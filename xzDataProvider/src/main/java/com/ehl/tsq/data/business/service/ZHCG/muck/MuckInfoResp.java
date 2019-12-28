package com.ehl.tsq.data.business.service.ZHCG.muck;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGMuckCar;
import lombok.Data;

import java.util.List;

/**
 * @author created by guanchen on 2019/12/28 16:26
 */
@Data
public class MuckInfoResp {
    private Integer value;
    private String name;
    private Double longitude;
    private Double latitude;
    private Integer isParent;
    private Integer state;
    private List<MuckInfoResp> children;

    public ZHCGMuckCar bean2Car(){
        ZHCGMuckCar car = new ZHCGMuckCar();
        car.setCarId(this.getValue());
        car.setIsparent(this.getIsParent());
        car.setLatitude(this.getLatitude());
        car.setLongitude(this.getLongitude());
        car.setName(this.getName());
        car.setVehicleState(this.getState());
        return car;
    }
}
