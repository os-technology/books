package com.design.model.observer.review;

import java.util.ArrayList;
import java.util.List;

public class SubImp implements Sub {
	private static List<ObInter> list = null;
	private int a;

	public SubImp() {
		list = new ArrayList<ObInter>();
	}

	@Override
	public void register(ObInter inter) {
		list.add(inter);
	}

	@Override
	public void notifyData() {
		for (ObInter o : list) {
			o.update(a);
		}

	}

	@Override
	public void remove(ObInter in) {
		int i = list.indexOf(in);
		if (i > 0)
			list.remove(i);

	}

	public void setValue(int value) {
		a = value;
		notifyData();
	}

}
