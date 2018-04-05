package com.xuanyang.designpattern.observer;

import org.junit.Test;

/**
 * Created by Young on 2018/4/5.
 */
public class ObserverTester {

    @Test
    public void testDemo() {
        ProductList list = ProductList.getInstance();
        list.add(new JDObserver()).add(new TbObserver());
        list.addProduct("一个华为P20手机");
    }
}
