package com.xuanyang.designpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/5.
 */
public class CglibProxyDemo implements MethodInterceptor {

    /**
     * 生成代理对象
     * @param cls Class
     * @return Class 类的Cglib代理对象
     */
    public Object getproxy(Class cls) {
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = methodProxy.invokeSuper(proxy, objects);
        System.out.println("after");
        return result;
    }
}
