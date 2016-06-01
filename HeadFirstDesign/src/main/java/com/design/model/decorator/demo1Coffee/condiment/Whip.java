package com.design.model.decorator.demo1Coffee.condiment;

import com.design.model.decorator.demo1Coffee.Beverage;

/**
 * 奶泡调料
 * 
 * @author shui
 *
 */
public class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Whip奶泡";
	}

	@Override
	public double cost() {

		return .10 + beverage.cost();
	}

}
