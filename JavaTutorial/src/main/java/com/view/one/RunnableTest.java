package com.view.one;

import java.util.Random;

public class RunnableTest implements Runnable {
static int i=0;
	public static void main(String[] args) {
		RunnableTest t1 = new RunnableTest();
		RunnableTest t2= new RunnableTest();
		
		Thread d1 = new Thread(t1);
		Thread d2 = new Thread(t2);
		d1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		i++;
		d2.start();
		

	}

	@Override
	public void run() {
		i = (new Random(10)).nextInt(10);
		System.out.println("hello world"+i);
		
	}

}
