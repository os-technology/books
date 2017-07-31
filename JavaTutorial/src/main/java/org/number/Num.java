package org.number;

import java.math.BigDecimal;

/**
 * test
 */
public class Num {

	public static void main(String[] args) {
		double a=1;
		boolean flag = true;
		for(int i=3;i<100000000l;i+=2){
			if (flag) {
				a = a + (-1.0 / i);
				flag = false;
			}else {
				a=a+1.0/i;
				flag = true;
			}
		}
		System.out.println(a*4);
	}

}
