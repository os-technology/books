package com.view.five;

public class Test {
	int res = 0;
	/**
	 * 1 1 2 3 5 8 13 21...
	 * 
	 * @param i
	 * @return
	 */
	public int result(int i) {
		if (i > 2) {
			res = result(i - 1) + result(i - 2);
		} else {
			res = 1;
		}
		return res;
	}
	public static void main(String[] args) {

	}

}
