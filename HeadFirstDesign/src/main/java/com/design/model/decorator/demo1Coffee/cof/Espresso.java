package com.design.model.decorator.demo1Coffee.cof;

import com.design.model.decorator.demo1Coffee.Beverage;


/**
 * 浓缩咖啡
 * <p>
 * 首先，让Espresso扩展自Beverage类，因此Espresso是一种饮料
 * 
 * @author shui
 *
 */
public class Espresso extends Beverage {

	/**
	 * 为了要设置饮料的描述，我们写了一个构造器，记住，description实例变量继承自Beverage
	 */
	public Espresso() {
		description = "Espresso浓缩咖啡 ";
	}

	/**
	 * 最后，需要计算Espresso的价钱，现在不需要管调料的价钱，直接把Espresso的价格返回即可。
	 */
	@Override
	public double cost() {
		return 1.99;
	}

}
