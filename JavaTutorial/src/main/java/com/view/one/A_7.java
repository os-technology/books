package com.view.one;

public class A_7 extends Thread {

	static String sName = "vandeleur";

	public static void main(String[] args) {
		A_7 a = new A_7();
		a.piggy(sName);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sName);
		//输出结果有五种可能：vandeleur，vandeleur 0，vandeleur 0 1，vandeleur 0 1 2，vandeleur 0 1 2 3
	}

	public void piggy(String sName) {
		sName = sName + "wiggy";
		start();
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			sName = sName + " " + i;
		}
	}

}
