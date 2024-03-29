/**
 * 
 */
package com.view.one.alphaNum;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 *
 */
public class CounterRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
			CountDownLatch latch = new CountDownLatch(1);
			Lock lock = new ReentrantLock();
			Condition condition = lock.newCondition();
			service.execute(new CountAlpha(lock, condition, latch));
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			service.execute(new CountNumber(lock, condition, latch));
		} finally {
			service.shutdown();
		}
	}
}
