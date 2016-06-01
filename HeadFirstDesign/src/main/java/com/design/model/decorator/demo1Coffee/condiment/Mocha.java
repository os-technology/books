package com.design.model.decorator.demo1Coffee.condiment;

import com.design.model.decorator.demo1Coffee.Beverage;

/**
 * 摩卡是一个装饰者，所以扩展自CondimentDecorator<br>
 * 而CondimentDecorator扩展自Beverage
 * 
 * @author shui
 *
 */
public class Mocha extends CondimentDecorator {

	/**
	 * 要让Mocha能够引用一个Beverage，需要：<br>
	 * 1.用一个实例变量记录饮料，也就是被装饰者<br>
	 * 2.想办法让被装饰者(饮料)被记录到实例变量中，这里的做法是：<br>
	 * 把饮料当做构造器的参数，再由构造器将此饮料记录在实例变量中。
	 */
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	/**
	 * 我们希望叙述表注释描述饮料，而是完整的连调料都描述出来（"DarkRoast，Mocha"）,<br>
	 * 所以首先利用委托的做法，得到一个叙述，然后在其后加上附加的叙述（例如Mocha）
	 */
	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
