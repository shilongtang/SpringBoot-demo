package com.example.demo.model.po;

import java.util.Map;

/**
 * @Author: 青菜
 * @Date: 2019-06-26 18:00
 * @Description:
 * @Version 1.0
 */
public class Param {

    private String position;

    private Map<String, Object> paramMap;


    public String getSqlFile() {
        return position.split("_")[0];
    }

    public String getSqlKey() {
        return position.split("_")[1];
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null) {
            throw new RuntimeException("position不能为空");
        }
        if (position.split("_").length != 2) {
            throw new RuntimeException("position传入有误");
        }
        this.position = position;
    }


    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

}
