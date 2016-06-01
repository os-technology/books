package com.design.model.decorator.test;

/**
 * 调料：摩卡
 * 
 * @author Yujinshui
 *
 */
public class Mo {
	BeverageOrg bev = null;

	public Mo(BeverageOrg bev) {
		this.bev = bev;
	}
	
	public double cost(){
		return 1+bev.cost();
	}

}
