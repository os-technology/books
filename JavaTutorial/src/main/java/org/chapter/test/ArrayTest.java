package org.chapter.test;

import com.alibaba.fastjson.JSON;

public class ArrayTest {

	public static void main(String[] args) {
		String a[] = { "a", "b" };
		System.out.println(JSON.toJSONString(a));

	}

}
