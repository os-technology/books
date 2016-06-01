package com.design.model.duckgame.impl;

import com.design.model.duckgame.FlyBehavior;

/**
 * 翅膀飞行
 * 
 * @author Yujinshui
 *
 */
public class FlyWithWings implements FlyBehavior {
	/**
	 * 
	 * @see com.design.model.duckgame.FlyBehavior#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I'm flying!! - FlyWithWings.class");
	}

}
