package org.chapter.databasic.thread.template.blockqueue;

import org.chapter.databasic.thread.template.concurrency.Message;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> q) {
		queue = q;
	}

	@Override
	public void run() {
		// produce messages
		for (int i = 0; i < 100; i++) {
			Message msg = new Message("" + i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced :" + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// adding exit message
		Message msg = new Message("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
