package com.xuanyang.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Young on 2018/4/5.
 *
 * @author xuanyang
 */
public class JdObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        String product = (String) arg;
        System.out.println("我是jd"+"我收到了"+product);
    }
}
