package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.Date;

public class ZHCGToilets {
    private Integer id;

    private Integer toiletId;

    private String name;

    private String address;

    private String streetName;

    private String roadName;

    private Integer streetId;

    private Integer roadId;

    private String owner;

    private String telephone;

    private Double longitude;

    private Double latitude;

    private String sensorIdMan;

    private String sensorDWoman;

    private String enclosureUrl;

    private String warning;

    private Date warningTime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToiletId() {
        return toiletId;
    }

    public void setToiletId(Integer toiletId) {
        this.toiletId = toiletId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName == null ? null : streetName.trim();
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName == null ? null : roadName.trim();
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getRoadId() {
        return roadId;
    }

    public void setRoadId(Integer roadId) {
        this.roadId = roadId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getSensorIdMan() {
        return sensorIdMan;
    }

    public void setSensorIdMan(String sensorIdMan) {
        this.sensorIdMan = sensorIdMan == null ? null : sensorIdMan.trim();
    }

    public String getSensorDWoman() {
        return sensorDWoman;
    }

    public void setSensorDWoman(String sensorDWoman) {
        this.sensorDWoman = sensorDWoman == null ? null : sensorDWoman.trim();
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl == null ? null : enclosureUrl.trim();
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning == null ? null : warning.trim();
    }

    public Date getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Date warningTime) {
        this.warningTime = warningTime;
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