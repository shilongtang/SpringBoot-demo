package com.example.demo.help.utils.result;

/**
 * @Author: 青菜
 * @Date: 2019/5/5 下午7:32
 * @Description: api返回状态
 * @Version 1.0
 */
public class ApiResponseState {
    private long code;
    private String message;
    private long timestamp;

    public ApiResponseState(long code, String message, long timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }
    public ApiResponseState(long code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
