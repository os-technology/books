package com.view.five;

class Base {
	int i;

	Base() {
		add(1);
		System.out.println(i);
	}

	void add(int v) {
		i += v;
		print();
	}

	void print() {
		System.out.println(i);
	}
}

class MyBase extends Base {
	MyBase() {
		add(2);
	}

	void add(int v) {
		i += v * 2;
		print();
	}
}

public class Extend_order {
	public static void main(String[] args) {
		go(new MyBase());
	}

	private static void go(Base b) {
		b.add(8);
	}

}
