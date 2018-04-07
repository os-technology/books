package org.chapter.databasic.thread.template.concurrency;

public class Waiter implements Runnable {

	private Message msg;

	public Waiter(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();

		synchronized (msg) {
			try {
				System.out.println(name + " 进入等待状态，等待被唤醒。当前时间：" + System.currentTimeMillis());
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " 线程等待结束，已被唤醒，当前时间：" + System.currentTimeMillis());
			System.out.println(name + " 线程：" + msg.getMsg());
		}

	}

}