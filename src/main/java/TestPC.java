
class SynStack {
	 	
	private static char[] data = new char[8];
	private int cnt = 0;

	// 	生产
	public synchronized void push(char ch) {
		// 	满了就不能push 生产线程停止生产 唤醒消费线程
		while (cnt == data.length) {
			try {
				this.wait();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		this.notify();
		data[cnt] = ch;
		cnt++;
		System.out.printf("生产线程正在生产%d个产品, 该产品是%c\n", cnt, ch);
	}

	// 消费
	public synchronized char pop() {
		// 空了 就不能pop 消费线程停止消费 唤醒生产线程
		while (cnt == 0) {
			try {
				this.wait();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		this.notify();
		cnt--;
		char ch = data[cnt];
		System.out.printf("消费线程正在消费%d个产品, 该产品是%c\n",  cnt+1, ch);
		return ch;
	}
}

class Producer implements Runnable {

	private SynStack ss = null;

	public Producer(SynStack ss) {
		this.ss = ss;
	}

	public void run() {
		char ch;

		for (int i=0; i < 20; i++) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			ch = (char)('a' + i);
			ss.push(ch);
		}
	}
}

class Consumer implements Runnable {

	private SynStack ss = null;

	public Consumer(SynStack ss) {
		this.ss = ss;
	}

	// 消费20次
	public void run() {
		for (int i=0; i < 20; i++) {
			ss.pop();
		}
	}
}

public class TestPC {

	public static void main(String[] args) {
		SynStack ss = new SynStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		Thread tp = new Thread(p);
		Thread tc = new Thread(c);
		tp.start();
		tc.start();
	}
}
