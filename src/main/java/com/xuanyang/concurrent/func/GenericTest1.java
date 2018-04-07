package com.xuanyang.concurrent.func;


public class GenericTest1 {

    public static void main(String[] args) {


        Object o1 = "avc";
        String o = autoConver(o1);
        System.out.println(o);

    }

    /**
     * 方法的返回值是T 那么我用什么接收我就会把参数转成什么
     * @param o
     * @param <T>
     * @return
     *
     */
    public static <T> T autoConver(Object o) {
        return (T)o;
    }
}
