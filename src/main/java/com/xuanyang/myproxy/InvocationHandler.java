package com.xuanyang.myproxy;

import java.lang.reflect.Method;

/**
 * 动态代理业务逻辑层
 *
 * @author xuanyang
 */
public interface InvocationHandler {

	/**
	 * jdk 代理钩子方法
	 *
	 * @param proxy 代理对象
	 * @param m Method
	 * @param args 方法参数
	 * @return 返回值
	 */
	Object invoke(Object proxy, Method m, Object[] args);
}
