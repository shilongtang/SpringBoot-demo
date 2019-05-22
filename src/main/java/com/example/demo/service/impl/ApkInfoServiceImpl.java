package com.example.demo.service.impl;

import com.example.demo.exception.MyException;
import com.example.demo.mapper.ApkInfoMapper;
import com.example.demo.model.po.ApkInfo;
import com.example.demo.service.ApkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午5:51
 * @Description:
 * @Version 1.0
 */
@Service
public class ApkInfoServiceImpl implements ApkInfoService {

    @Autowired
    ApkInfoMapper apkInfoMapper;


    @Override
    public ApkInfo get(String versionCode){
       /* int i = 0;
        int b = 1/i;*/
        return apkInfoMapper.get(versionCode);
    }

    @Override
    public ApkInfo get(String versionCode, Integer i){
       /* int i = 0;
        int b = 1/i;*/
        return apkInfoMapper.get(versionCode);
    }
}
