package com.view.two;

import java.util.ArrayList;
import java.util.List;

public class PrimeNum {
	static List<Integer> tmp = new ArrayList<Integer>();

	public void info(int n) {
		for (int i = 2; i <= n; i++) {
			int res = num(i);
			if (res != 0) {
				tmp.add(res);
			}
		}

	}

	private int num(int i) {
		int a = 0;
		if (i == 2) {
			return i;
		} else {
			for (int j = 0; j < tmp.size(); j++) {
				int t = tmp.get(j);
					if (i % t != 0) {
						a = i;
						continue;
					} else {
						a = 0;
						break;
					}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		PrimeNum pn = new PrimeNum();
		pn.info(100);
		for (int i = 0; i < tmp.size(); i++) {
			System.out.print(tmp.get(i)+"  ");
		}

	}

}
