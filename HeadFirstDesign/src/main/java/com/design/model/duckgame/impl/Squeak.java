package com.design.model.duckgame.impl;

import com.design.model.duckgame.QuackBehavior;

/**
 * Squeak叫声
 * 
 * @author Yujinshui
 *
 */
public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Squeak. - Squeak.class");

	}

}
