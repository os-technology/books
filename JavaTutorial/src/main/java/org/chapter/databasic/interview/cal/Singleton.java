package org.chapter.databasic.interview.cal;

public class Singleton {
	private Singleton() {

	}

	private static Singleton instance = null;
	private static Object ton = new Object();

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (ton) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
