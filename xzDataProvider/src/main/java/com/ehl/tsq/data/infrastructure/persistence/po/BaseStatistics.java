package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.Date;

public class BaseStatistics {
    private Integer id;

    private String name;

    private String unit;

    private String des;

    private Double value;

    private Double yearOnYear;

    private Double chainRatio;

    private Date date;

    private String region;

    private String isTrue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getYearOnYear() {
        return yearOnYear;
    }

    public void setYearOnYear(Double yearOnYear) {
        this.yearOnYear = yearOnYear;
    }

    public Double getChainRatio() {
        return chainRatio;
    }

    public void setChainRatio(Double chainRatio) {
        this.chainRatio = chainRatio;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue == null ? null : isTrue.trim();
    }
}