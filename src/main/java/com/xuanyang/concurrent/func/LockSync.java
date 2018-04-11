package com.xuanyang.concurrent.func;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Young
 *
 * 单线程池子 已不推荐使用
 * ExecutorService service = Executors.newSingleThreadExecutor();
 */
public class LockSync {

    public static void main(String[] args) {
        MyBuiness myBuiness = new MyBuiness();

        ThreadPoolExecutor service = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit. SECONDS, new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        service.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    myBuiness.print("yangxuangsgd");
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    myBuiness.print("nihaoma");
                }

            }
        });
    }
}

class MyBuiness {

    private Lock lock = new ReentrantLock();

    public void print(String name) {
        lock.lock();

        try {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        } finally {
            lock.unlock();
        }
    }
}
