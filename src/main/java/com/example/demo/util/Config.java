package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: 青菜
 * @Date: 2019/4/20 下午4:17
 * @Description:
 * @Version 1.0
 */
@Component
public class Config {
    @Value("${config.test}")
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
