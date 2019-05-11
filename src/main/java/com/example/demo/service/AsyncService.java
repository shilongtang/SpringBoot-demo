package com.example.demo.service;

/**
 * @Author: 青菜
 * @Date: 2019/5/6 下午4:21
 * @Description: 异步测试
 * @Version 1.0
 */
public interface AsyncService {

    /**
     * 测试
     * @param i
     */
    default public void executeAsyncTask(Integer i){
        System.out.println("112313131");
    }

    default public void executeTask(){
        System.out.println("112313131");
    }

    void executeTaskFor(Integer i);
}
