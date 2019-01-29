package com.design.model.strategy.duckgame.impl;

import com.design.model.strategy.duckgame.FlyBehavior;

/**
 * 翅膀飞行
 * 
 * @author Yujinshui
 *
 */
public class FlyWithWings implements FlyBehavior {
	/**
	 * 
	 * @see com.design.model.strategy.duckgame.FlyBehavior#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I'm flying!! - FlyWithWings.class");
	}

}
