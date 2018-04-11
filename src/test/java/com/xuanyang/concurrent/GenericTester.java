package com.xuanyang.concurrent;

import org.junit.Test;

/**
 * Created by Young on 2018/4/11.
 */
public class GenericTester {

    @Test
    public void testGeneric() {
        Object o1 = "avc";
        String o = autoConvert(o1);
        System.out.println(o);

    }

    /**
     * 方法的返回值是T 那么我用什么接收我就会把参数转成什么
     *
     * @param o param
     * @return T type
     */
    @SuppressWarnings({"unchecked"})
    private static <T> T autoConvert(Object o) {
        return (T)o;
    }
}
