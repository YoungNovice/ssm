package com.xuanyang.concurrent.func;

import java.util.Timer;
import java.util.TimerTask;

/**
 * jdk util 包中自带有定时器功能
 * 可以进行一些简单的定时需求
 */
public class TimerTest {

    public static void main(String[] args) {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("boomling!!!!");

            }
        }, 10000);

        System.out.printf("sout");

    }
}
