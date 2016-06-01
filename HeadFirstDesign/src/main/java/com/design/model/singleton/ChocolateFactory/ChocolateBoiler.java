package com.design.model.singleton.ChocolateFactory;

/**
 * 巧克力工厂
 * 
 * @author Yujinshui
 *
 */
public class ChocolateBoiler {

	private boolean empty;
	private boolean boiled;

	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			// 填充巧克力和牛奶的混合物
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			// 排出煮沸的混合物
			empty = true;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			// 将混合物煮沸
			boiled = true;
		}
	}

	private boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

}
