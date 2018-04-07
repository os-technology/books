package com.design.model.decorator.demo1Coffee.cof;

import com.design.model.decorator.demo1Coffee.Beverage;


/**
 * 综合咖啡
 * 
 * @author shui
 *
 */
public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "HouseBlend Coffee 综合咖啡";
	}

	@Override
	public double cost() {
		return 0.89;
	}

}
