package org.chapter.test.type;

public enum EnumType {
	SUCCESS("success", 1), FAILURE("failure", 0);
	private String s;
	private Integer i;

	EnumType(String s, int i) {
		this.s = s;
		this.i = i;
	}

	public String getString() {
		return s;
	}

	public Integer getIndex() {
		return i;
	}
}
