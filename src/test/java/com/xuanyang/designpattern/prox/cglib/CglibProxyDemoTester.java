package com.xuanyang.designpattern.prox.cglib;

import com.xuanyang.designpattern.proxy.cglib.CglibProxyDemo;
import com.xuanyang.designpattern.proxy.jdk.HelloWorld;
import com.xuanyang.designpattern.proxy.jdk.HelloWorldImpl;
import org.junit.Test;

/**
 * Created by Young on 2018/4/5.
 */
public class CglibProxyDemoTester {

    @Test
    public void testProxy() {

        CglibProxyDemo demo = new CglibProxyDemo();
        HelloWorld proxy = (HelloWorld) demo.getproxy(HelloWorldImpl.class);
        proxy.say();

    }
}
