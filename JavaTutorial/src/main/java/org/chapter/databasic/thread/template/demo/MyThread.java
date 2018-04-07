package org.chapter.databasic.thread.template.demo;
//http://www.importnew.com/9994.html
public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	public void run() {
		System.out.println("MyThread - start " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			doDBProcessing();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MyThread - END " + Thread.currentThread().getName());
	}

	private void doDBProcessing() throws InterruptedException {
		Thread.sleep(1000);
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread my1 = new MyThread("1");
		MyThread my2 = new MyThread("2");
		long a = System.currentTimeMillis();
		my1.start();
		my2.start();
	}

}
