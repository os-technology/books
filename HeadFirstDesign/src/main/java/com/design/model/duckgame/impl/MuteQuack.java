package com.design.model.duckgame.impl;

import com.design.model.duckgame.QuackBehavior;

/**
 * MuteQuack叫声
 * 
 * @author Yujinshui
 *
 */
public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("MuteQuack - MuteQuack.class");

	}

}
