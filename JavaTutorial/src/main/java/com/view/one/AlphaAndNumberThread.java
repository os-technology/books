package com.view.one;

/**
 * 交替输出字母与数字信息
 */
public class AlphaAndNumberThread extends Thread {
	private static Object info = new Object();
	private static AlphaAndNumberThread t1 = null;
	private static AlphaAndNumberThread t2 = null;
	static boolean flag = true;

	public void printResult() {
		t1 = printNumber();
		t2 = printAlpha();


		t2.start();
		t1.start();
	}

	private AlphaAndNumberThread printAlpha() {
		return new AlphaAndNumberThread() {
			@Override
			public void run() {
				synchronized (info) {
					for (int i = 65; i < 91; i++) {
						if (!flag) {
							System.out.println(" " + (char) i + " ");
							flag = true;
							info.notify();
							if (i < 91){
								try {
									info.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		};
	}

	private AlphaAndNumberThread printNumber() {
		return new AlphaAndNumberThread() {
			@Override
			public void run() {
				synchronized (info) {

					for (int i = 1; i < 53; i++) {
						System.out.print(i);
						if (flag && i % 2 == 0) {
							info.notify();
							flag = false;
							if (i < 53) {
								try {
									info.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		};
	}

	public static void main(String[] args) {
		AlphaAndNumberThread aat = new AlphaAndNumberThread();
		aat.printResult();
	}
}
