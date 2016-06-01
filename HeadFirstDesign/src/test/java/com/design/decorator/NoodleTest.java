package com.design.decorator;

import com.design.model.decorator.demo2noodle.BeefNoodle;
import com.design.model.decorator.demo2noodle.Noodle;
import com.design.model.decorator.demo2noodle.condiment.Beef;
import com.design.model.decorator.demo2noodle.condiment.Vegetable;

public class NoodleTest {

	public static void main(String[] args) {
		Noodle bn = new BeefNoodle();
		bn = new Beef(bn);
		bn = new Beef(bn);
		bn = new Vegetable(bn);
		System.out.println(bn.cost()+bn.getName());

	}

}
