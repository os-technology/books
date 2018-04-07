package org.chapter.databasic.thread.template.demo;

public class HeavyWorkRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Doing heavy processing - START " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			// Get database connection, delete unused data from DB
			doDBProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Doing heavy processing - END " + Thread.currentThread().getName());
	}

	private void doDBProcessing() throws InterruptedException {
		Thread.sleep(1000);
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new HeavyWorkRunnable());
		thread.start();
//		thread.join();
		for(int i=0;i<3;i++){
			System.out.print(i+" ");
		}
		
	}
}
