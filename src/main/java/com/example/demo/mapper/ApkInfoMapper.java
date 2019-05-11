package com.example.demo.mapper;

import com.example.demo.model.po.ApkInfo;

/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午5:46
 * @Description:
 * @Version 1.0
 */
public interface ApkInfoMapper {

    /**
     * 根据版本号查询apkInfo
     * @param versionCode
     * @return
     * @throws Exception
     */
    ApkInfo get(String versionCode);
}
