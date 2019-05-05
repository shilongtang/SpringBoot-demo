package com.example.demo.model.po;

import java.util.Date;

/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午5:32
 * @Description: apkInfo
 * @Version 1.0
 */
public class ApkInfo {
    private Integer id;

    private String name;

    private Integer versionCode;

    private String versionName;

    /**
     * 安装包大小
     */
    private String size;

    /**
     * 新的安装包路径
     */
    private String apkPath;

    /**
     * 增量包 补丁 路径
     */
    private String patchPath;

    private String versionExplain;

    private String patchUrl;

    private Integer initVersionCode;

    /**
     * 是否强制更新：1-0
     */
    private Integer isRenewal;

    private Date createTime;

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
        this.name = name;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath(String apkPath) {
        this.apkPath = apkPath;
    }

    public String getPatchPath() {
        return patchPath;
    }

    public void setPatchPath(String patchPath) {
        this.patchPath = patchPath;
    }

    public String getVersionExplain() {
        return versionExplain;
    }

    public void setVersionExplain(String versionExplain) {
        this.versionExplain = versionExplain;
    }

    public String getPatchUrl() {
        return patchUrl;
    }

    public void setPatchUrl(String patchUrl) {
        this.patchUrl = patchUrl;
    }

    public Integer getInitVersionCode() {
        return initVersionCode;
    }

    public void setInitVersionCode(Integer initVersionCode) {
        this.initVersionCode = initVersionCode;
    }

    public Integer getIsRenewal() {
        return isRenewal;
    }

    public void setIsRenewal(Integer isRenewal) {
        this.isRenewal = isRenewal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
