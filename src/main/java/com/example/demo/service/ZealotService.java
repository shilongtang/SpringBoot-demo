package com.example.demo.service;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 青菜
 * @Date: 2019-06-26 17:37
 * @Description: zealot
 * @Version 1.0
 */
public interface ZealotService {
    /**
     * default 可以使接口有默认的方法体
     * @return
     */
    default String unimplement(){
        Map<String, String> map = new HashMap<>();
        map.put("message", "该方法实现");
        return JSON.toJSONString(map);
    }

    default String querySqlForList(String body){
        return unimplement();
    };

    default String querySqlForObject(String body){
        return unimplement();
    };

    default Integer update(String body){
        return 0;
    };

}
