package org.chapter.databasic.thread.template.blockqueue;

import org.chapter.databasic.thread.template.concurrency.Message;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			Message msg;
			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(10);
				System.out.println("Consumed :" + msg.getMsg());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
