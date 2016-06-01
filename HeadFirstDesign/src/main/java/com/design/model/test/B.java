package com.design.model.test;

import java.util.ArrayList;
import java.util.List;

public class B extends A {
public static void main(String[] args) {
	List<A> list = new ArrayList<A>();
	list.add(new B());
}
}
