package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 青菜
 * @Date: 2019/5/20 下午3:13
 * @Description:
 * @Version 1.0
 */
public class ThreadPoolUtil {
    public static void main(String[] args) {
        //testCachedThreadPool();
        //testSingleThreadPool();
        //testFixedThreadPool();
        testScheduledThreadPool();
    }

    private static void testScheduledThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("每三秒执行一次");
            }
        }, 3, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟一秒后，每三秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);

    }

    private static void testSingleThreadPool(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void testFixedThreadPool(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void testCachedThreadPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index+"当前线程"+Thread.currentThread().getName());
                }
            });
        }
    }
}
