package org.chapter.databasic.thread.template.blockqueue;

import org.chapter.databasic.thread.template.concurrency.Message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The producer consumer service will create the BlockingQueue with fixed size
 * and it will be shared by both producers and consumers. This service will
 * start producer and consumer threads and exit.
 * 
 * @author gao
 *
 */
public class ProducerConsumerService {

	public static void main(String[] args) {
		// Creating BlockingQueue of size 10
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(consumer).start();
		new Thread(producer).start();
		System.out.println("Producer and Consumer has been started.");

	}

}
