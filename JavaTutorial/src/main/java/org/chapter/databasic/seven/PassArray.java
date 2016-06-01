package org.chapter.databasic.seven;

public class PassArray {

	static void vaTest(int v[]) {
		System.out.print("Number of args: " + v.length + " Contents:");
		for (int x : v) {
			System.out.print(x + " ");
		}
	}
	
	static void vaTest2(int... v) {
		System.out.print("Number of args: " + v.length + " Contents:");
		for (int x : v) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		vaTest2(10);
		vaTest2(1,3,4);
		vaTest2();

	}

}
