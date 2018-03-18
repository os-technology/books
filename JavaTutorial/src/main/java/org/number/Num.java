package org.number;

import java.math.BigDecimal;

/**
 * test
 */
public class Num {

	private void cal(){
		double a=1;
		boolean flag = true;
		for(int i=3;i<100000000L;i+=2){
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

	public static void main(String[] args) {
		String value = "你好";
		System.out.println(value.length());
	}

}
