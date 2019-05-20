package com.example.demo.help.utils.result;

/**
 * @Author: 青菜
 * @Date: 2019/5/5 下午7:51
 * @Description:
 * @Version 1.0
 */
public enum ApiResponseCodeEnum {

    SUCCESS(0,"ok"),
    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(-1,"System Exception"),

    FAIL(9999,"fail");

    private Integer code;
    private String desc;


    ApiResponseCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

/*
    public static final long SUCCESS_CODE = 10000;
    public static final String SUCCESS_MESSAGE = "访问成功";

    public static final long ERROR_CODE = 10001;
    public static final String ERROR_MESSAGE = "访问错误";

    public static final long NEED_TOKEN_CODE = 10002;
    public static final String NEED_TOKEN_MESSAGE = "未登录";

    public static final long ACCESS_DENY_CODE = 10003;
    public static final String ACCESS_DENY_MESSAGE = "无权限";*/
}
