package com.example.demo.exception;

import com.example.demo.util.result.ApiResponse;
import com.example.demo.util.result.ApiResponseCodeEnum;
import com.example.demo.web.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 青菜
 * @Date: 2019/5/6 下午2:45
 * @Description: 异常拦截统统一处理类，只能拦截Controller层异常(service 层以及别的层面不捕获异常也可拦截)
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandle extends BaseController {

    @ExceptionHandler(Exception.class)
    private ApiResponse handle(Exception exception){
        log.error("系统异常:",exception);
        if(exception instanceof MyException){
            return super.callbackFail(ApiResponseCodeEnum.SYSTEM_EXCEPTION.getCode(), "发生异常："+exception.getMessage());
        }else{

        }
        return super.callbackFail(ApiResponseCodeEnum.SYSTEM_EXCEPTION.getCode(), "发生异常："+exception.getMessage());

    }
}
