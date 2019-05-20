package com.example.demo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.help.Config;
import com.example.demo.help.utils.result.ApiResponse;
import com.example.demo.model.po.ApkInfo;
import com.example.demo.service.ApkInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Api()用于类；
 *           表示标识这个类是swagger的资源
 * - @ApiOperation()用于方法；
 *             表示一个http请求的操作
 * - @ApiParam()用于方法，参数，字段说明；
 *              表示对参数的添加元数据（说明或是否必填等）
 * - @ApiModel()用于类
 *                表示对类进行说明，用于参数用实体类接收
 * - @ApiModelProperty()用于方法，字段
 *             表示对model属性的说明或者数据操作更改
 * - @ApiIgnore()用于类，方法，方法参数
 *           表示这个方法或者类被忽略
 * - @ApiImplicitParam() 用于方法
 *           表示单独的请求参数
 * - @ApiImplicitParams()  用于方法，包含多个 @ApiImplicitParam
 */

/**
 * @Author: 青菜
 * @Date: 2019/4/18 下午5:38
 * @Description:
 * @Version 1.0
 */
@Slf4j
@Api(description="Spring Boot test", tags = "test API")
@ConditionalOnWebApplication
@RestController()
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HelloController extends BaseController {
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

    @PostMapping("/admin/getApkInfo")
    @ApiOperation(value="测试测试")
    public ApiResponse getApkInfo(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) ApkInfo apkInfo1) throws Exception{
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
        return super.callbackFail(890001,"{\"abs\":123132}");
    }

    @GetMapping("/exception/test")
    @ApiOperation(value="测试测试")
    public ApiResponse testException() throws Exception{
      /*  try {
            List list = new ArrayList();
            Object o = list.get(1);
        }catch (Exception e){
            e.printStackTrace();
        }*/


        int i = 0;
        int b = 1/i;
        return super.callbackFail(890001,"123132");
    }

    @GetMapping("/exception/test2")
    @ApiOperation(value="测试测试")
    public ApiResponse test2Exception() {
        ApkInfo apkInfo = apkInfoService.get("115");
        return super.callbackFail(890001,"123132");
    }

}
