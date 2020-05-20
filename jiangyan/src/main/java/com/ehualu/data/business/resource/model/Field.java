package com.ehualu.data.business.resource.model;

public class Field {
    private Integer id;

    private String tableName;

    private String name;

    private String des;

    private String type;

    private String dictName;

    private String sampleData1;

    private String sampleData2;

    private String sampleData3;

    private String sampleData4;

    private String sampleData5;

    private String sampleData6;

    private String sampleData7;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getSampleData1() {
        return sampleData1;
    }

    public void setSampleData1(String sampleData1) {
        this.sampleData1 = sampleData1 == null ? null : sampleData1.trim();
    }

    public String getSampleData2() {
        return sampleData2;
    }

    public void setSampleData2(String sampleData2) {
        this.sampleData2 = sampleData2 == null ? null : sampleData2.trim();
    }

    public String getSampleData3() {
        return sampleData3;
    }

    public void setSampleData3(String sampleData3) {
        this.sampleData3 = sampleData3 == null ? null : sampleData3.trim();
    }

    public String getSampleData4() {
        return sampleData4;
    }

    public void setSampleData4(String sampleData4) {
        this.sampleData4 = sampleData4 == null ? null : sampleData4.trim();
    }

    public String getSampleData5() {
        return sampleData5;
    }

    public void setSampleData5(String sampleData5) {
        this.sampleData5 = sampleData5 == null ? null : sampleData5.trim();
    }

    public String getSampleData6() {
        return sampleData6;
    }

    public void setSampleData6(String sampleData6) {
        this.sampleData6 = sampleData6 == null ? null : sampleData6.trim();
    }

    public String getSampleData7() {
        return sampleData7;
    }

    public void setSampleData7(String sampleData7) {
        this.sampleData7 = sampleData7 == null ? null : sampleData7.trim();
    }
}