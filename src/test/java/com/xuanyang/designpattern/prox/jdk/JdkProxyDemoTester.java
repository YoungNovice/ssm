package com.xuanyang.designpattern.prox.jdk;

import com.xuanyang.designpattern.proxy.intercepter.Intercepter2;
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
    public void testJdkProxyChain() {
        HelloWorld proxy1 = (HelloWorld) JdkProxyDemo.bind(new HelloWorldImpl(), new MyIntercepter());
        HelloWorld proxy2 = (HelloWorld) JdkProxyDemo.bind(proxy1, new Intercepter2());
        proxy2.say();
    }

}
