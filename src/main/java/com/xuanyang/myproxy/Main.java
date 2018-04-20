package com.xuanyang.myproxy;

import com.xuanyang.myproxy.demo.Testable;
import com.xuanyang.myproxy.demo.TestableImp;

/**
 * Created by Young on 2018/4/20.
 */
public class Main {

    public static void main(String[] args) {
        try {
            TestableImp testableImp = new TestableImp();
            Testable proxy = (Testable) Proxy.newProxyInstance(Testable.class,
                new InvocationHandlerImpl(testableImp));

            String test = proxy.test(123);
            System.out.println(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
