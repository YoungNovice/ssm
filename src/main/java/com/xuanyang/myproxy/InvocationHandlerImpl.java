package com.xuanyang.myproxy;

import com.xuanyang.myproxy.demo.Testable;

import java.lang.reflect.Method;

/**
 * Created by Young on 2018/4/20.
 * 代理Testable的具体业务
 * 打印方法的第一个参数 并传递一个456
 *
 * @author xuanyang
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Testable target;

    public InvocationHandlerImpl(Testable target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) {
        Object returnVal = null;
        try {
            System.out.println(args[0]);
           returnVal = m.invoke(target, 456);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnVal;
    }
}
