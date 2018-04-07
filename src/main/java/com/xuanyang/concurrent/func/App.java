package com.xuanyang.concurrent.func;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        // 数组的父类都是Object
        int[] a1 = new int[3];
        int[] a2 = new int[4];
        int[][] a3 = new int[2][3];
        String[] a4 = new String[3];
        String[][] a5 = new String[3][3];


        // 任何类型的数组都可以用Object接收
        // 这是因为任何数组类型的父类都是Object
        Object aObj1 = a1;
        Object o = a2;
        Object aObj2 = a4;
        Object aObj3 = a3;
        Object o1 = a5;


//        Object[] aObj4 = a1;
        // Object[] 可以接收二维数组和 因为二维数组是数组的数组
        // Object[] 还可以接收以为引用类型的数组
        Object[] aObj5 = a3;
        Object[] aObj6 = a4;
        Object[] aObj7 = a5;

        int[] arr1 = {1, 2, 3};
        String[] stringarr = {"a", "b", "c"};
        System.out.println(Arrays.asList(arr1));
        System.out.println(Arrays.asList(stringarr));


    }

}
