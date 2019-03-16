import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

    private static Singleton instance;

    private static Lock locker = new ReentrantLock();

    private Singleton() {}

    public static Singleton getInstance() {
        Condition condition = locker.newCondition();
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
