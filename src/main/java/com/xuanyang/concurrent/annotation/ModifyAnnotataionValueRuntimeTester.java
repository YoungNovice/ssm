package com.xuanyang.concurrent.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 在运行时动态的修改注解的值
 *
 * 现在要做的是获取Bar 上面的注解的值 并修改它的值
 * 下面代码说明一个问题 注解在运行时就是一个对象 它的内容里面的属性放在一个map 中
 *
 * @author xuanyang
 */
public class ModifyAnnotataionValueRuntimeTester {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        SelfAnnotaion annotation = Bar.class.getAnnotation(SelfAnnotaion.class);

        String value = annotation.value();

        InvocationHandler handler = Proxy.getInvocationHandler(annotation);

        Field memberValues = handler.getClass().getDeclaredField("memberValues");

        memberValues.setAccessible(true);

        Map o = (Map) memberValues.get(handler);
        System.out.println(o.get("value"));

    }
}
