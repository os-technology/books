package com.design.model.decorator.test;

public class DarkRoastSon extends BeverageOrg {
	String descrption;

	public DarkRoastSon() {
		descrption = "This is DarkRoastSon.";
	}

	public double cost() {
		return super.cost() + 1;
	}
public static void main(String[] args) {
	System.out.println(new DarkRoastSon().cost());
}
}
