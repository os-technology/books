package com.design.model.decorator.demo1Coffee.condiment;

import com.design.model.decorator.demo1Coffee.Beverage;

/**
 * 调料抽象类
 * <p>
 *
 * 
 * <br>
 * 配料<br>
 * 牛奶 Milk	.10<br>
 * 摩卡Mocha	.20<br>
 * 豆浆Soy 	.15<br>
 * 奶泡Whip 	.10<br>
 * 
 * @author shui
 *
 */
public abstract class CondimentDecorator extends Beverage {

	public abstract String getDescription();

	@Override
	public abstract double cost();

}
