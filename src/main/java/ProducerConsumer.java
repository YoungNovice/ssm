import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产消费者模式
 *
 * @author yangxuan
 */
class SynStack {
    private char[] data = new char[8];
    private int cnt = 0;
    private Lock lock = new ReentrantLock();
    private Condition p = lock.newCondition();
    private Condition c = lock.newCondition();

    public void push(char ch) {
        try {
            lock.lock();
            while (cnt == data.length) {
                try {
                    // 唤醒后继续执行wait后面的逻辑
                    p.await();
                    // 想像一下 如果上次是满了 调用了wait
                    // 生产线程卡住了， 这时消费线程假设消费了多个
                    // 那么此时肯定不是满的呀， 假设没有消费此时肯定是满的
                    // 所以当我们在消费线程中唤醒了生产线程 此时生产线程还是要
                    // 判断一下我醒来后是否是满的， 如果是满的继续睡
                    // 所以用while不用if
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 只要能生产就会通知消费线程消费
            c.signal();
            System.out.printf("生产线程正在生产第%d个商品 该商品是%c\n", cnt, ch);
            data[cnt] = ch;
            cnt++;
        } finally {
            lock.unlock();
        }
    }

    public char pop() {
        try {
            lock.lock();
            while (cnt == 0) {
                // 空 停止消费
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            p.signal();
            cnt--;
            char ch = data[cnt];
            System.out.printf("消费线程正在消费第%d个商品 该商品是%c\n", cnt, ch);
            return ch;
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private SynStack ss;

    public Producer(SynStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        // 上产20个产品
        for (int i = 0; i < 20; i++) {
            char ch = (char) ('a'+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ss.push(ch);
        }
    }
}

class Consumer implements Runnable {

    private SynStack ss;

    public Consumer(SynStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        // 消费者执行20次
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            char ch = ss.pop();
        }
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {
        SynStack ss = new SynStack();
        Producer producer = new Producer(ss);
        Consumer consumer = new Consumer(ss);
        Thread ps = new Thread(producer);
        Thread cs = new Thread(consumer);
        ps.start();
        cs.start();
    }
}
