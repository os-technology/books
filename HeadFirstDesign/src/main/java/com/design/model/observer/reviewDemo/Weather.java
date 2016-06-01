package com.design.model.observer.reviewDemo;

import java.util.ArrayList;
import java.util.List;

public class Weather implements SubjectInter {
	private static List<ObserverInter> list;
	int a = 0;
	int b = 0;
	int c = 0;

	public Weather() {
		list = new ArrayList<ObserverInter>();
	}

	@Override
	public void register(ObserverInter o) {
		list.add(o);

	}

	@Override
	public void remove(ObserverInter o) {
		int i = list.indexOf(o);
		if (i > 0) {
			list.remove(i);
		}

	}

	@Override
	public void notifyData() {
		for (ObserverInter inter : list) {
			inter.update(a, b, c);
		}
	}

	public void setValue(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		notifyData();
	}

}
