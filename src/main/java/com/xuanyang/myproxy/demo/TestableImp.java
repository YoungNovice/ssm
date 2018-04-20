package com.xuanyang.myproxy.demo;

/**
 * Created by Young on 2018/4/20.
 *
 * @author xuanyang
 */
public class TestableImp implements Testable {

    @Override
    public String test(int a) {
        return a + "";
    }
}
