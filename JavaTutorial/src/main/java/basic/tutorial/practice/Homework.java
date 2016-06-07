package basic.tutorial.practice;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 课后习题练习
 * 
 * @author admin
 * 
 */
public class Homework {

	private void showWeek(int i) {
		// char[] weekNum = { 0, 1, 2, 3, 4, 5, 6 };
		String[] weekName = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
		if (i >= 0 && i < 7)
			System.out.println(weekName[i]);
		else
			System.out.println("请在0~6之间进行选择");
	}

	private void showWeek2() {
		Date date = new Date();
		int i = Calendar.DAY_OF_WEEK;
		int test = Calendar.SUNDAY;
		System.out.println(test);

	}

	/**
	 * 设s=1*2*3*4*5*……*n，求s不大于400000时最大的n。
	 * 
	 * @param n
	 */
	private void getN(int n) {
		int s = 1;
		int temp = 0;
		for (int i = 1; i <= n; i++) {
			s *= i;
		}
		if (s <= 400000)
			temp = s;
		else
			System.out.println("所求结果为：" + temp);
	}

	/**
	 * 找出1~1000之间的全部“同构数”。 注：如果一个数出现在其平方数的右端，则称此数为同构数。如：1在1*1=1的右端，5
	 * 在5*5=25的右端，25在25*25的右端等等。
	 */
	private void getResponseNum() {
		double temp = 0;// 同构数结果
		Long l1 = System.currentTimeMillis();
		for (int i = 1; i <= 100000000; i++) {
			temp = Math.pow(i, 2);
			// matchNum(temp, i);
			matchNum2(temp, i);
		}
		Long l2 = System.currentTimeMillis();
		System.out.println(l2 - l1);
	}

	/**
	 * 方案一：lastIndexOf定位位置为k,将temp结果长度从k开始截取，将截取结果进行对比 <br/>
	 * 142305 方案二：原始数字求出长度k后，将结果数字从后面截取k长度进行对比。136543
	 * 
	 * @param res
	 * @param i
	 */
	private void matchNum(double res, int i) {
		// 方案一：
		String primary = String.valueOf(i);
		String result1 = String.valueOf(res).toUpperCase();
		// double转换为字符串之后存在(.0),需要将其去掉，只保留整数部分,同时还要考虑含有E的时候（8.7909376E7）
		String result = "";
		if (!result1.contains("E")) {
			result = result1.substring(0, result1.length() - 2);
		} else {
			result = result1.substring(0, result1.indexOf("E"));
		}
		String temp = "";
		int index = 0;
		// 若为-1，则表示不存在，无需继续执行
		index = result.lastIndexOf(primary);
		if (index != -1) {
			temp = result.substring(index);
			if (temp.equals(primary)) {
				System.out.println(i + "-" + res + "   ");
			}
		}
	}

	private void matchNum2(double res, int i) {
		// 方案二：
		String primary = String.valueOf(i);
		String result1 = String.valueOf(res).toUpperCase();
		String result = "";
		// double转换为字符串之后存在(.0),需要将其去掉，只保留整数部分
		if (!result1.contains("E"))
			result = result1.substring(0, result1.length() - 2);
		else
			result = result1.substring(0, result1.indexOf("E"));
		String temp = "";
		int m = 0;
		m = result.length() - primary.length();
		if (m > 0)
			temp = result.substring(m, result.length());
		if (temp.equals(primary)) {
			System.out.println(i + "-" + res + "   ");
		}

	}

	private void outputPic() {
		StringBuffer buf = new StringBuffer();
		;
		for (int i = 1; i < 5; i++) {
			buf.append(addPic(i));
		}

		buf.append(buf);
		System.out.println(buf);
	}

	private StringBuffer addPic(int i) {
		StringBuffer buf = new StringBuffer();
		for (int k = 1; k <= i; k++) {
			buf.append("*");
		}
		buf.append("\r\n");
		return buf;
	}

	/**
	 * replaceAll("")用法
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/***************************/
	private void showNumber() {
		for (int i = 1; i < 5; i++) {
			orderNum(i);
		}
	}

	private void orderNum(int i) {
		if (i == 1)
			System.out.println(i);
		else {
			for (int m = 1; m <= i; m++) {
				System.out.print(m + " ");
			}
			for (int n = i - 1; n > 0; n--) {
				System.out.print(n + " ");
			}
			System.out.println();
		}

	}

	/***************************/

	private void showNumber2() {

		for (int i = 1; i < 5; i++) {
			orderNum2(i);
		}
	}

	private void orderNum2(int i) {
		StringBuffer buffer = new StringBuffer();
		if (i == 1)
			System.out.println(i);
		else {
			for (int m = 1; m <= i; m++) {
				buffer.append(m);
			}

			String bu = buffer.reverse().substring(1);
			buffer.reverse();
			buffer.append(bu);
			buffer.append("\r\n");
			System.out.println(buffer);
		}

	}

	private void absNum(int k) {
		int m = k < 0 ? -k : k;
		System.out.println(m);
	}

	public static void main(String[] args) {
		Homework hw = new Homework();
		// hw.showWeek(0);
		// hw.showWeek2();
		// hw.getN(9);
		// hw.getResponseNum();
		// hw.outputPic();
		// System.out.println(hw.replaceBlank("just do it!"));
		// hw.showNumber2();
		hw.absNum(+321);

	}

}
