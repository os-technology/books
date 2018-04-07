package com.design.model.decorator.demo1Coffee.condiment;

import com.design.model.decorator.demo1Coffee.Beverage;

public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Milk牛奶";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

}
