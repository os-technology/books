package com.view.five;

public class BSon extends AParent {
	public BSon(){
		System.out.println("struct BSon");
	}
	{
		System.out.println("BSon");
	}
	static{
		System.out.println("static BSon");
	}

	public static void main(String[] args) {
		new BSon();

	}

}
