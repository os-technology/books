package com.design.model.duckgame.impl;

import com.design.model.duckgame.Duck;
import com.design.model.duckgame.QuackBehavior;

/**
 * MallardDuck 鸭子类型
 * 
 * @author Yujinshui
 *
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("I am a Mallard Duck. - MallardDuck.class");

	}
	public void ok(){
		System.out.println("ok method is finish.");
	}

}
