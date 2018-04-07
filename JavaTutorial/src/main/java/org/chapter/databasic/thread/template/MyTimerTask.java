package org.chapter.databasic.thread.template;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Time task started at:" + new Date());
		completeTask();
		System.out.println("Time task finished at:"+new Date());
	}

	private void completeTask() {
		try {
			//assuming it takes 10 secs complete the task
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		TimerTask timerTask = new MyTimerTask();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 5*1000);
		System.out.println("TimerTask started");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
