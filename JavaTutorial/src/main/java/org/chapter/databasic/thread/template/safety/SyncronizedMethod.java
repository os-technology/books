package org.chapter.databasic.thread.template.safety;

import java.util.Arrays;

/**
 * Here is another example where multiple threads are working on same array of
 * Strings and once processed, appending thread name to the array value.<br>
 * 这是另一个例子,多个线程正在相同的字符串数组和一次处理,附加线程名称的数组值。
 * 
 * @author Yu Jinshui
 * @createTime 2016年6月4日 下午3:34:40
 */
public class SyncronizedMethod {
	public static void main(String[] args) throws InterruptedException {
		String[] arr = { "1", "2", "3", "4", "5", "6" };
		HashMapProcessor hmp = new HashMapProcessor(arr);
		Thread t1 = new Thread(hmp, "t1");
		Thread t2 = new Thread(hmp, "t2");
		Thread t3 = new Thread(hmp, "t3");
		long start = System.currentTimeMillis();
		// start all the threads
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println("Time taken=" + (System.currentTimeMillis() - start));

		System.out.println(Arrays.asList(hmp.getMap()));

	}
}

class HashMapProcessor implements Runnable {
	private String[] strArr = null;

	public HashMapProcessor(String[] m) {
		strArr = m;
	}

	public String[] getMap() {
		return strArr;
	}

	@Override
	public void run() {
		processArr(Thread.currentThread().getName());

	}

	private void processArr(String name) {
		for (int i = 0; i < strArr.length; i++) {
			processSomething(i);
			addThreadName(i, name);
		}
	}

	private Object syn = new Object();

	private void addThreadName(int i, String name) {
		synchronized (syn) {
			strArr[i] = strArr[i] + ":" + name;
		}
	}

	private void processSomething(int index) {
		// processing some job
		try {
			Thread.sleep(index * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
