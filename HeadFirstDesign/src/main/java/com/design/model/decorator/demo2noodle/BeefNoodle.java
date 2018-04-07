package com.design.model.decorator.demo2noodle;

/**
 * 牛肉面
 * 
 * @author Yujinshui
 *
 */
public class BeefNoodle extends Noodle {
	public BeefNoodle() {
		name = "BeefNoodle ";
	}

	@Override
	public double cost() {

		return 2;
	}

}
