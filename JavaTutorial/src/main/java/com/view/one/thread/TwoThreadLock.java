package com.view.one.thread;

/**
 * 线程知识<br>
 * 两个线程交替执行，a线程打印123，b线程打印456 和打印次数，执行结果是123456 0 123456 1 123456 2 ......
 * 
 * @author shangjie
 *
 */
public class TwoThreadLock {

	private static Object LOCK = new Object();
	private static boolean flag = false;

	public static void main(String[] args) {

		Thread b = new Thread() {
			public void run() {
				for (int c = 0; c <= 10; c++) {
					synchronized (LOCK) {
						for (int i = 4; i <= 6; i++) {
							System.out.print(i);
						}
						System.out.print(" " + c);
						System.out.println();
						if (flag) {
							flag = false;
							LOCK.notify();
							if (c < 10) {
								try {
									LOCK.wait();

								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

						}
					}

				}
			}
		};

		Thread a = new Thread() {
			public void run() {
				for (int c = 0; c <= 10; c++) {
					synchronized (LOCK) {
						for (int i = 1; i <= 3; i++) {
							System.out.print(i);
						}
						if (!flag) {
							flag = true;
							LOCK.notify();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
							if (c < 10) {
								try {
									LOCK.wait();// 在wait后的瞬间线程b得到锁

								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

						}
					}
				}
			}
		};

		a.start();
		b.start();
	}
}