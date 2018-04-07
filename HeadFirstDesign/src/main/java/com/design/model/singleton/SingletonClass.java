package com.design.model.singleton;

/**
 * 双重检查锁
 * 
 * @author Yujinshui
 *
 */
public class SingletonClass {

	private volatile static SingletonClass instance;

	public static SingletonClass getInstance() {
		if (instance == null) {
			synchronized (SingletonClass.class) {
				if (instance == null) {
					instance = new SingletonClass();
				}
			}
		}
		return instance;
	}
}
