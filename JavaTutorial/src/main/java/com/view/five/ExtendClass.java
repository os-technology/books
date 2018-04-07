package com.view.five;

public class ExtendClass extends Extend {

	public ExtendClass() {
		System.out.println("ExtendClass");
	}

	public static void prt() {
		System.out.println("2");
	}

	public static void main(String[] args) {
		Extend e = new ExtendClass();
		e = new Extend();

	}

}

class Extend {
	public Extend() {
		System.out.println("Extend");
	}

	public static void prt() {
		System.out.println("1");
	}
}