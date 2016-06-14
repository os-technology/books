package com.view.one.thread;

public class Thread_two {

	public static void main(String[] args) {

		First f = new First();
		Second s = new Second();

		Thread t1 = new Thread(f);
		Thread t2 = new Thread(s);

		t1.start();
		t2.start();

	}

}

class First extends Thread {

	public void run() {
		synchronized (Thread_two.class) {
			for (int i = 0; i < 10; i++) {
				System.out.println("First " + i);
				if(i%3==0){
					Thread_two.class.notify();
					try {
						Thread_two.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class Second extends Thread {
	public void run() {
		synchronized (Thread_two.class) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Second " + i);
				if(i%2==0){
					Thread_two.class.notify();
					try {
						Thread_two.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
}

/**
 * 1.两个都为非同步线程时可能的结果：<br>
 * First 0<br>
 * First 1<br>
 * Second 0<br>
 * First 2<br>
 * Second 1<br>
 * First 3<br>
 * Second 2<br>
 * Second 3<br>
 * <p>
 * 2.加了同步锁之后，可能的结果[同步锁必须是同一个内容]<br>
 * Second 0<br>
 * Second 1<br>
 * Second 2<br>
 * First 0<br>
 * First 1<br>
 * First 2<br>
 * 
 * 
 * 
 * 
 * 
 */

