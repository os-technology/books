package com.design.builder;

import com.design.model.builder.demo2.KFCFood;

public class KFCTest {
	public static void main(String[] args) {

		KFCFood food = new KFCFood.Flavour().setBeef("牛肉干").setHamburger("大份").setSalad("少放").setVegetable("不要")
				.setCost(30).build();
		System.out.println(food);
	}
}
