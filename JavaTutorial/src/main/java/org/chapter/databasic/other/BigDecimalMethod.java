package org.chapter.databasic.other;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数值处理类
 * 
 * @author Yujinshui
 *
 */
public class BigDecimalMethod {

	public void bigDecimal() {
		BigDecimal double001 = new BigDecimal(0.01); // 0.01000000000000000020816681711721685132943093776702880859375
		BigDecimal str001 = new BigDecimal("0.01");// 0.01
		System.out.println(double001);
		System.out.println(str001);
		BigDecimal six = new BigDecimal(6);
		BigDecimal d09 = new BigDecimal("0.9");
		BigDecimal result = six.multiply(d09).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal scale0Result = result.setScale(0, RoundingMode.HALF_EVEN);
		System.out.println(result);
		System.out.println(scale0Result);
	}

	public static void main(String[] args) {
		BigDecimalMethod bm = new BigDecimalMethod();
		bm.bigDecimal();
	}

}
