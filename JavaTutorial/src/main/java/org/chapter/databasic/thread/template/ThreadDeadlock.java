package org.chapter.databasic.thread.template;

public class ThreadDeadlock {

	public static void main(String[] args) throws InterruptedException {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();

		Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
		Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
		Thread t3 = new Thread(new SyncThread(obj3, obj2), "t3");

		t1.start();
		Thread.sleep(4000);
		t2.start();
		Thread.sleep(4000);
		t3.start();
	}
}

class SyncThread implements Runnable {

	private Object obj1;
	private Object obj2;

	public SyncThread(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		// deadlock();
		avoidlock();
	}

	// 防止死锁的解决方案
	private void avoidlock() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring - 获得锁定：" + obj1);
		synchronized (obj1) {
			System.out.println(name + " acquired - 已经锁定：" + obj1);
			work();
		}
		System.out.println(name + " released - 释放锁定：" + obj1);
		System.out.println(name + " acquiring - 获得锁定：" + obj2);
		synchronized (obj2) {
			System.out.println(name + " acquired - 已经锁定：" + obj2);
			work();
		}
		System.out.println(name + " released - 释放锁定：" + obj2);
		System.out.println(name + " finished execution.");
	}

	// 死锁demo
	private void deadlock() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring - 获得锁定：" + obj1);
		synchronized (obj1) {
			System.out.println(name + " acquired - 已经锁定：" + obj1);
			work();
			System.out.println(name + " acquiring - 获得锁定：" + obj2);
			synchronized (obj2) {
				System.out.println(name + " acquired - 已经锁定：" + obj2);
				work();
			}
			System.out.println(name + " released - 释放锁定：" + obj2);
		}
		System.out.println(name + " released - 释放锁定：" + obj1);
		System.out.println(name + " finished execution.");

	}

	private void work() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}