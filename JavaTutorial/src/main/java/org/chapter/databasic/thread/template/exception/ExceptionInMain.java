package org.chapter.databasic.thread.template.exception;

//7.主线程中的Java异常(Java Exception in thread main)
public class ExceptionInMain {
	/**
	 * When I created the project in Eclipse, I kept JRE version as JavaSE-1.7
	 * but in my terminal java version is JavaSE-1.6. Because of Eclipse IDE JRE
	 * settings the class file generated is compiled with Java 1.7. Now when I
	 * try to run this class from terminal, I get following exception message.
	 * 
	 * <pre>
	 * These are some of the common java exceptions in thread main, whenever you face any one of these check following:
	
	<li>Same JRE version is used to compile and run the java program</li>
	<li>You are running java class from the classes directory and package is provided as directory.</li>
	<li>Your java classpath is set properly to include all the dependency classes</li>
	<li>You are using only file name without .class extension while running a java program</li>
	<li>Java class main method syntax is correct</li>
	 * </pre>
	 * 
	 * @Author Yu Jinshui
	 * @createTime 2016年6月5日 上午9:47:38
	 */
	public static void main() {
		System.out.println(10);
	}
	/**
	 * 运行结果：<br>
	 * 错误: 在类 ExceptionInMain 中找不到主方法, 请将主方法定义为:<br>
	 * public static void main(String[] args)
	 */

}
