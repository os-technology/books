package com.design.model.builder.demo2;

public class KFCFood {
	private String hamburger;
	private String beef;
	private String vegetable;
	private String salad;
	private int cost;

	public static class Flavour implements KFC<KFCFood> {// 调料
		private String hamburger;
		private String beef;
		private String vegetable;
		private String salad;
		private int cost;

		public Flavour setHamburger(String hamburger) {
			this.hamburger = hamburger;
			return this;
		}

		public Flavour setBeef(String beef) {
			this.beef = beef;
			return this;
		}

		public Flavour setVegetable(String vegetable) {
			this.vegetable = vegetable;
			return this;
		}

		public Flavour setSalad(String salad) {
			this.salad = salad;
			return this;
		}

		public Flavour setCost(int cost) {
			this.cost = cost;
			return this;
		}

		@Override
		public KFCFood build() {

			return new KFCFood(this);
		}
	}

	public KFCFood(Flavour flavour) {
		this.hamburger = flavour.hamburger;
		this.beef = flavour.beef;
		this.vegetable = flavour.vegetable;
		this.salad = flavour.salad;
		this.cost = flavour.cost;
	}

	@Override
	public String toString() {
		return ("hamburger:" + hamburger + "，beef:" + beef
				+ "，vegetable:" + vegetable + "，salad:" + salad
				+ "，cost:" + cost);
	}

}
