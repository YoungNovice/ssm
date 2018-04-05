package com.xuanyang.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Young on 2018/4/5.
 */
public class JdkProxyDemo implements InvocationHandler {

    /** 需要代理的目标对象*/
    private Object target = null;

    /** 获取代理对象的方法*/
    public Object bind(Object o) {
        this.target = o;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object ret = method.invoke(target, args);
        System.out.println("after");
        return ret;
    }
}
