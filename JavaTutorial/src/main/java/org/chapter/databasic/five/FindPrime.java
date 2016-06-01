package org.chapter.databasic.five;

/**
 * 素数测试[非完整算法。仅供基础学习使用]
 * 
 * @author Yujinshui
 *
 */
public class FindPrime {

	public static void main(String[] args) {
		int num;
		boolean isPrime;
		num = 14;
		if (num < 2)
			isPrime = false;
		else
			isPrime = true;
		for (int i = 2; i < num / i; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime)
			System.out.println("Prime");
		else
			System.out.println("Not prime");
	}

}
