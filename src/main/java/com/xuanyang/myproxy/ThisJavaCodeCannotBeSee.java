package com.xuanyang.myproxy;

import java.lang.reflect.Method;

public class ThisJavaCodeCannotBeSee implements com.xuanyang.myproxy.demo.Testable{
    public ThisJavaCodeCannotBeSee(InvocationHandler h) {
        this.h = h;
    }
    com.xuanyang.myproxy.InvocationHandler h;
@Override
public String test(int param0) {
    try {
        int paramCount = 1;
        Class[] paramClazz = new Class[paramCount];
        Object[] params = new Object[paramCount];

        paramClazz[0] = int.class;
        params[0] = param0;
        Method md = com.xuanyang.myproxy.demo.Testable.class.getMethod("test", paramClazz);
    return (java.lang.String) h.invoke(this, md, params);
    }catch(Exception e) {e.printStackTrace();}
    return null;
}
}