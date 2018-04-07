package com.design.model.observer.reviewDemo;

public class Billboard_a implements ObserverInter, ElementDisplay {
	int a;
	int b;
	int c;

	public Billboard_a(SubjectInter subject) {
		subject.register(this);
	}

	@Override
	public void display() {
		System.out.println("Billboard_a : a=" + a + " b=" + b + " c=" + c);

	}

	@Override
	public void update(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

}
