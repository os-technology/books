package org.chapter.databasic.thread.template.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FeatureTaskExample {

	public static void main(String[] args) {
		MyCallableDemo demo1 = new MyCallableDemo(1000);
		MyCallableDemo demo2 = new MyCallableDemo(2000);
		FutureTask<String> futureTask1 = new FutureTask<String>(demo1);
		FutureTask<String> futureTask2 = new FutureTask<String>(demo2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);
		while (true) {

			try {
				if (futureTask1.isDone() && futureTask2.isDone()) {
					System.out.println("Done");
					executor.shutdown();
					return;
				}
				if (!futureTask1.isDone()) {
					System.out.println("FutureTask1 output = " + futureTask1.get());
				}
				System.out.println("Waiting for FutureTask to complete");
				String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
				if (s != null) {
					System.out.println("FutureTask2 output=" + s);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}

	}

}
