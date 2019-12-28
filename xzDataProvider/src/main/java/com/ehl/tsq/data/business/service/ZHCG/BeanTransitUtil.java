package com.ehl.tsq.data.business.service.ZHCG;

import com.ehl.tsq.data.infrastructure.persistence.po.DtsjCsglCsjcssjc;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGEnvironmentalCar;

import java.util.Date;

/**
 * @author created by guanchen on 2019/12/28 12:16
 */
public class BeanTransitUtil {
    public static DtsjCsglCsjcssjc cat2Bean(ZHCGEnvironmentalCar car){
        DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
        bean.setName(car.getVehicleNo());
        bean.setAddress(null);
        bean.setPrincipal(car.getDriverName());
        bean.setTel(car.getTelephone());
        bean.setStreetArea(null);
        bean.setArea(car.getServiceAreaName());
        bean.setUrl(car.getEnclosureUrl());
        bean.setGeometry(null);
        bean.setGeometryType("线");
        bean.setType("环卫车辆");
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode("HWCL");
        bean.setDeviceId(car.getId());
        return bean;
    }
}
