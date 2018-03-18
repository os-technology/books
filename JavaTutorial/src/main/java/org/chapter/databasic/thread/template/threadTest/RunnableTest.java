package org.chapter.databasic.thread.template.threadTest;

public class RunnableTest extends Thread {
	private static Object info = new Object();
	private static RunnableTest t1 = null;
	private static RunnableTest t2 = null;
	static boolean flag = true;

	public static void main(String[] args) throws InterruptedException {
		t1 = new RunnableTest() {
			@Override
			public void run() {
				synchronized (info) {

					for (int i = 1; i < 53; i++) {
						System.out.print(i);
						if (flag && i % 2 == 0) {
							info.notify();
							flag = false;
							if (i < 53)
								try {
									info.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
						}
					}
				}
			}
		};

		t2 = new RunnableTest() {
			@Override
			public void run() {
				synchronized (info) {
					for (int i = 65; i < 91; i++) {
						if (!flag) {
							System.out.println(" " + (char) i + " ");
							flag = true;
							info.notify();
							if (i < 91)
								try {
									info.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
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
