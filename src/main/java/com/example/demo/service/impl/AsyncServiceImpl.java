package com.example.demo.service.impl;

import com.example.demo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Author: 青菜
 * @Date: 2019/5/6 下午4:21
 * @Description:
 * @Version 1.0
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Resource(name = "defaultThreadPool")
    ThreadPoolTaskExecutor defaultThreadPool;

    @Async("taskExecutor")
    @Override
    public void executeAsyncTask(Integer i) {
        log.info("########--->{} run：{}",Thread.currentThread().getName(),i);
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        log.info("Thread--->{} run：{}",Thread.currentThread().getName(),i);
    }

    @Override
    public void executeTask() {

        for (int i = 0;i< 5; i++){
            this.executeTaskFor(i);
        }
        defaultThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                log.info("Thread->{}",Thread.currentThread().getName());
                for (int i = 0;i< 5; i++){
                    executeTaskFor(i);
                }
                log.info("Thread->{}",Thread.currentThread().getName());
            }
        });
    }

    @Async("taskExecutor")
    @Override
    public void executeTaskFor(Integer i){
        log.info("########--->{} run：{}",Thread.currentThread().getName(),i);
    }
}
