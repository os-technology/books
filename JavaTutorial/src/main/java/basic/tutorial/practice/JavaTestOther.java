package basic.tutorial.practice;

/**
 * java其他忽略部分练习<br/>
 * synchronized训练
 * 
 * @author Yu Jinshui
 * 
 */
public class JavaTestOther {

	public JavaTestOther() {
		// synchronized (this) {
		// System.out.println("synchronized is OK!!");
		// }
	}

	/**
	 * synchronized学习
	 * <p>
	 * Java语言的关键字，当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。
	 * 
	 * 一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。
	 * 另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
	 * 
	 * 二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，
	 * 另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
	 * 
	 * 三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，
	 * 其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
	 * 
	 * 四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，
	 * 它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
	 * 
	 * 五、以上规则对其它对象锁同样适用.
	 */
	static class Example1 implements Runnable {

		@Override
		public void run() {
			synchronized (this) {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName()
							+ "_synchronized " + i);
				}

			}

		}

		public static void main(String[] args) {
			System.out.println("Hello,Example1");
		}

	}

	/**
	 * 二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，
	 * 另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
	 * 
	 * @author Yu Jinshui
	 * 
	 */
	class Example2 {

		/**
		 * 同步方法
		 */
		public void exec1() {
			synchronized (this) {
				int i = 5;
				while (i-- > 0) {
					System.out.println(Thread.currentThread().getName() + ":"
							+ i);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		/**
		 * 非同步方法
		 * <p>
		 * 若把该方法改为同步方法，则执行结果如下：<br/>
		 * th3:4<br/>
		 * th3:3<br/>
		 * th3:2<br/>
		 * th3:1<br/>
		 * th3:0<br/>
		 * (执行完th3之后执行th4)<br/>
		 * th4:4<br/>
		 * th4:3<br/>
		 * th4:2<br/>
		 * th4:1<br/>
		 * th4:0<br/>
		 * ----原因：----
		 * <p>
		 * 三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，
		 * 其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
		 */
		public void exec2() {
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	class Example3 {
		/**
		 * Example3类，仅供配合测试使用
		 */
		public void testExample3() {
			System.out.println("Example3 is successful!!");
		}
		public synchronized void test3(){
			System.out.println("Example3 synchronized method is OK!!");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaTestOther j = new JavaTestOther();
		/*********** 同步方法线程运行结果 **************/
		// Example1 eg = new Example1();
		// Thread th1 = new Thread(eg, "A");
		// Thread th2 = new Thread(eg, "B");
		// th1.start();
		// th2.start();
		// eg.main(args);

		/************ 同步与非同步方法线程运行结果 ***********/

		final Example2 eg2 = j.new Example2();

		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				eg2.exec1();
			}
		};

		Runnable run2 = new Runnable() {

			@Override
			public void run() {
				eg2.exec2();

			}

		};

		Thread th3 = new Thread(run1, "th3");
		Thread th4 = new Thread(run2, "th4");
		th3.start();
		th4.start();
		/**
		 * 两个线程同时运作 <br/>
		 * th3:4 <br/>
		 * th4:4 <br/>
		 * th4:3 <br/>
		 * th3:3 <br/>
		 * th3:2 <br/>
		 * th4:2 <br/>
		 * th3:1 <br/>
		 * th4:1 <br/>
		 * th3:0 <br/>
		 * th4:0 <br/>
		 */
		/****************************/

		synchronized (j) {
			Example3 e3 = j.new Example3();
			e3.testExample3();
			e3.test3();

		}
		

	}
}
