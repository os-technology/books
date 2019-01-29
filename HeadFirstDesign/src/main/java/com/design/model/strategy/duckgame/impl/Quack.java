package com.design.model.strategy.duckgame.impl;

import com.design.model.strategy.duckgame.QuackBehavior;

/**
 * Quack叫声
 * 
 * @author Yujinshui
 *
 */
public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack. - Quack.class");

	}

}
