/**
 * 
 */
package com.view.one.alphaNum;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author LiuJian
 */
public abstract class Counter implements Runnable {

	private Lock lock;
	private Condition condition;
	private CountDownLatch latch;

	private Lock lock() {
		return lock;
	}

	private Condition condition() {
		return condition;
	}

	public Counter(Lock lock, Condition condition, CountDownLatch latch) {
		this.lock = lock;
		this.condition = condition;
		this.latch = latch;
	}

	protected void signal() {
		try {
			lock().lock();
			condition().signal();
		} finally {
			lock().unlock();
		}
	}

	protected void signalAndWait() {
		try {
			lock().lock();
			condition().signal();
			try {
				latch.countDown();
				condition().await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			lock().unlock();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Enter.");
		execute();
		signal();
		System.out.println(Thread.currentThread().getName() + " Leave.");
	}

	protected abstract void execute();
}
