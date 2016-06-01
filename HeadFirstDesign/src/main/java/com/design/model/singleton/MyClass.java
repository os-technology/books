package com.design.model.singleton;

public class MyClass {

	private static MyClass cls = null;

	public static MyClass getInstance() {
		if (cls == null) {
			cls = new MyClass();
		}
		return cls;

	}

	private MyClass() {

	}

}
