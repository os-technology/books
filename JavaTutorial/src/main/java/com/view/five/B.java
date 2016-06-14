package com.view.five;

public class B extends A {
	public B(){
		System.out.println("struct B");
	}
	{
		System.out.println("B");
	}
	static{
		System.out.println("static B");
	}

	public static void main(String[] args) {
		new B();

	}

}
