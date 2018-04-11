package com.xuanyang.designpattern.proxy.jdk;

/**
 *
 * @author Young
 * @date 2018/4/5
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void say() {
        System.out.println("Hello World");
    }
}
