package com.xuanyang.concurrent.func;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("factory");
                return new Thread(r);
            }
        });

        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("booling");
            }
        }, 2, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("rating");
            }
        }, 4, 2, TimeUnit.SECONDS);
    }
}
