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

	// 5，11，1。排序最大值，5.11.1。
	private void getNumOrder() {

	}

	private int getFirstNum(int input) {
		String in = String.valueOf(input);
		char inp = in.charAt(0);

		return Integer.parseInt(inp + "");
	}

	public static void main(String[] args) {
		NumOrder num = new NumOrder();
		// num.zeroCount();

	}

}
