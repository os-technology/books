package org.number;

import java.math.BigDecimal;

/**
 * test
 */
public class Num {

	public static void main(String[] args) {
		int value =new BigDecimal(1).add(new BigDecimal(2)).multiply(new BigDecimal(5)).intValue();
		System.out.println(value);

	}

}
