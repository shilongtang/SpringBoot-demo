package com.example.demo.web;

import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/test")
    public void test() {
        log.info("Logger Level ：{}", "info");
        log.error("Logger Level ：{}", "error");
        log.debug("Logger Level ：{}", "debug");
        log.warn("Logger Level ：{}", "warn");
    }

}
