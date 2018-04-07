package org.chapter.databasic.thread.template.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link http://www.journaldev.com/1069/threadpoolexecutor-java-thread-pool-example-executorservice}
 * Here is the test program class SimpleThreadPool.java, where we are creating
 * fixed thread pool from Executors framework.
 * 
 * @author gao
 *
 */
public class SimpleThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {

		}
		System.out.println("Finished all threads");
	}
}
