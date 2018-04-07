package com.xuanyang.concurrent.func;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义自己的类加载器
 *
 * @author xuanyang
 */
public class MyClassLoader extends ClassLoader {



    public static void main(String[] args) {
        String name = new String("yangxuan");
        String name1 = new String("yangxuan");
        System.out.println(name == name1);


    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }


    public static void cypher(InputStream is, OutputStream os) throws IOException {
        int b = -1;
        while ((b = is.read()) != -1) {
            os.write(b ^ 0xff);
        }
    }

}
