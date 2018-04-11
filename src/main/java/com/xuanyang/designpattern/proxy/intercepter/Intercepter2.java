package com.xuanyang.designpattern.proxy.intercepter;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/5.
 *
 * @author xuanyang
 */
public class Intercepter2 implements Intercepter {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("Intercepter2 调用之前");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("Intercepter2 调用之后");
    }
}
