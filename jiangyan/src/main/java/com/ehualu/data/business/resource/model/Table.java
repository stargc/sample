package com.ehualu.data.business.resource.model;

public class Table {
    private Integer id;

    private String resourceCode;

    private String resourceName;

    private String resourceTableCode;

    private String resourceTableName;

    private String tablePhysicalName;

    private Long count;

    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode == null ? null : resourceCode.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceTableCode() {
        return resourceTableCode;
    }

    public void setResourceTableCode(String resourceTableCode) {
        this.resourceTableCode = resourceTableCode == null ? null : resourceTableCode.trim();
    }

    public String getResourceTableName() {
        return resourceTableName;
    }

    public void setResourceTableName(String resourceTableName) {
        this.resourceTableName = resourceTableName == null ? null : resourceTableName.trim();
    }

    public String getTablePhysicalName() {
        return tablePhysicalName;
    }

    public void setTablePhysicalName(String tablePhysicalName) {
        this.tablePhysicalName = tablePhysicalName == null ? null : tablePhysicalName.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}