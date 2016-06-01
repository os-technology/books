package org.chapter.databasic.six;

public class Test {
	private static ObjectTest t;

	static {
		t = new ObjectTest();
		System.out.println("Init is OK!");
	}

	public static String info = t.sth + "  info";

	public static void main(String[] args) {
		String a = Test.info;

	}

}
