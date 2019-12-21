package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.Date;

public class CsglDtsjJcyjSjxx {
    private String id;

    private String street;

    private String streetCode;

    private String roadsection;

    private String address;

    private String content;

    private Double x;

    private Double y;

    private String type;

    private String typedesc;

    private String status;

    private String pictureurl;

    private Date warningtime;

    private String istrue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode == null ? null : streetCode.trim();
    }

    public String getRoadsection() {
        return roadsection;
    }

    public void setRoadsection(String roadsection) {
        this.roadsection = roadsection == null ? null : roadsection.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTypedesc() {
        return typedesc;
    }

    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc == null ? null : typedesc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }

    public Date getWarningtime() {
        return warningtime;
    }

    public void setWarningtime(Date warningtime) {
        this.warningtime = warningtime;
    }

    public String getIstrue() {
        return istrue;
    }

    public void setIstrue(String istrue) {
        this.istrue = istrue == null ? null : istrue.trim();
    }
}