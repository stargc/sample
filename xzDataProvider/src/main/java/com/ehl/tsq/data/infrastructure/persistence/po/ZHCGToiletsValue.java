package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.Date;

public class ZHCGToiletsValue {
    private Integer id;

    private Integer toiletId;

    private String deviceNum;

    private String ch4;

    private String co;

    private String co2;

    private String db;

    private String h2;

    private String h2s;

    private String hcho;

    private String mpa;

    private String nh3;

    private String no;

    private String no2;

    private String noi;

    private String o2;

    private String o3;

    private String pm10;

    private String pm25;

    private String smog;

    private String so2;

    private String spd;

    private String temp;

    private String tsp;

    private String tvoc;

    private String ws;

    private Date createTime;

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

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum == null ? null : deviceNum.trim();
    }

    public String getCh4() {
        return ch4;
    }

    public void setCh4(String ch4) {
        this.ch4 = ch4 == null ? null : ch4.trim();
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co == null ? null : co.trim();
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2 == null ? null : co2.trim();
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2 == null ? null : h2.trim();
    }

    public String getH2s() {
        return h2s;
    }

    public void setH2s(String h2s) {
        this.h2s = h2s == null ? null : h2s.trim();
    }

    public String getHcho() {
        return hcho;
    }

    public void setHcho(String hcho) {
        this.hcho = hcho == null ? null : hcho.trim();
    }

    public String getMpa() {
        return mpa;
    }

    public void setMpa(String mpa) {
        this.mpa = mpa == null ? null : mpa.trim();
    }

    public String getNh3() {
        return nh3;
    }

    public void setNh3(String nh3) {
        this.nh3 = nh3 == null ? null : nh3.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2 == null ? null : no2.trim();
    }

    public String getNoi() {
        return noi;
    }

    public void setNoi(String noi) {
        this.noi = noi == null ? null : noi.trim();
    }

    public String getO2() {
        return o2;
    }

    public void setO2(String o2) {
        this.o2 = o2 == null ? null : o2.trim();
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3 == null ? null : o3.trim();
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10 == null ? null : pm10.trim();
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25 == null ? null : pm25.trim();
    }

    public String getSmog() {
        return smog;
    }

    public void setSmog(String smog) {
        this.smog = smog == null ? null : smog.trim();
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2 == null ? null : so2.trim();
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd == null ? null : spd.trim();
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    public String getTsp() {
        return tsp;
    }

    public void setTsp(String tsp) {
        this.tsp = tsp == null ? null : tsp.trim();
    }

    public String getTvoc() {
        return tvoc;
    }

    public void setTvoc(String tvoc) {
        this.tvoc = tvoc == null ? null : tvoc.trim();
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws == null ? null : ws.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}