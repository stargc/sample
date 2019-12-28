package com.ehl.tsq.data.business.service.ZHCG;

import com.ehl.tsq.data.infrastructure.persistence.po.*;

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

    public static DtsjCsglCsjcssjc toilet2Bean(ZHCGToilets toilet){
        DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
        bean.setName(toilet.getName());
        bean.setAddress(toilet.getAddress());
        bean.setPrincipal(toilet.getOwner());
        bean.setTel(toilet.getTelephone());
        bean.setStreetArea(toilet.getStreetName());
        bean.setArea(toilet.getRoadName());
        bean.setUrl(toilet.getEnclosureUrl());
        bean.setGeometry("("+toilet.getLongitude() + "," + toilet.getLatitude() + ")");
        bean.setGeometryType("点");
        bean.setType("公厕");
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode("GC");
        bean.setDeviceId(toilet.getId());
        return bean;
    }

    public static DtsjCsglCsjcssjc station2Bean(ZHCGStations station){
        DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
        bean.setName(station.getName());
        bean.setAddress(station.getAddress());
        bean.setPrincipal(station.getOwner());
        bean.setTel(station.getTelephone());
        bean.setStreetArea(null);
        bean.setArea(null);
        bean.setUrl(station.getEnclosureUrl());
        bean.setGeometry("("+station.getLongitude() + "," + station.getLatitude() + ")");
        bean.setGeometryType("点");
        bean.setType("中转站");
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode("ZZZ");
        bean.setDeviceId(station.getId());
        return bean;
    }

    public static DtsjCsglCsjcssjc trash2Bean(ZHCGTrash trash){
        DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
        bean.setName(trash.getNumber());
        bean.setAddress(trash.getAddress());
        bean.setPrincipal(trash.getOwner());
        bean.setTel(trash.getTelephone());
        bean.setStreetArea(trash.getStreetName());
        bean.setArea(trash.getRoadName());
        bean.setUrl(trash.getEnclosureUrl());
        bean.setGeometry("("+trash.getLongitude() + "," + trash.getLatitude() + ")");
        bean.setGeometryType("点");
        bean.setType("垃圾桶");
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode("GC");
        bean.setDeviceId(trash.getId());
        return bean;
    }
}
