package com.xuanyang.concurrent.func;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Young
 */
public class ThreadPoolFixed {

    public static final int FIVE = 5;
    public static final int INT = FIVE;
    public static final int TEN = 10;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 3, 3,
                TimeUnit. SECONDS, new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int j = 0; j < FIVE; j++) {
            final int x = j;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < TEN; i++) {
                        System.out.println(Thread.currentThread().getName() + "loop of i= " + i + "outer loop of= " + x);
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
