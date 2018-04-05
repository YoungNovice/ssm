package com.xuanyang.designpattern.proxy.intercepter;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/5.
 */
public class MyIntercepter implements Intercepter {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {

        System.out.println("调用之前");
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("调用之后");
    }
}
