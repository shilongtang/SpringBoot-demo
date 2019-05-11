package com.example.demo.web;

import com.example.demo.service.AsyncService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 青菜
 * @Date: 2019/5/6 下午4:27
 * @Description: 测试
 * @Version 1.0
 */
@Slf4j
@Api(description="Spring Boot test", tags = "test API")
@ConditionalOnWebApplication
@RestController()
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestController extends BaseController {

    @Autowired
    AsyncService asyncService;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/threadTest")
    public void threadTest() {
        System.out.println(123);
       for (int i = 0; i< 5;i++){
           asyncService.executeAsyncTask(i);
           System.out.println(456);
       }
        System.out.println(789);

    }

    @GetMapping("/threadTest2")
    public void threadTest2() {
        for (int i = 0;i< 5; i++){
            asyncService.executeTaskFor(i);
        }

    }



    @Transactional
    @GetMapping("/redisTest")
    public void redisTest() {
        redisTemplate.opsForValue().set("1231","123123");
        int i = 0;
        int b = 1/i;
        /*try {

        }catch (Exception e){

        }*/

    }

}
