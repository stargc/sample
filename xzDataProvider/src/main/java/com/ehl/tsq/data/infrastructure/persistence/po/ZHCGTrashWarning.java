package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.Date;

public class ZHCGTrashWarning {
    private Integer id;

    private Integer trashId;

    private String trashSensorId;

    private String version;

    private String cmd;

    private Integer sequence;

    private Integer rssi;

    private Integer distance;

    private Integer passTime;

    private Integer battary;

    private Integer temperature;

    private Integer full;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrashId() {
        return trashId;
    }

    public void setTrashId(Integer trashId) {
        this.trashId = trashId;
    }

    public String getTrashSensorId() {
        return trashSensorId;
    }

    public void setTrashSensorId(String trashSensorId) {
        this.trashSensorId = trashSensorId == null ? null : trashSensorId.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd == null ? null : cmd.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getPassTime() {
        return passTime;
    }

    public void setPassTime(Integer passTime) {
        this.passTime = passTime;
    }

    public Integer getBattary() {
        return battary;
    }

    public void setBattary(Integer battary) {
        this.battary = battary;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getFull() {
        return full;
    }

    public void setFull(Integer full) {
        this.full = full;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}