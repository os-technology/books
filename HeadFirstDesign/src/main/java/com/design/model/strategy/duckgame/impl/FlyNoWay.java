package com.design.model.strategy.duckgame.impl;

import com.design.model.strategy.duckgame.FlyBehavior;

/**
 * 无法飞行
 * 
 * @author Yujinshui
 *
 */
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly. - FlyNoWay.class");
	}

}
