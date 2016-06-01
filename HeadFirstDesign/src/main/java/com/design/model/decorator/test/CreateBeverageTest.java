package com.design.model.decorator.test;

public class CreateBeverageTest {
	
	public void createDarkRoast(){
		DarkRoastSon ds = new DarkRoastSon();
		Mo m = new Mo(ds);
		Mo m1 = new Mo(ds);
		System.out.println(ds.descrption+"  "+m1.cost());
	}

	public static void main(String[] args) {
		CreateBeverageTest bt = new CreateBeverageTest();
		bt.createDarkRoast();

	}

}
