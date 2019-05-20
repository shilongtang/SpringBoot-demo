package com.example.demo.web;

import com.alibaba.fastjson.JSON;
import com.example.demo.help.utils.result.ApiResponse;
import com.example.demo.help.utils.result.ApiResponseCodeEnum;
import com.example.demo.help.utils.result.ApiResponseState;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 青菜
 * @Date: 2019/5/5 下午7:56
 * @Description: base controller
 * @Version 1.0
 */
@Slf4j
public class BaseController {
    /**
     * success
     * @param success
     * @return
     */
    protected ApiResponse callback(boolean success) {
        Map<String, Object> map = new HashMap<>();
        if(success){
            map.put("success", true);
            return callbackSuccess(JSON.toJSONString(map));
        }else{
            map.put("success", false);
            return callbackFail(map);
        }
    }

    /**
     * SUCCESS code
     * @param map
     * @return
     */
    protected ApiResponse callbackSuccess(Map<String, Object> map) {
        String json = "{}";
        if(map != null){
            json = JSON.toJSONString(map);

        }
        return callbackSuccess(json);
    }

    /**
     * SUCCESS code
     * @param json
     * @return
     */
    protected ApiResponse callbackSuccess(String json) {
        if(StringUtils.isNotBlank(json)) {
            try{
                JSON.parseObject(json, Object.class);
            }catch (Exception e){
                Map<String, Object> map = new HashMap<>();
                map.put("message", json);
                return callbackSuccess(map);
            }
        }
        return new ApiResponse(new ApiResponseState(ApiResponseCodeEnum.SUCCESS.getCode(), ApiResponseCodeEnum.SUCCESS.getDesc()), json);
    }

    /**
     * 携带code
     * @param code
     * @param json
     * @return
     */
    protected ApiResponse callbackFail(Integer code, String json) {
        return new ApiResponse(new ApiResponseState(code, ApiResponseCodeEnum.FAIL.getDesc()), json);
    }

    /**
     * 携带code
     * @param code
     * @param data
     * @return
     */
    protected ApiResponse callbackFail(Integer code, Map<String, Object> data) {
        return new ApiResponse(new ApiResponseState(code, ApiResponseCodeEnum.FAIL.getDesc()), JSON.toJSONString(data));
    }

    /**
     * fail code
     * @param data
     * @return
     */
    protected ApiResponse callbackFail(Map<String, Object> data) {
        return new ApiResponse(new ApiResponseState(ApiResponseCodeEnum.FAIL.getCode(), ApiResponseCodeEnum.FAIL.getDesc()), JSON.toJSONString(data));
    }

    /**
     * fail code
     * @param json
     * @return
     */
    protected ApiResponse callbackFail(String json) {
        if(StringUtils.isNotBlank(json)) {
            try{
                JSON.parseObject(json, Object.class);
            }catch (Exception e){
                Map<String, Object> map = new HashMap<>();
                map.put("message", json);
                return callbackFail(map);
            }
        }
        return new ApiResponse(new ApiResponseState(ApiResponseCodeEnum.FAIL.getCode(), ApiResponseCodeEnum.FAIL.getDesc()), json);
    }

    protected ApiResponse callbackFail(String message, Map<String, Object> data) {
        return callbackFail(message, JSON.toJSONString(data));
    }

    /**
     * fail code 携带message ,date
     * @param message
     * @param json
     * @return
     */
    protected ApiResponse callbackFail(String message, String json) {
        if(StringUtils.isNotBlank(json)) {
            try{
                JSON.parseObject(json, Object.class);
            }catch (Exception e){
                Map<String, Object> map = new HashMap<>();
                map.put("message", json);
                return callbackFail(message, map);
            }
        }
        return new ApiResponse(new ApiResponseState(ApiResponseCodeEnum.FAIL.getCode(), message), json);
    }
}
