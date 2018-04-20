# Proxy类
##### Proxy的newProxyInstance方法生成代理类的过程
 > 它是由Proxy 类生成源码
 > 由Java编译器 编译它
 > 由ClassLoader 加载它
 > 由反射技术实例化它
 
 ```
package com.xuanyang.myproxy;

import java.lang.reflect.Method;

public class $Proxy1 implements com.xuanyang.myproxy.demo.Testable {
    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }

    com.xuanyang.myproxy.InvocationHandler h;

    @Override
    public java.lang.String test(int param0) {
        try {
            int paramCount = 1;
            Class[] paramClazz = new Class[paramCount];
            Object[] params = new Object[paramCount];
            paramClazz[0] = int.class;
            params[0] = param0;
            Method md = com.xuanyang.myproxy.demo.Testable.class.getMethod("test", paramClazz);
            return (java.lang.String) h.invoke(this, md, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
```