package com.view.one;

import java.util.Random;

public class ThreadTest extends Thread {
	private String input;
	private static Object syn = new Object();
	private static Object syn1 = new Object();
	private static boolean flag = true;

	public ThreadTest(String ran) {
		input = ran;
	}

	public ThreadTest() {
	}

	static ThreadTest t1 = null;
	static ThreadTest t2 = null;

	public static void main(String[] args) {
		t1 = new ThreadTest("线程1") {
			public void run() {
				synchronized (syn) {
					for (int i = 1; i < 53; i++) {
						System.out.print(i);
						if (flag && i % 2 == 0) {
							flag = false;
							syn.notify();
							if (i < 53) {
								try {
									syn.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();

								}
							}
						}
					}

				}
			}
		};
		t2 = new ThreadTest("线程2") {
			public void run() {
				synchronized (syn) {
					for (int j = 65; j < 91; j++) {
						System.out.print(  " "+(char) j + " ");

						if (!flag) {
							flag = true;
							syn.notify();
							if (j < 91) {
								try {
									syn.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();

								}
							}
						}
					}
				}
			}
		};
		t1.start();
		t2.start();
	}

}
//可能的结果： A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z 12