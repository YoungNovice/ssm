package com.xuanyang.concurrent.func;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSync {

    public static void main(String[] args) {
        MyBuiness myBuiness = new MyBuiness();
        // 单线程池子
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    myBuiness.print("yangxuangsgd");
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                myBuiness.print("nihaoma");
                }

            }
        }).start();

    }


}

class MyBuiness {

    Lock lock = new ReentrantLock();

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
