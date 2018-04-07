package basic.tutorial.practice;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 作业三
 * 
 * @author Yu Jinshui
 * 
 */
public class Homework3 {

	/**
	 * 2.编写程序，测试计算1～50的阶乘的和所耗费的毫秒级时间。
	 */
	public void calculator() {
		double res = 1;
		Long l = System.currentTimeMillis();
		for (int i = 1; i <= 50; i++) {
			System.out.println(res);
			res = res * i;
		}
		Long o = System.currentTimeMillis();
		System.out.println(res + "___" + (o - l));
	}

	/**
	 * 3. 编写程序，将字符串“打印机*钟表//自行车**雨伞%%收音机??电脑”进行拆分，输出每 个设备的名字。<br/>
	 * a、所有汉字均为负数，符号为正数，以此进行判断划分
	 * <p>
	 * b、正则表达式进行区分
	 */
	public void stringSplit() {
		String str = "打印机*钟表//自行车**雨伞%%收音机??电脑";

		// ///////////////////
		// char ch[] = str.toCharArray();
		// // String[] info = new String[ch.length];
		// // int k=0;
		// for (int i = 0; i < ch.length; i++) {
		// if (ch[i] > 0xff || ch[i] < 0) {
		// // info[k]=String.valueOf(ch[i]);
		// // k++;
		// System.out.print(ch[i]);
		// } else {
		// System.out.print("-");
		// continue;
		// }
		// // System.out.println(Integer.toHexString(ch[i]));
		// }
		// ////////////////

		// "打印机*钟表//自行车**雨伞%%收音机??电脑"
		String regex = "\\*+|/+|%+|\\?+";
		String[] in = str.split(regex);
		for (String i : in) {
			System.out.println(i);
		}
	}

	/**
	 * 4. 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前 20 项之 和。<br/>
	 * (不使用数学公式，要求用递归)
	 */
	public void getResult(int k) {
		class Cal {

			public void dealMath(int k) {
				double sum = 0;
				for (int i = 1; i <= k; i++) {
					sum += (getFibonacci(i + 1) / getFibonacci(i));
				}
				System.out.println(k + "个数相加结果：" + sum);
			}

			public double getFibonacci(int n) {
				if (n == 1 || n == 2) {
					return n;
				} else {
					return getFibonacci(n - 1) + getFibonacci(n - 2);
				}
			}

		}
		Cal c = new Cal();
		c.dealMath(k);

	}

	/**
	 * 6. 已知两个对像 String s1,String s2,已用 ASC 码排序好了，编写程序将两个
	 * String合并，得到的结果。例如：s1="abc" s2="abc" 得 s="aabbcc";结果也是 排序的
	 * 
	 * @param a
	 * @param b
	 */
	public void stringRes(String a, String b) {

		char[] c = (a + b).toCharArray();
		Arrays.sort(c);
		System.out.println(String.valueOf(c));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Homework3 h = new Homework3();
		// h.calculator();
		// h.stringSplit();
		// h.getResult(2);

		String a = "1gf2";
		String b = "21gt";
		h.stringRes(a, b);

	}

}
