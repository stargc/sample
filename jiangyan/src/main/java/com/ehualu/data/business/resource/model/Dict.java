package com.ehualu.data.business.resource.model;

public class Dict {
    private Integer id;

    private String tableName;

    private String dictGroupCode;

    private String dictGroupName;

    private String dictCode;

    private String dictValue;

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

    public String getDictGroupCode() {
        return dictGroupCode;
    }

    public void setDictGroupCode(String dictGroupCode) {
        this.dictGroupCode = dictGroupCode == null ? null : dictGroupCode.trim();
    }

    public String getDictGroupName() {
        return dictGroupName;
    }

    public void setDictGroupName(String dictGroupName) {
        this.dictGroupName = dictGroupName == null ? null : dictGroupName.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }
}