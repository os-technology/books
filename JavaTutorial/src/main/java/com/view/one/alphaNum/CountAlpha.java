/**
 * 
 */
package com.view.one.alphaNum;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 
 *  数字母:A 通知CountNumeric, B 通知,,and so on
 * 
 * @author
 *
 */
public class CountAlpha extends Counter {
	public CountAlpha(Lock lock, Condition condition, CountDownLatch latch) {
		super(lock, condition, latch);
	}

	@Override
	protected void execute() {
		for (char c = 'A'; c <= 'Z'; c++) {
			signalAndWait();
			System.out.println("Thread:" + Thread.currentThread().getName() + ",Alpha:" + c);
		}
	}
}
