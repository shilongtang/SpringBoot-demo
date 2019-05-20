package com.example.demo.help;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 青菜
 * @Date: 2019/4/20 下午4:17
 * @Description: ConfigurationProperties perfix前缀方式 @PropertySource yml格式文件无效
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "inv")
public class Config {

    //@Value("${config.test}")
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
