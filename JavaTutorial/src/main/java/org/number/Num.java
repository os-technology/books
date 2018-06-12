package org.number;

import com.alibaba.fastjson.JSON;

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
//		String value = "你好";
//		System.out.println(value.length());

		int[] a = {1,5,3,8,4};
		int tmp = 0;
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
		}
		System.out.println(JSON.toJSONString(a));
	}

}
