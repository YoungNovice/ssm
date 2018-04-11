package com.xuanyang.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Young on 2018/4/5.
 *
 * 被观察者
 * @author xuanyang
 */
public class ProductList extends Observable {

    private List<String> procuctList = null;

    private static ProductList instance = null;

    private static Lock lock = new ReentrantLock();

    private ProductList() {}

    public static ProductList getInstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new ProductList();
                instance.procuctList = new ArrayList<>(2);
            }
            lock.unlock();
        }
        return instance;
    }

    public ProductList add(Observer observer) {
        this.addObserver(observer);
        return this;
    }

    public void addProduct(String product) {
        //region 这个是我自定义的折叠区域 region endregion
        procuctList.add(product);
        System.out.println("新增了" + product);
        this.setChanged();
        //endregion
        this.notifyObservers(product);
    }

}
