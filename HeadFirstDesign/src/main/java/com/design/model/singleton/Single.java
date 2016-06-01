package com.design.model.singleton;

/**
 * 饿汉式加载
 * 
 * @author shui
 *
 */
public class Single {
	/**
	 * bug代码<br>
	 * private static Single single = new Single();
	 * 
	 * public static Single getInstance() { return single; }
	 */

	/**
	 * 修正代码
	 * <p>
	 * 感谢某位群友提出bug
	 */
	private Single() {

	}

	private static final Single single = new Single();

	public static Single getInstance() {
		return single;
	}

}
