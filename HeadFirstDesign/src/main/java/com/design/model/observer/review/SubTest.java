package com.design.model.observer.review;

public class SubTest {

	public static void main(String[] args) {
		SubImp imp = new SubImp();
		Client_a a = new Client_a(imp);
		Client_b b = new Client_b(imp);
		imp.setValue(6);
		a.display();
		b.display();

	}

}
