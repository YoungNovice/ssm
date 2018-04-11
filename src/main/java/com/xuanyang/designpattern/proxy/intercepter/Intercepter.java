package com.xuanyang.designpattern.proxy.intercepter;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/5.
 *
 * @author xuanyang
 */
public interface Intercepter {

    boolean before(Object proxy, Object target, Method method, Object[] args);

    void around(Object proxy, Object target, Method method, Object[] args);

    void after(Object proxy, Object target, Method method, Object[] args);
}
