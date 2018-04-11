package com.xuanyang.concurrent.func;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * thread communicate
 *
 * main thread loop ten time
 * then sub thread loop handrend time
 * then main thread loop ten time
 * then sub thread loop heand time
 * so we loop fivty time
 *
 *
 * @author Young
 */
public class ThreadCommunicate {

    public static final int FIVE = 5;

    public static void main(String[] args) {

        ThreadPoolExecutor service = new ThreadPoolExecutor(FIVE, 10, FIVE,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        final Buiness buiness = new Buiness();
        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < FIVE; i++) {
                    buiness.subDo(i);
                }
            }
        });
        for (int i = 0; i < FIVE; i++) {
            buiness.mainDo(i);
        }
    }
}

class Buiness {

    private static final int THREE = 3;
    private boolean isSubThreadDo = true;

    public synchronized void subDo(int times) {
        while (!isSubThreadDo) {
            try {
                Buiness.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < THREE; i++) {
            System.out.println("sub thread "+ i + "loop times is " + times);
        }
        isSubThreadDo = false;
        Buiness.class.notify();
    }

    public synchronized void mainDo(int times) {
        while (isSubThreadDo) {
            try {
                Buiness.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < THREE; i++) {
            System.out.println("main thread "+ i + "loop times is " + times);
        }

        isSubThreadDo = true;
        Buiness.class.notify();
    }

}
