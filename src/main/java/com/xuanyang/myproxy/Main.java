package com.xuanyang.myproxy;

import com.xuanyang.myproxy.demo.Testable;

/**
 * Created by Young on 2018/4/20.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Object instance = Proxy.newProxyInstance(Testable.class, new InvocationHandlerImpl());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
