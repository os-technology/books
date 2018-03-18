package org.chapter.test;

public class F2 extends F1{

	private String c;

	/**
	 * @return the c
	 */
	public String getC() {
		return c;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setC(String c) {
		this.c = c;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "F2 [c=" + c + "]";
	}
	
}
