package com.example.demo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.po.ApkInfo;
import com.example.demo.service.ApkInfoService;
import com.example.demo.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: 青菜
 * @Date: 2019/4/18 下午5:38
 * @Description:
 * @Version 1.0
 */
@Slf4j
@RestController()
public class HelloController {
    @Autowired
    Config config;

    @Autowired
    ApkInfoService apkInfoService;

    @GetMapping("/admin/test")
    public void test() {
        log.info("Logger Level ：{}", "info");
        log.error("Logger Level ：{}", "error");
        log.debug("Logger Level ：{}", "debug");
        log.warn("Logger Level ：{}", "warn");
    }

    @GetMapping("/admin/getApkInfo")
    public void getApkInfo() throws Exception{
        try {
            ApkInfo apkInfo = apkInfoService.get("115");
            log.info("Logger apkInfo ：{}", JSONObject.toJSONString(apkInfo));
        }catch (Exception e){
            log.error("Logger apkInfo ：{}", e.getMessage());
        }

        log.info("Logger Level ：{}", "info");
        log.error("Logger Level ：{}", "error");
        log.debug("Logger Level ：{}", "debug");
        log.warn("Logger Level ：{}", "warn");
    }

}
