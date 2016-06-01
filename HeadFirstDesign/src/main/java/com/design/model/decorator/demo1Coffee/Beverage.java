package com.design.model.decorator.demo1Coffee;

/**
 * 饮料抽象类
 * <p>
 * 咖啡：<br>
 * 综合HouseBlend 	.89<br>
 * 深焙DarkRoast 		.99<br>
 * 低咖啡因Decaf 		1.05<br>
 * 浓缩Espresso		1.99<br>
 * 
 * @author shui
 *
 */
public abstract class Beverage {

	 protected String description = "Unknow Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();

}
