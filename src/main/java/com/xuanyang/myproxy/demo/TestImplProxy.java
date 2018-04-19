package com.xuanyang.myproxy.demo;

import com.xuanyang.myproxy.MyInvocationHandler;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/19.
 */
public class TestImplProxy implements Testable {

    MyInvocationHandler handler;

    public void setHandler(MyInvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public String test(int a) {
        try {
            Method sss = null;
            Class<?>[] types = sss.getParameterTypes();
            Method method = Testable.class.getMethod("test", types);
            handler.invoke(this, method, null);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        return null;
    }
}
