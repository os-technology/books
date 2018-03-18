package org.sys.thread.one.instance;

/**
 * 
 * 1.2.3 实例变量与线程安全
 * <p>
 * 
 * 
 * @author yujinshui
 * @createTime 2017年4月16日 上午10:11:43
 */
public class InstanceThread extends Thread {
	private int count = 5;

	public InstanceThread(String name) {
		super();
		this.setName(name);
	}

	public InstanceThread() {
		super();
	}

	@Override
	public void run() {
		super.run();
		while (count > 0) {
			count--;
			System.out.println("由线程" + this.currentThread().getName() + "计算，count = " + count);

		}
	}

	/**
	 * 1.正常状况下，创建一个实例，会有自己独立的count值，不与其他线程实例进行共享。
	 * 
	 * @Author yujinshui
	 * @createTime 2017年4月16日 上午10:20:43
	 */
	private static void normalInstance() {
		InstanceThread a = new InstanceThread("A");
		InstanceThread b = new InstanceThread("B");
		InstanceThread c = new InstanceThread("C");
		a.start();
		b.start();
		c.start();
	}

	private static void shareParam() {
		InstanceThread in = new InstanceThread();
		Thread a = new Thread(in, "A");
		Thread b = new Thread(in, "B");
		Thread c = new Thread(in, "C");
		Thread d = new Thread(in, "D");
		Thread e = new Thread(in, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}

	public static void main(String[] args) {
		// normalInstance();
		shareParam();

	}
}
