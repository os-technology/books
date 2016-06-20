package com.design.model.observer.reviewDemo;

public class Test {

	public static void main(String[] args) {
		Weather w = new Weather();
		Billboard_a billa = new Billboard_a(w);
		Billboard_b billb = new Billboard_b(w);
		w.setValue(5, 6, 9);
		billa.display();
		billb.display();
	}

}
