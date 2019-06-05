package com.example.demo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.esRepository.ApkInfoRepositoryRepository;
import com.example.demo.help.utils.result.ApiResponse;
import com.example.demo.model.po.ApkInfo;
import com.example.demo.service.ApkInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author: 青菜
 * @Date: 2019/5/30 下午5:38
 * @Description:
 * @Version 1.0
 */
@Slf4j
@Api(description="Spring Boot test", tags = "es API")
@ConditionalOnWebApplication
@RestController()
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EsController extends BaseController {

    @Autowired
    ApkInfoRepositoryRepository apkInfoRepositoryRepository;

    @Autowired
    ApkInfoService apkInfoService;

    @GetMapping("/es/saveApkInfo")
    @ApiOperation(value="测试测试")
    public ApiResponse saveApkInfo() throws Exception{
        ApkInfo apkInfo = apkInfoService.get("115");
        ApkInfo save = apkInfoRepositoryRepository.save(apkInfo);
        System.out.println(JSONObject.toJSON(save));
        return super.callbackFail(890002,"{\"abs\":123123}");
    }

    @GetMapping("getOne")
    public ApiResponse getOne(long id){
        Optional<ApkInfo> byId = apkInfoRepositoryRepository.findById(id);

        return super.callbackFail(890002,JSONObject.toJSONString(byId));
    }


}
