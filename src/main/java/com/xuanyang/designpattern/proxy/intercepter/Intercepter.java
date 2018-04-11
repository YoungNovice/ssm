package com.xuanyang.designpattern.proxy.intercepter;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/5.
 *
 * @author xuanyang
 */
public interface Intercepter {

    /**
     * before
     * @param proxy proxy
     * @param target target
     * @param method method
     * @param args args arr
     * @return returning
     */
    boolean before(Object proxy, Object target, Method method, Object[] args);

    /**
     * around
     * @param proxy proxy
     * @param target target
     * @param method method
     * @param args args arr
     */
    void around(Object proxy, Object target, Method method, Object[] args);

    /**
     * after
     * @param proxy proxy
     * @param target target
     * @param method method
     * @param args args arr
     */
    void after(Object proxy, Object target, Method method, Object[] args);
}
