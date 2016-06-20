package org.chapter.databasic.thread.template;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 10.【不懂】Java线程本地变量(Thread Local)
 * <p>
 * 我们知道线程共享对象的变量，但如何得到类级别的线程局部变量呢？Java提供了ThreadLocal实用类来创建线程局部变量,
 * 在这篇文章中学习如何在Java程序中创建ThreadLocal变量。
 * 
 * @author Yu Jinshui
 * @createTime 2016年6月6日 上午10:32:48
 */
public class ThreadLocalExample implements Runnable {

	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};

	@Override
	public void run() {
		System.out.println("Thread name = " + Thread.currentThread().getName() + " default formatter = "
				+ formatter.get().toPattern());

		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		formatter.set(new SimpleDateFormat());
		System.out.println(
				"Thread Name = " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalExample obj = new ThreadLocalExample();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(obj, "" + i);
			Thread.sleep(new Random().nextInt(1000));
			t.start();
		}
	}

}
