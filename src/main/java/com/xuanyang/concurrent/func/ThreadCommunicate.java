package com.xuanyang.concurrent.func;


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
 */
public class ThreadCommunicate {

    public static void main(String[] args) {
        final Buiness buiness = new Buiness();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    // todo sub thread buiness
                     buiness.subDo(i);

                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            // todo main thread buiness
            buiness.mainDo(i);
        }
    }
}

class Buiness {

    private boolean isSubThreadDo = true;

    public synchronized void subDo(int times) {
        while (!isSubThreadDo) {
            try {
                Buiness.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
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

        for (int i = 0; i < 3; i++) {
            System.out.println("main thread "+ i + "loop times is " + times);
        }

        isSubThreadDo = true;
        Buiness.class.notify();
    }

}
