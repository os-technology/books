package org.chapter.databasic.tmp;

public class MyPhone {
	private static void num_1() {
		int[] num = { 0, 1, 2, 3, 4, 8 };// 13011138024
		int[] index = { 1, 3, 0, 1, 1, 1, 3, 5, 0, 2, 4 };
		for (int i : index) {
			System.out.print(num[i]);
		}
	}

	private static void num_2() {
		int[] num = { 2, 4, 0, 3, 1, 8 };// 13011138024
		int[] index = { 4, 3, 2, 4, 4, 4, 3, 5, 2, 0, 1 };
		for (int i : index) {
			System.out.print(num[i]);
		}
	}

	public static void main(String[] args) {
		num_2();
	}
}
