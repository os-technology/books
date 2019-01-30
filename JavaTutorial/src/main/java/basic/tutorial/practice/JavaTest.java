package basic.tutorial.practice;

import java.awt.*;

import static java.lang.Math.random;

public class JavaTest {

	public void chapter2() {
		// 标识符命名规则
		// 尽量少用带$符号的标识符，主要是习惯问题，还有内部类中，$具有特殊的含义
		int $2 = 3;
		String _1 = "标识符命名规则";
		float a_12 = 12.2f;
		String m = "m";
		String M = "M";
		// 不推荐。使用16-bit 双字节字符编码标准（Unicode 字符集），最多可以
		// 识别65535个字符。。虽然中文标识符也能够正常编译和运行，
		// 却不建议使用。
		String 水 = "yujinshui";
	}

	private void charToNumber() {
		char ch = '1';// 'a',48
		System.out.println((int) ch);
		char ar = 20320;// 你
		System.out.println(ar);
	}

	/**
	 * 汉字起始结束位置：19968-40870
	 */
	private void unicodeAll() {
		int num = 0;
		for (int i = 19968; i < 40870; i++) {
			if (i % 50 == 0)
				System.out.println();
			System.out.print((char) i);
			// String s = String.valueOf((char) i);

			// if (s.equals("一")) {
			//
			// num=i;
			//
			// }
			// if (s.equals("龥")) {
			// System.out.println("汉字结束:"+i);
			// System.out.println(num);
			// System.out.println(i-num);
			// break;
			// }
		}

	}

	private void getFloatValue() {
		float fmax = Float.MAX_VALUE;
		System.out.println(fmax);
		float fmin = Float.MIN_VALUE;
		System.out.println(fmin);
		double dmax = Double.MAX_VALUE;
		System.out.println(dmax);
		double dmin = Double.MIN_VALUE;
		System.out.println(dmin);
	}

	/**
	 * @see："参见"，用于指定参考的内容
	 * @see 标签允许用户引用其他类的文档。
	 * @see classname
	 * @see fully-qualified-classname
	 * @see fully-qualified-classname#method-name
	 * @see basic.tutorial.practice.RandomClass#seeTest()
	 * 
	 */
	private void seeTest() {
		System.out.println("@see测试");
	}

	private void basicNum() {

	}

	private void sysAB() {
		int a = 10;
		int b = 10;
		int c = a++ + b;
		System.out.println("a=" + a + ",b=" + b + ",sum=" + c);
		a = b = 10;
		int d = a + ++b;
		System.out.println("a=" + a + ",b=" + b + ",sum=" + d);
	}

	/**
	 * 位与运算符
	 */
	private void A_or_B() {
		int a = 1;
		int b = 0;
		int c = 2;
		int d = 0;
		System.out.println("a&b =" + (a & b));
		System.out.println("a|b =" + (a | b));
		System.out.println("a^b =" + (a ^ b));
		System.out.println("a&c =" + (a & c));
		System.out.println("a|c =" + (a | c));
		System.out.println("a^c =" + (a ^ c));
		System.out.println("b^d =" + (b ^ d));

	}

	/**
	 * switch学习
	 * 
	 * @param ch
	 */
	private void switchTest(char ch) {
		switch (ch) {
		case 0:
			System.out.println("0 case started.");
			break;
		case 1:
			System.out.println("1  case started.");
			break;
		case '2':
			System.out.println("2 case started.");
			break;
		default:
			System.out.println("无此标记，默认输出启动。");
		}

	}

	/**
	 * 颜色输出测试
	 */
	private void colorTest() {
		int colorNum = 1;
		switch (colorNum) {
		case 0:
			System.out.println(Color.red);
			break;
		case 1:
			System.out.println(Color.green);
			break;
		default:
			System.out.println(Color.black);
			break;
		}
	}

	/**
	 * label学习测试
	 */
	private void labelTest() {

		// System.out.println("labelTest1:");
		// labelTest1();
		//
		// System.out.println("labelTest2:");
		// labelTest2();
		System.out.println("labelTest3:");
		labelTest3();
	}

	private void labelTest1() {
		for (int i = 0; i < 5; i++) {
			L: if (i == 3) {
				break L;
			}
			System.out.println("i==" + i);
		}
	}

	private void labelTest2() {
		String o = "";
		z: for (int x = 3; x < 8; x++) {

			if (x == 6)
				break z;
			o = o + x;
		}
		System.out.println(o);
	}

	/**
	 * label:跳出指定循环
	 */
	private void labelTest3() {

		String o = "";
		z: for (int i = 0; i < 5; i++) {
			for (int x = 3; x < 8; x++) {
				if (x == 6)
					break z;
				o = o + x;
			}
		}
		System.out.println(o);
	}

	private void intTest() {
		int x, y, a = 2;
		x = a++;
		y = ++a;
		System.out.println(x + " " + y);
	}

	private void define() {
		// byte b = 128;
		// char c = 65536;
		long len = 0xfffL;
		double dd = 0.9239d;

		// compile fault
		// float f=2039.0;
		double d = 2039.0;
		// byte b=2039;
		char c = 2039;

	}

	private void aTob() {
		int a = 5, b = 6;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a=" + a + ",b=" + b);
	}

	// 双等号之间不可有空格
	private void bool() {
		boolean b = true;
		boolean b2 = true;
		// if (b = = b2) {
		// System.out.println("So true");
		// }
	}

	private void test() {
		boolean a = false;
		boolean b = true;
		boolean c = (a && b) && (!b);
		int result = c == false ? 1 : 2;
		System.out.println(result);
	}

	private void num() {
		for (int i = 1; i <= 1000; i++) {
			// System.out.print(i+",");
			if (i % 2 == 1)
				System.out.println(i + ",");

		}
	}

	private void threeOrFive() {
		int i = 15;
		if (i % 3 == 0 && i % 5 == 0) {
			System.out.println(i + "能被3和5整除");
		} else {
			System.out.println(i + "不能被这个两个数整除");
		}
	}

	private void arrayTest(String[] s) {
		System.out.println(s.length);
		for (String cs : s) {
			System.out.println(cs);
		}
	}

	private void arrayTest2(String... info) {
		System.out.println(info.length);
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i]);
		}
	}

	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "Come on,shui!!";
	}

	// 块（block）
	// 一个块是以{}作为边界的语句的集合，块可以嵌套。
	{
		int i = 9;
		System.out.println(i);
	}

	/**
	 * 
	 */
	private void intTest1() {
		int k = 200;
		Integer i = new Integer(k);
		int m = i.intValue();
		String s = i.toString();
		Integer t = new Integer(200);
		System.out.println("字符串和整数比较结果：" + s.equals(k));
		System.out.println("字符串和Integer对象比较结果：" + s.equals(i));
		System.out.println("Integer对象i和Integer对象t比较结果：" + i.equals(t));
	}

	private void numType() {
		double f = 12.414;
		float k = 1.2f;
		// float t = 1.2;//默认是double类型
	}

	/**
	 * 求解素数
	 */
	private void number() {
		int n = 23;
		int j = 1;
		for (int i = 2; i < n; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0)
					break;
			}
			if (j >= i) {
				System.out.println(i);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaTest jt = new JavaTest();
		// jt.getFloatValue();
		// jt.sysAB();
		// jt.A_or_B();
		// jt.switchTest('2');
		// jt.colorTest();
		// jt.labelTest();
		// jt.intTest();
		// jt.aTob();
		// jt.test();
		// jt.num();
		// jt.threeOrFive();
		String[] r = { "a", "b", "c", "d", "e" };
		// jt.arrayTest(r);// right!!
		// jt.arrayTest({"a","b","c","d","e"});//wrong!!
		// jt.arrayTest(new String[]{"a","b","c","d","e"});//right!!

		//
		// jt.arrayTest2(r);// right!!
		// jt.arrayTest2("1", "2", "3", "4", "5");
		// System.out.println(jt);// 重写toString()方法得到的结果
		// jt.intTest1();

		// 静态import
		// import static java.lang.Math.random;
		double ran = random();
		System.out.println(ran);
	}

}
