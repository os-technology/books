package basic.tutorial.practice;

import java.util.Arrays;

public class Order {
	/**
	 * 给定两个字符串 仅由小写字母组成 它们包含了相同字符<br/>
	 * 求把第一个字符串变成第二个字符串的最小操作次数 <br/>
	 * 且每次操作只能对第一个字符串中的某个字符移动到此字符串中的开头 <br/>
	 * 例如给定两个字符串“abcd" "bcad" <br/>
	 * 输出：2<br/>
	 * 因为需要操作2次才能把"abcd"变成“bcad" <br/>
	 * 方法是：abcd->cabd->bcad。
	 * 
	 * 
	 * 
	 * 示例：2143-->1234（特殊情况），2143-->2134，3214-->1234 <br/>
	 * 方法： 1、现将两个字符串变成数组 <br/>
	 * 2、以结果数组为标准编号(数组形式显示)，将原始数组进行排序即可。<br/>
	 * <p>
	 * 2-1、2143-->1234（特殊情况）按照2143-->2134进行处理，<br/>
	 * 但是首先需要按照3214-->1234的逻辑进行排序，之后初始化排序次数，执行2143-->2134排序方式<br/>
	 * </p>
	 * 3、每次排序结果都是将比第一个小1的数值排到第一位即可。<br/>
	 */
	/**
	 * @
	 * 
	 * @param old
	 *            原始字符串
	 * @param now
	 *            排序结果
	 */

	String[] n = null;
	String[] o = null;
	int[] rightNumber = null;// 用于数组比较
	int[] temp = null;// 临时变量，转换使用
	int count = 0;// 排序次数
	int[] oldNum = null;// 原始序号

	private int check(String old, String now) {

		n = new String[now.length()];
		o = new String[old.length()];
		// 临时变量，转换使用
		temp = new int[now.length()];
		for (int i = 0; i < now.length(); i++) {
			n[i] = now.substring(i, i + 1);
			o[i] = old.substring(i, i + 1);
		}

		// 得到排序后结果顺序
		for (int i = 0; i < now.length(); i++) {
			temp[i] = resort(o[i], n);
		}
		// 保证引用地址不同
		rightNumber = new int[temp.length];
		oldNum = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			rightNumber[i] = temp[i];
			oldNum[i] = temp[i];
		}
		Arrays.sort(rightNumber);

		if (Arrays.equals(rightNumber, temp))// result(rightNumber, temp);
			return 0;
		else
			return count(temp, rightNumber);

	}

	/**
	 * 老数组序号对应排序后的正确序号
	 * 
	 * @param o
	 * @param n
	 * @return
	 */
	private int resort(String o, String[] n) {
		int num = 0;
		flag: for (int i = 0; i < n.length; i++) {
			if (o.equals(n[i])) {
				num = i;
				break flag;
			}
		}
		return num;
	}

	/**
	 * 记录排序次数<br/>
	 * 该部分参考插入排序方法进行修改
	 * 
	 * @param num
	 * @return
	 */

	private int count(int[] num, int[] rightNumber) {

		int temp = 0;
		int temp2 = 0;
		int max = num[0];// 定义初始值
		if (rightNumber[0] != num[0]) {
			for (int i = 0; i < num.length; i++) {
				// 首位排序前后不同
				if ((num[0] - num[i]) == 1) {
					temp = num[i];// 将符合条件数值排序至首位
					// System.out.println("temp/num[" + i + "]=" + temp);
					// 将数组值向后移一位
					for (int j = i; j - 1 >= 0; j--) {
						num[j] = num[j - 1];
						// System.out.println("num[" + j + "]=" + num[j]);
					}
				}
			}
		}
		// 首位排序前后相同，先定位最大值，然后按正常逻辑继续即可。
		else {
			order1(num, max);
		}
		num[0] = temp;// 将符合条件数值排序至首位
		// System.out.println("num[0]=" + num[0]);
		// for (int i = 0; i < num.length; i++) {
		// System.out.println(num[i] + "-----" + numTemp[i]);
		// }
		count++;
		// 每次排序后将排序结果打印
		printResult(count, num);

		// 符合排序结果，进行输出
		if (Arrays.equals(rightNumber, num)) {// result(rightNumber, num)

			return count;
		} else
		// 否则，继续循环
		if (rightNumber[0] == num[0]) {
			count = 0;
			System.out.println("首位已经排序完成，但是仍不符合要求，启用顺次重排");
		}
		return count(num, rightNumber);
	}

	/**
	 * 首位排序前后相同，先定位最大值，然后按正常逻辑继续即可。
	 * 
	 * @param num
	 * @param max
	 */
	private int order1(int[] num, int max) {
		int k = 0;
		for (int i = 0; i < num.length; i++) {
			if (max < num[i]) {
				max = num[i];
				k = i;
			}
		}
		// 将数组值向后移一位
		for (int j = k; j - 1 >= 0; j--) {
			num[j] = num[j - 1];
			// System.out.println("num[" + j + "]=" + num[j]);
		}
		num[0] = max;
		return count(num, rightNumber);

	}

	/**
	 * 排序结果处理
	 * 
	 * @param numTemp
	 *            结果值
	 * @param num
	 *            原始值
	 * @return
	 */
	private boolean result(int[] numTemp, int[] num) {
		boolean flag = false;
		start: for (int i = 0; i < num.length; i++) {

			if (numTemp[i] == num[i])
				flag = true;
			else {
				flag = false;
				break start;
			}
		}
		flag = Arrays.equals(numTemp, num);
		return flag;
	}

	private void printResult(int count, int[] num) {
		System.out.println("第" + count + "次排序结果：");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < rightNumber.length; i++) {
			builder.append(o[i] + "-" + oldNum[i] + " ");
		}
		builder.append("\r\n");
		for (int i = 0; i < num.length; i++) {
			builder.append(n[num[i]] + "-" + num[i] + " ");
		}
		builder.append("\r\n\r\n");
		System.out.println(builder);

	}

	public static void main(String[] args) {
		Order o = new Order();
		String old = "字符串中的开头";// 字符串中的开头
		String now = "中头符开串的字";// 中头符开串的字
		int number = o.check(old, now);
		System.out.println(old + "——" + now);
		System.out.println("排序次数为：" + number);

	}

}
