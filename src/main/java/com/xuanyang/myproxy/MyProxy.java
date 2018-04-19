package com.xuanyang.myproxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created by Young on 2018/4/19.
 */
public class MyProxy {

    public static Object newProxyInstance(ClassLoader loader,
              Class<?>[] interfaces, InvocationHandler h)
            throws IllegalArgumentException {
        StringBuilder builder = new StringBuilder("");
        String proxyName = "TestProxy";
        String interfaceString = "Testable,InvocationHandler";
        builder.append("package com.xuanyang.myproxy.demo;").append("\n");
        builder.append("\n");
        builder.append("import com.xuanyang.myproxy.MyInvocationHandler;").append("\n");
        builder.append("\n");
        builder.append("public class ").append(proxyName).append(" implements ");
        builder.append(interfaceString);
        builder.append(" {\n");



        for (Class<?> Interface : interfaces) {

        }

        return null;
    }
}
