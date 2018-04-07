package com.design.model.observer.review;

public class Client_a implements ObInter {
	int a;

	public Client_a(Sub sub) {
		sub.register(this);
	}

	@Override
	public void update(int a) {
		this.a = a;

	}

	@Override
	public void display() {
		System.out.println("Client a:" + a);

	}

}
