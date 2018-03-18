package com.design.model.builder.tmp;

public class BuildClass {
	private static BuildClass build = new BuildClass();
	private String a;
	private String b;
	private String c;

	public static BuildClass getInstance() {
		return build;
	}

	public BuildClass setA(String a) {
		this.a = a;
		return this;
	}

	public BuildClass setB(String b) {
		this.b = b;
		return this;
	}

	public BuildClass setC(String c) {
		this.c = c;
		return this;
	}

	public static void main(String[] args) {
		BuildClass B = BuildClass.getInstance().setA("a").setB("b").setC("c");
		System.out.println(B.a);

	}

}
