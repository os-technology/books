package org.chapter.test;

import org.chapter.test.type.EnumType;

public class EnumTest {

	public static void e() throws IllegalAccessException {
		try {
			if (1 == 1) {
				throw new IllegalAccessException("throw exception...");
			}
		} finally {
			System.out.println("输出finally部分");
		}
	}

	public static void main(String[] args) {
		try {
			e();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
