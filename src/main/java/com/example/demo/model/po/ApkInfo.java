package com.example.demo.model.po;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @Document
 *      public @interface Field {
 *
 *          FieldType type() default FieldType.Auto; //自动检测属性的类型，可以根据实际情况自己设置
 *
 *          FieldIndex index() default FieldIndex.analyzed; //默认情况下分词，一般默认分词就好，除非这个字段你确定查询时不会用到
 *
 *          DateFormat format() default DateFormat.none; //时间类型的格式化
 *
 *          String pattern() default "";
 *
 *          boolean store() default false; //默认情况下不存储原文
 *
 *          String searchAnalyzer() default ""; //指定字段搜索时使用的分词器
 *
 *          String indexAnalyzer() default ""; //指定字段建立索引时指定的分词器
 *
 *          String[] ignoreFields() default {}; //如果某个字段需要被忽略
 *
 *          boolean includeInParent() default false;
 * }
 * @Field
 *      public @interface Document {
 *
 *          String indexName(); //索引库的名称，建议以项目的名称命名
 *
 *          String type() default ""; //类型，建议以实体的名称命名
 *
 *          short shards() default 5; //默认分区数
 *
 *          short replicas() default 1; //每个分区默认的备份数
 *
 *          String refreshInterval() default "1s"; //刷新间隔
 *
 *          String indexStoreType() default "fs"; //索引文件存储类型
 * }
 */



/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午5:32
 * @Description: apkInfo
 * @Version 1.0
 */
//indexName索引名称 可以理解为数据库名 必须为小写 不然会报org.elasticsearch.indices.InvalidIndexNameException异常
//type类型 可以理解为表名
@Document(indexName = "apkinfo",type = "apkInfo")
public class ApkInfo implements Serializable {
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
