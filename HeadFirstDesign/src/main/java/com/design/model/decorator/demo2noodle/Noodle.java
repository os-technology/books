package com.design.model.decorator.demo2noodle;

public abstract class Noodle {
	protected String name = "这是面条的底料";

	public String getName() {
		return name;
	}

	public abstract double cost();

}
