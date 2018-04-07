package com.xuanyang.concurrent.func;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolFixed {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int j = 0; j < 5; j++) {
            final int x = j;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "loop of i= " + i + "outer loop of= " + x);
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
