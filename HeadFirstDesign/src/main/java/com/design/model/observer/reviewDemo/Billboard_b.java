package com.design.model.observer.reviewDemo;

public class Billboard_b implements ElementDisplay, ObserverInter {
	int a;
	int b;
	int c;

	public Billboard_b(SubjectInter subject) {
		subject.register(this);
	}

	@Override
	public void update(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		display();

	}

	@Override
	public void display() {
		System.out.println("Billboard_b 第一个值：" + a + ",第二个值：" + b + ",第三个值：" + c);

	}

}
