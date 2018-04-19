package com.xuanyang.myproxy;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/19.
 * 这个是代理对象的业务逻辑实现接口
 *
 * @author xuanyang
 */
public interface MyInvocationHandler {

    /**
     * 代理类实际上调用的方法
     *
     * @param proxy proxy
     * @param method 代理类调用的Method对象
     * @param args 方法参数
     * @return Return value
     * @throws Throwable Excep
     */
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;


}
