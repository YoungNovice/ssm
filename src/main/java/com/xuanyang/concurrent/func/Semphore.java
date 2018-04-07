package com.xuanyang.concurrent.func;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semphore {

    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(2);
        CyclicBarrier barrier = new CyclicBarrier(2);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphore.acquire(2);
                        System.out.println("子线程执行");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                    semaphore.release();
                    try {
                        try {
                            barrier.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("子线程等等主线程");
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行完毕");

                }

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphore.acquire(2);
                        System.out.println("主线程执行");
                        Thread.sleep(1000);
                        semaphore.release(2);
                        try {
                            barrier.await();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
