package com.design.model.duckgame;

/**
 * 鸭子抽象类
 * 
 * @author Yujinshui
 *
 */
public abstract class Duck {

	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	public Duck() {

	}

	public abstract void display();

	/**
	 * 动态设定飞行行为
	 * 
	 * @param fb
	 * @author Yujinshui
	 * @time 2015年10月28日 上午7:42:18
	 */
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	/**
	 * 动态设定叫声行为
	 * 
	 * @param qb
	 * @author Yujinshui
	 * @time 2015年10月28日 上午7:42:03
	 */
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

	/**
	 * 默认飞行
	 * 
	 * @author Yujinshui
	 * @time 2015年10月28日 上午7:16:10
	 */
	public void performFly() {
		flyBehavior.fly();
	}

	/**
	 * 默认叫声
	 * 
	 * @author Yujinshui
	 * @time 2015年10月28日 上午7:15:56
	 */
	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float,even decoys!");
	}

}
