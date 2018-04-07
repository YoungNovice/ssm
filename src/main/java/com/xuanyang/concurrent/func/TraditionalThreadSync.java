package com.xuanyang.concurrent.func;


public class TraditionalThreadSync {

    public static void main(String[] args) {
        TraditionalThreadSync threadSync = new TraditionalThreadSync();
        Output output = threadSync.new Output();
        new Thread(new Runnable() {
            @Override
            public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        threadSync.new Output().put("xuanyangsddfgdgdgdgsdgfsfd");

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        threadSync.new Output().put("qulianghodfgdgdfgdgdsgdfsddfgng");

                }
            }
        }).start();
    }

    class Output {

        Object str = "sdf";

        public void put(String name) {
            synchronized (str) {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }

            }
            System.out.println();
        }
    }
}
