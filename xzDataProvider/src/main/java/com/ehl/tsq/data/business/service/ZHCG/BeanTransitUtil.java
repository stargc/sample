package com.ehl.tsq.data.business.service.ZHCG;

import com.ehl.tsq.data.business.service.ZHCG.vo.DeviceTypeCodeEnum;
import com.ehl.tsq.data.infrastructure.persistence.po.*;

import java.util.Date;

/**
 * @author created by guanchen on 2019/12/28 12:16
 */
public class BeanTransitUtil {
    private BeanTransitUtil(){
        throw new IllegalStateException("Utility class");
    }
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
        bean.setType(DeviceTypeCodeEnum.HWCL.getName());
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode(DeviceTypeCodeEnum.HWCL.getCode());
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
        bean.setType(DeviceTypeCodeEnum.GC.getName());
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode(DeviceTypeCodeEnum.GC.getCode());
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
        bean.setType(DeviceTypeCodeEnum.ZZZ.getName());
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode(DeviceTypeCodeEnum.ZZZ.getCode());
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
        bean.setType(DeviceTypeCodeEnum.LJT.getName());
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode(DeviceTypeCodeEnum.LJT.getCode());
        bean.setDeviceId(trash.getId());
        return bean;
    }
    public static DtsjCsglCsjcssjc muckCat2Bean(ZHCGMuckCar car){
        DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
        bean.setName(car.getName());
        bean.setAddress(null);
        bean.setPrincipal(null);
        bean.setTel(null);
        bean.setStreetArea(null);
        bean.setArea(null);
        bean.setUrl(null);
        bean.setGeometry("("+car.getLongitude() + "," + car.getLatitude() + ")");
        bean.setGeometryType("点");
        bean.setType(DeviceTypeCodeEnum.ZTC.getName());
        bean.setDate(new Date());
        bean.setWarning(null);
        bean.setWarningTime(null);
        bean.setIsTrue("TRUE");
        bean.setTypeCode(DeviceTypeCodeEnum.ZTC.getCode());
        bean.setDeviceId(car.getId());
        return bean;
    }
}
