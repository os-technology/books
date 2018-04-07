package com.design.model.builder.demo3;

public class TakeBook {

	private String chinese;
	private String math;
	private String english;
	private String history;
	private String physics;

	public TakeBook(Bookbag bookbag) {
		this.chinese = bookbag.chinese;
		this.math = bookbag.math;
		this.english = bookbag.english;
		this.history = bookbag.history;
		this.physics = bookbag.physics;
	}

	public static class Bookbag implements Book<TakeBook> {

		private String chinese;
		private String math;
		private String english;
		private String history;
		private String physics;

		public Bookbag setChinese(String chinese) {
			this.chinese = chinese;
			return this;
		}

		public Bookbag setMath(String math) {
			this.math = math;
			return this;
		}

		public Bookbag setEnglish(String english) {
			this.english = english;
			return this;
		}

		public Bookbag setHistory(String history) {
			this.history = history;
			return this;
		}

		public Bookbag setPhysics(String physics) {
			this.physics = physics;
			return this;
		}

		@Override
		public TakeBook build() {
			return new TakeBook(this);
		}

	}

	@Override
	public String toString() {
		return (" chinese:" + chinese + " math:" + math + " english:" + english
				+ " history:" + history + " physics:" + physics);

	}

}
