package org.sys.thread;

/**
 * 多线程——1
 * <p>
 * start()方法是为了将线程交给线程规划器进行处理，实现异步效果。 <br>
 * start()方法的调用不代表线程的启动顺序<br>
 * 如果调用run()，则只会通过main函数调用，不走线程规划器，属于单一线程。
 * 
 * @author yujinshui
 * @createTime 2017年3月15日 上午7:48:34
 */
public class MyThread extends Thread {

	public void run() {
		for (int i = 0; i < 10; i++) {
			int time = (int) (Math.random() * 1000);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("run=" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.setName("myThread");
			thread.start();

			for (int i = 0; i < 10; i++) {
				int time = (int) (Math.random() * 1000);

				Thread.sleep(time);

				System.out.println("run=" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("运行结束");

	}

}
