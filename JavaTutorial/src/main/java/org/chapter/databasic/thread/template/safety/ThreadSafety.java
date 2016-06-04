package org.chapter.databasic.thread.template.safety;

public class ThreadSafety {

	public static void main(String[] args) throws InterruptedException {

		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		// wait for threads to finish processing
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}
	/**
	 * t1 1000<br>
	 * t2 1000<br>
	 * result is :1<br>
	 * result is :2<br>
	 * t1 2000<br>
	 * t2 2000<br>
	 * result is :3<br>
	 * result is :4<br>
	 * t1 3000<br>
	 * result is :5<br>
	 * t2 3000<br>
	 * result is :6<br>
	 * t2 4000<br>
	 * result is :7<br>
	 * t1 4000<br>
	 * result is :8<br>
	 * Processing count=8
	 */
}

class ProcessingThread implements Runnable {
	private int count;
	private String info = "";

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count++;
			System.out.println("result is :" + count);
		}
	}

	public int getCount() {
		return this.count;
	}

	private void processSomething(int i) {
		// processing some job
		try {
			Thread.sleep(i * 1000);
			String name = Thread.currentThread().getName();
			System.out.println(name + "  " + (i * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}