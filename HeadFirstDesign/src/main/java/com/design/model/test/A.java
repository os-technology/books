package com.design.model.test;

import java.util.HashMap;

public class A {

	
	public static void main(String[] args) {
		HashMap<String,Object> map = new HashMap<>();
		System.out.println("输出信息："+String.valueOf(map.get("info")).length());
	}
}
