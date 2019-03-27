/**
 * 
 */
package com.view.one.alphaNum;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author
 *
 */
public class CountNumber extends Counter {

	public CountNumber(Lock lock, Condition condition, CountDownLatch latch) {
		super(lock, condition, latch);
	}

	@Override
	protected void execute() {
		for (int c = 1; c <= 52;) {
			System.out.println("Thread:" + Thread.currentThread().getName() + ",Number:" + c++);
			System.out.println("Thread:" + Thread.currentThread().getName() + ",Number:" + c++);
			signalAndWait();
		}
	}
}
