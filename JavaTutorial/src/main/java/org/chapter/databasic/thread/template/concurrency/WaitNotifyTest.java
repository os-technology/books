package org.chapter.databasic.thread.template.concurrency;

public class WaitNotifyTest {

	public static void main(String[] args) {

		Message msg = new Message("线程测试");

		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter 0").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter, "waiter 1").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		System.out.println("所有线程已经启动。。。");

	}

}
