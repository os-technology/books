package com.view.one;

public class A_9 {

	public void go() {
		DSRoss ds1 = new DSRoss("one");
		ds1.start();
	}

	public static void main(String[] args) {
		A_9 a = new A_9();
		a.go();

	}

}

class DSRoss extends Thread {
	private String sTname = "";

	DSRoss(String s) {
		sTname = s;
	}

	public void run() {
		notwait();
		System.out.println("finished");
	}

	private void notwait() {
		while (true) {
			try {
				System.out.println("waiting");
				wait();
			} catch (InterruptedException e) {
				System.out.println(sTname);
				notifyAll();
			}
		}

	}
}
