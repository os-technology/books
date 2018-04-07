package com.design.model.decorator.demo2noodle.condiment;

import com.design.model.decorator.demo2noodle.Noodle;

public class Vegetable extends CondimentConfig {

	private Noodle noodle;

	public Vegetable(Noodle noodle) {
		this.noodle = noodle;
	}

	@Override
	public String getName() {

		return noodle.getName()+" 蔬菜";
	}

	public double cost() {
		return noodle.cost() + 0.5;
	}

}
