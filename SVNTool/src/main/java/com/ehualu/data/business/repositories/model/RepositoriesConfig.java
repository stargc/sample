package com.ehualu.data.business.repositories.model;

import java.util.Date;

public class RepositoriesConfig {
    private Integer id;

    private String repositoriesName;

    private String dbBasePath;

    private String accessBaseUrl;

    private Integer createUserId;

    private Date createTime;

    private Integer updateUserId;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepositoriesName() {
        return repositoriesName;
    }

    public void setRepositoriesName(String repositoriesName) {
        this.repositoriesName = repositoriesName == null ? null : repositoriesName.trim();
    }

    public String getDbBasePath() {
        return dbBasePath;
    }

    public void setDbBasePath(String dbBasePath) {
        this.dbBasePath = dbBasePath == null ? null : dbBasePath.trim();
    }

    public String getAccessBaseUrl() {
        return accessBaseUrl;
    }

    public void setAccessBaseUrl(String accessBaseUrl) {
        this.accessBaseUrl = accessBaseUrl == null ? null : accessBaseUrl.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}