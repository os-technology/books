package com.design.decorator;

import com.design.model.decorator.demo1Coffee.Beverage;
import com.design.model.decorator.demo1Coffee.cof.Espresso;
import com.design.model.decorator.demo1Coffee.cof.HouseBlend;
import com.design.model.decorator.demo1Coffee.condiment.Milk;
import com.design.model.decorator.demo1Coffee.condiment.Mocha;
import com.design.model.decorator.demo1Coffee.condiment.Soy;

/**
 * 供应咖啡类
 * 
 * @author shui
 *
 */
public class StarbuzzCoffee {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $ " + beverage.cost());

		Beverage beverage2 = new HouseBlend();// 制作一个综合咖啡对象
		beverage2 = new Mocha(beverage2);// 第一杯摩卡调料
		beverage2 = new Mocha(beverage2);// 第二杯摩卡调料
		beverage2 = new Milk(beverage2);// 牛奶调料
		beverage2 =new Soy(beverage2);//豆浆调料
		
		System.out.println(beverage2.getDescription()+" $ "+beverage2.cost());
		
	}

}
