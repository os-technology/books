package com.design.model.decorator.demo1Coffee.condiment;

import com.design.model.decorator.demo1Coffee.Beverage;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Soy 豆浆";
	}

	@Override
	public double cost() {

		return .15 + beverage.cost();
	}

}
