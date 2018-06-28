package com.novel.common.pojo;

public class TbVersion {
    private Long id;

    private String appName;

    private Float newAppSize;

    private Integer newAppVersionCode;

    private String newAppVersionName;

    private String newAppUpdateDesc;

    private String newAppReleaseTime;

    private String newAppUrl;

    private Integer isForceUpdate;

    private Integer isUseNewPage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Float getNewAppSize() {
        return newAppSize;
    }

    public void setNewAppSize(Float newAppSize) {
        this.newAppSize = newAppSize;
    }

    public Integer getNewAppVersionCode() {
        return newAppVersionCode;
    }

    public void setNewAppVersionCode(Integer newAppVersionCode) {
        this.newAppVersionCode = newAppVersionCode;
    }

    public String getNewAppVersionName() {
        return newAppVersionName;
    }

    public void setNewAppVersionName(String newAppVersionName) {
        this.newAppVersionName = newAppVersionName;
    }

    public String getNewAppUpdateDesc() {
        return newAppUpdateDesc;
    }

    public void setNewAppUpdateDesc(String newAppUpdateDesc) {
        this.newAppUpdateDesc = newAppUpdateDesc;
    }

    public String getNewAppReleaseTime() {
        return newAppReleaseTime;
    }

    public void setNewAppReleaseTime(String newAppReleaseTime) {
        this.newAppReleaseTime = newAppReleaseTime;
    }

    public String getNewAppUrl() {
        return newAppUrl;
    }

    public void setNewAppUrl(String newAppUrl) {
        this.newAppUrl = newAppUrl;
    }

    public Integer getIsForceUpdate() {
        return isForceUpdate;
    }

    public void setIsForceUpdate(Integer isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
    }

    public Integer getIsUseNewPage() {
        return isUseNewPage;
    }

    public void setIsUseNewPage(Integer isUseNewPage) {
        this.isUseNewPage = isUseNewPage;
    }
}