package com.design.model.duckgame;

import com.design.model.duckgame.impl.FlyRocketPowered;
import com.design.model.duckgame.impl.MallardDuck;

public class DuckTest{

	public void test(){
		
	}
	public static void main(String[] args) {
		Duck mallard =new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		mallard.setFlyBehavior(new FlyRocketPowered());
		mallard.performFly();
		
	}

}
