package com.design.model.decorator.demo2noodle.condiment;

import com.design.model.decorator.demo2noodle.Noodle;

public class Beef extends CondimentConfig {
	private Noodle noodle;

	public Beef(Noodle noodle) {
		this.noodle = noodle;
	}

	@Override
	public String getName() {
		return noodle.getName()+" 牛肉";
	}

	public double cost() {
		return noodle.cost() + 1;
	}

}
