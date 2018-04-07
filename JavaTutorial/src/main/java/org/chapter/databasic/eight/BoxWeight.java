package org.chapter.databasic.eight;

public class BoxWeight extends Box {
	double weight;

	BoxWeight(int a) {
		System.out.println("BoxWeight:" + a);
	}

	BoxWeight(BoxWeight ob) {
		super(ob);
		weight = ob.weight;
	}

	BoxWeight(double w, double h, double d, double m) {
		super(w, h, d);
		weight = m;

	}

	BoxWeight() {
		weight = -1;
	}

	BoxWeight(double len, double m) {
		super(len);
		weight = m;
	}

}
