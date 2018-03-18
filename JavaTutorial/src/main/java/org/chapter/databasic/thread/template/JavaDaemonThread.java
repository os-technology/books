package org.chapter.databasic.thread.template;

/**
 *
 * When we create a Thread in java, by default it’s a user thread and if it’s
 * running JVM will not terminate the program. When a thread is marked as daemon
 * thread, JVM doesn’t wait it to finish and as soon as all the user threads are
 * finished, it terminates the program as well as all the associated daemon
 * threads. <br>
 * 当我们创建一个线程在java中,默认情况下它是一个用户线程如果JVM不会终止程序运行。线程标记为守护线程时,JVM并不等待它完成,一旦完成所有用户线程,
 * 它终止程序以及所有相关的守护程序线程。
 * 
 * @author Yu Jinshui
 * @createTime 2016年6月6日 上午10:30:19
 */
public class JavaDaemonThread {
	public static void main(String[] args) throws InterruptedException {
		Thread th = new Thread(new DaemonThread(), "th");
		th.setDaemon(true);
		th.start();
		Thread.sleep(4000);
		System.out.println(4);
		System.out.println("Finishing program");
	}

}

class DaemonThread implements Runnable {

	@Override
	public void run() {
		while (true) {
			processSth();
		}

	}

	private void processSth() {
		System.out.println("Processing daemon thread");
		try {
			Thread.sleep(1000);
			System.out.println(1);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}