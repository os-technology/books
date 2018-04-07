package org.chapter.databasic.thread.template.safety;

//8.单例类中的线程安全(Thread Safety in Singleton Class)
public class ASingleton {
	private static ASingleton instance = null;
	private static Object mutex = new Object();

	private ASingleton() {
	}

	/**
	 * Create the instance variable at the time of class loading:
	 * 
	 * <pre>
	 * Pros:【正面】
	 * ·Thread safety without synchronization 
	 * ·Easy to implement
	 * Cons:【反面】
	 * ·Early creation of resource that might not be used in the application.
	 * ·The client application can’t pass any argument, so we can’t reuse it. For example, having a generic singleton class for database connection where client application supplies database server properties.
	 * </pre>
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年6月5日 上午10:36:40
	 */
	public static ASingleton getInstance() {
		if (instance == null) {
			instance = new ASingleton();
		}
		return instance;
	}

	/**
	 * Synchronize the getInstance() method
	 * 
	 * <pre>
	 * Pros:
	 * ·Thread safety is guaranteed.
	 * ·Client application can pass parameters
	 * ·Lazy initialization achieved
	 * Cons:
	 * ·Slow performance because of locking overhead.
	 * ·Unnecessary synchronization that is not required once the instance variable is initialized.
	 * </pre>
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年6月5日 上午10:39:01
	 */
	public static synchronized ASingleton getSynInstance() {
		if (instance == null) {
			instance = new ASingleton();
		}
		return instance;
	}

	/**
	 * 3.Use synchronized block inside the if loop
	 * 
	 * <pre>
	 * Pros:
	 * Thread safety is guaranteed
	 * Client application can pass arguments
	 * Lazy initialization achieved
	 * Synchronization overhead is minimal and applicable only for first few threads when the variable is null.
	 * Cons:
	 * Extra if condition
	 * </pre>
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年6月5日 上午11:03:04
	 */
	public static ASingleton getSynblockInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null)
					instance = new ASingleton();
			}
		}
		return instance;
	}

}
