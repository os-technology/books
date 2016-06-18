package org.chapter.databasic.interview.cal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumOrder {

	/**
	 * 给定一 个正整数，判断里面一共有多少个0.（不能用字符串计算有多少个0）
	 */
	public void zeroCount() {
		String a = "1020000";
		String regex = "[0]";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(a);
		String out = "";
		while (match.find()) {
			out += match.group();
		}

		System.out.println(out.length());
	}

	// 5，13，1。排序最大值，5.11.1。
	// 5,13,14,结果：5-14-13
	// 5,122,13,结果：5-13-122
	private void getNumOrder() {
		int[] a = { 1, 5, 21 };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (getFirstNum(a[j]) < getFirstNum(a[j + 1])) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
		for (int out : a) {
			System.out.print(out + "-");
		}

	}

	private int getFirstNum(int input) {
		String in = String.valueOf(input);
		char inp = in.charAt(0);
		return Integer.parseInt(inp + "");
	}

	/**
	 * 
	 * @param input
	 *            输入值
	 * @param len
	 *            取前多少位
	 * @return
	 */
	private int getPointNum(int input, int len) {
		String in = String.valueOf(input);
		if(in.length()<len) return 9999;
		String inp = in.substring(len-1, len);
		return Integer.parseInt(inp + "");
	}

	int count = 1;

	private void getNumOrder(int[] a, int max) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (getPointNum(a[j], count) < getPointNum(a[j + 1], count)) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
		if (count < max) {
			getNumOrder(a, count++);
		} else {
			for (int out : a) {
				System.out.print(out + "-");
			}
		}

	}

	public static void main(String[] args) {
		NumOrder num = new NumOrder();
		// num.zeroCount();
		// num.getNumOrder();
		int[] a = { 132, 5, 14 ,15};// 5,14,13
		num.getNumOrder(a, 2);

	}

}
