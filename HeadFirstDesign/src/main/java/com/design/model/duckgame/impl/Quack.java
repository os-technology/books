package com.design.model.duckgame.impl;

import com.design.model.duckgame.QuackBehavior;

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
