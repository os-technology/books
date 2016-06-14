package com.view.five;

public class Child extends Parent {
	protected String value = "456";

	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.getValue());
		Parent p = new Parent();
		System.out.println(p.getValue());
	}

}

class Parent {
	protected String value = "123";

	public String getValue() {
		return value;
	}

}