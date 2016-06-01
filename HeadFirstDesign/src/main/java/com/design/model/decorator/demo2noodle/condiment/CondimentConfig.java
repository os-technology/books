package com.design.model.decorator.demo2noodle.condiment;

import com.design.model.decorator.demo2noodle.Noodle;

/**
 * 装饰者接口
 * 
 * @author Yujinshui
 *
 */
public abstract class CondimentConfig extends Noodle {

	@Override
	public double cost() {
		return 0;
	}

	public abstract String getName();
}
