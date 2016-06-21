package org.chapter.databasic.thread.template.threadlocal;

public class ThreadLocal_String implements Runnable{

	private static final ThreadLocal<String> local = new ThreadLocal<String>() {
		public String initialValue() {
			return " 默认值 ";
		}
	};

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" - Default value:"+local.get());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		local.set(" set 1");
		System.out.println(Thread.currentThread().getName()+" - 输出设定值："+local.get());
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadLocal_String ing = new ThreadLocal_String();
		for(int i=0;i<5;i++){
			Thread th = new Thread(ing," "+i);
			Thread.sleep(1000);
			th.start();
		}
	}
}
