package org.chapter.databasic.seven;

/**
 * 整数的阶乘
 * 
 * @author Yujinshui
 *
 */
public class Factorial {
/**
 * 阶乘计算
 * @param n
 * @return
 * @author Yujinshui
 * @time 2016年2月2日 下午2:14:53
 */
	private int fact(int n) {
		if (n == 1)
			return 1;
		return fact(n - 1) * n;
	}

	public static void main(String[] args) {
		Factorial fact = new Factorial();
		System.out.println(fact.fact(6));

	}

}
