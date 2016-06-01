package com.design.model.singleton;

/**
 * 懒汉式加载
 * 
 * @author shui
 *
 */
public class SynSingle {
	/**
	 * <pre>
	 * 感谢某位群友提出bug
	 * 
	 * private static SynSingle synSingle;
	 * 
	 * public static SynSingle getInstance() {
	 * 	if (synSingle == null) {
	 * 		synchronized (synSingle) {
	 * 			synSingle = new SynSingle();
	 * 		}
	 * 	}
	 * 	return synSingle;
	 * }
	 * </pre>
	 */

	private SynSingle() {

	}
	private static class SynSingleInstance {
		private static final SynSingle synSingle = new SynSingle();
	}

	public static SynSingle getInstance() {
		return SynSingleInstance.synSingle;
	}
}
