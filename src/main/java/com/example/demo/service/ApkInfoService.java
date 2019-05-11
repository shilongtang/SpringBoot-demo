package com.example.demo.service;

import com.example.demo.model.po.ApkInfo;
import org.springframework.stereotype.Service;

/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午5:51
 * @Description:
 * @Version 1.0
 */

public interface ApkInfoService {

    /**
     * 获取单个版本
     * @param versionCode
     * @return
     * @throws Exception
     */
    ApkInfo get(String versionCode);
}
