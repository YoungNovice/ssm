package com.xuanyang.concurrent.func;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Young
 *
 * 获取固定的线程池 不推荐使用
 * ExecutorService threadPool = Executors.newFixedThreadPool(6);
 */
public class ReadAndWriteLockTest {

    public static final int THREE = 3;

    public static void main(String[] args) {
        Queue queue = new Queue();

        ThreadPoolExecutor service = new ThreadPoolExecutor(6, 6, 6,
                TimeUnit. SECONDS, new ArrayBlockingQueue<>(6),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < THREE; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        queue.get();
                    }
                }
            });
        }

        for (int i = 0; i < THREE; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        queue.put(new Random().nextInt(1000));
                    }
                }
            });
        }
    }
}



/**
 *共享数据业务最好提取到一个类中
*/
class Queue {
    private Object data = null;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("get data is = " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void put(Object data) {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
            this.data = data;

            System.out.println("write data is = " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
