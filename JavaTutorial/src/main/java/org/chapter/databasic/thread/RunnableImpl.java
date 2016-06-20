package org.chapter.databasic.thread;
//http://www.importnew.com/9994.html
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Begin sleep");
			Thread.sleep(2000);
			System.out.println("End sleep");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
