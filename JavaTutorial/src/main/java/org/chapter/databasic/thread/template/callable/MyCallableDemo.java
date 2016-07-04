package org.chapter.databasic.thread.template.callable;

import java.util.concurrent.Callable;

public class MyCallableDemo implements Callable<String> {

	private long waitTime;

	public MyCallableDemo(int timeMillis) {
		this.waitTime = timeMillis;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}

}
