package com.xuanyang.myproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * Proxy 类动态生成代理类的源码 编译 加载 构造
 *
 * @author xuanyang
 */
public class Proxy {
	public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
		String methodStr = "";
		String rt = "\r\n";
		
		Method[] methods = infce.getMethods();

		/**
		 * 1. 怎么搞返回值 这个好搞
		 * 2. 怎么传参数 1. 在生成方法的时候从method 中获取参数的类型数组 paramType
		 *  paramType 可以然后约定好参数名（param1 param2 ....）当然参数的类型在方法签名上也要有 在字符串上面拼接
		 *  这样方法内部就可以获取参数了
		 *  在方法的开头出定义两个参数 len 参数的个数   List paramType
		 *
		 *
		 */
		for(Method m : methods) {
			// 返回值类型的名字
			String retrunTypeName = m.getReturnType().getName();
			int parameterCount = m.getParameterCount();
			Class<?>[] parameterTypes = m.getParameterTypes();
			ArrayList<Class> classes = new ArrayList<>();
			for (Class<?> parameterType : parameterTypes) {
				String parameterTypeName = parameterType.getName();
				String parameterTypeNameClassString = parameterTypeName + ".class";
			}

			methodStr += "@Override" + rt +
						 "public " + retrunTypeName + " " + m.getName() + "() {" + rt +
						 "    try {" + rt +
						 "    int paramCount = " + parameterCount + ";" + rt +
						 " "  + rt +
						 "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
						 "    return h.invoke(this, md, null);" + rt +
						 "    }catch(Exception e) {e.printStackTrace();}" + rt +
						
						 "}";
		}
		
		String src =
			"package com.xuanyang.myproxy;" +  rt +
			"import java.lang.reflect.Method;" + rt +
			"public class $Proxy1 implements " + infce.getName() + "{" + rt +
			"    public $Proxy1(InvocationHandler h) {" + rt +
			"        this.h = h;" + rt +
			"    }" + rt +
			
			
			"    com.xuanyang.myproxy.InvocationHandler h;" + rt +
							
			methodStr +
			"}";

		// D:\ideaGit\ssm
		String userDir = System.getProperty("user.dir");
		String fileName = userDir + "/src/main/java/com/xuanyang/myproxy/$Proxy1.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load into memory and create an instance
		String loadDir = userDir + "/src/main/java/";
		URL[] urls = new URL[] {new URL("file:/" + loadDir)};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.xuanyang.myproxy.$Proxy1");
		System.out.println(c);
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		return ctr.newInstance(h);
	}
}
