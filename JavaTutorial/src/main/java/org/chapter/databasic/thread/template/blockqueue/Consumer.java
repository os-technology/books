package org.chapter.databasic.thread.template.blockqueue;

import java.util.concurrent.BlockingQueue;

import org.chapter.databasic.thread.template.concurrency.Message;

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
