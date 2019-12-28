package com.ehl.tsq.data.infrastructure.persistence.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class ZHCGEnvironmentalCar {
    private Integer id;

    @JSONField(name="id")
    private Integer carId;

    private String vehicleNo;

    private String engineNo;

    private String brandModel;

    private String vehicleLoad;

    private String vehicleTypename;

    private String serviceAreaName;

    private String driverName;

    private String telephone;

    private Date startUpTime;

    private String usefulLife;

    private String sensorId;

    private String enclosureUrl;

    private Integer vehicleState;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo == null ? null : engineNo.trim();
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel == null ? null : brandModel.trim();
    }

    public String getVehicleLoad() {
        return vehicleLoad;
    }

    public void setVehicleLoad(String vehicleLoad) {
        this.vehicleLoad = vehicleLoad == null ? null : vehicleLoad.trim();
    }

    public String getVehicleTypename() {
        return vehicleTypename;
    }

    public void setVehicleTypename(String vehicleTypename) {
        this.vehicleTypename = vehicleTypename == null ? null : vehicleTypename.trim();
    }

    public String getServiceAreaName() {
        return serviceAreaName;
    }

    public void setServiceAreaName(String serviceAreaName) {
        this.serviceAreaName = serviceAreaName == null ? null : serviceAreaName.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getStartUpTime() {
        return startUpTime;
    }

    public void setStartUpTime(Date startUpTime) {
        this.startUpTime = startUpTime;
    }

    public String getUsefulLife() {
        return usefulLife;
    }

    public void setUsefulLife(String usefulLife) {
        this.usefulLife = usefulLife == null ? null : usefulLife.trim();
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId == null ? null : sensorId.trim();
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl == null ? null : enclosureUrl.trim();
    }

    public Integer getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(Integer vehicleState) {
        this.vehicleState = vehicleState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}