package com.design.model.strategy.duckgame.impl;

import com.design.model.strategy.duckgame.FlyBehavior;

/**
 * 火箭鸭飞行方式
 * 
 * @author Yujinshui
 *
 */
public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I am flying with a rocket. - FlyRocketPowered.class");

	}

}
