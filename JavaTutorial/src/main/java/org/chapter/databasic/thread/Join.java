package org.chapter.databasic.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Join {

	public static void main(String args[]) throws InterruptedException {

		System.out.println(Thread.currentThread().getName() + " is Started");

		Thread exampleThread = new Thread() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " is Started");
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " is Completed");
				} catch (InterruptedException ex) {
					Logger.getLogger(Join.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		};

		exampleThread.start();
		exampleThread.join();

		System.out.println(Thread.currentThread().getName() + " is Completed");
	}

	// Read more:http://
	// javarevisited.blogspot.com/2013/02/how-to-join-multiple-threads-in-java-example-tutorial.html#ixzz4AIFyKPia
}
