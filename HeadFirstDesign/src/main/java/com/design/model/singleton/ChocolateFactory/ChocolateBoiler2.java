package com.design.model.singleton.ChocolateFactory;

public class ChocolateBoiler2 {
	private boolean empty;
	private boolean boiled;

	ChocolateBoiler2() {
		empty = true;
		boiled = false;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = true;
			// 填充混合物
		}
	}

	private boolean isEmpty() {
		return empty;
	}

}
