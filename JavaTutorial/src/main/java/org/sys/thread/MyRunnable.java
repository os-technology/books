package org.sys.thread;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("运行中");

	}

	public static void main(String[] args) {
		MyRunnable run = new MyRunnable();
		Thread th = new Thread(run);
		th.start();
		System.out.println("运行结束");

	}

}
