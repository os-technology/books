package com.design.model.observer.review;

public class Client_b implements ObInter {
	int a;

	public Client_b(Sub sub) {
		sub.register(Client_b.this);
	}

	@Override
	public void update(int a) {
		this.a = a;

	}

	@Override
	public void display() {
		System.out.println("Client_b:" + a);

	}

}
