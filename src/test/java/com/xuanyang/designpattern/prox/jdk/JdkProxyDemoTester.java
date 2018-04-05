package com.xuanyang.designpattern.prox.jdk;

import com.xuanyang.designpattern.proxy.intercepter.MyIntercepter;
import com.xuanyang.designpattern.proxy.jdk.HelloWorld;
import com.xuanyang.designpattern.proxy.jdk.HelloWorldImpl;
import com.xuanyang.designpattern.proxy.jdk.JdkProxyDemo;
import org.junit.Test;

/**
 * Created by Young on 2018/4/5.
 */

public class JdkProxyDemoTester {

    @Test
    public void testJdkProxy() {
        JdkProxyDemo proxyDemo = new JdkProxyDemo();
        HelloWorld proxy = (HelloWorld) proxyDemo.bind(new HelloWorldImpl(), new MyIntercepter());
        proxy.say();
    }
}
