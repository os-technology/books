package basic.tutorial.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String的内存分配(开始)
 * 
 * @author admin
 * 
 */
public class JavaTest2 {

	/**
	 * String的内存分配
	 */
	public void stringTest1() {
		// 因此用第一种方式创建多个"abc"字符串，在内存中其实只存在一个对象而已。这种写法有
		// 利于节省内存空间
		String s1 = "123";
		String s2 = "123";
		System.out.println(s1 == s2);
		/************/
	}

	@Override
	public String toString() {
		return "String :" + JavaTest2.class;
	}

	/************ 数组部分开始 **************/
	/**
	 * 数组实用类Arrays
	 */
	public void arrayTest() {
		List<Integer> list = Arrays.asList(3, 5, 12, 7, 8, 9);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		String[] arr = { "Java快车", "javakc", "JavaKC" };
		String[] arr2 = { "Java快车", "javak", "JavaKC" };
		System.out.print(Arrays.equals(arr, arr2));
	}

	public void fillTest() {

		class A {
			public A() {
				System.out.println("初始化内部类A完成");
			}
		}
		A[] arr = new A[6];
		Arrays.fill(arr, new A());

		// 指定范围填充内容
		// fill（数组,int fromIndex, int toIndex,数据参数）
		// ，此范围包含fromIndex，但不包含toIndex。数组和
		// 数据参数的类型必须一致，或可以自动转化，数组和元素可以是基本数据类型，也可以是引用数
		// 据类型。
		Arrays.fill(arr, 1, 4, new A());
		// for (A s : arr) {
		// System.out.println(s);
		// }
		// binarySearch 当调用该方法时，必须保证数组中的元素已经按
		// 照升序排列，这样才能得到正确的结果
		int[] arrs = { 2, 6, 0, 20, 4, 9, 7, 10 };
		// System.out.print(Arrays.binarySearch(arrs, 9));
		// 打印数组串
		System.out.println(Arrays.toString(arrs));
	}

	/************ 数组部分结束 **************/
	/******* 枚举类型开始 ********/
	public enum StudentGrade {
		A, B, C, D, E, F
	};

	public void enumTest(StudentGrade g) {
		// for (StudentGrade grade : StudentGrade.values()) {
		// System.out.println("输出结果为：" + grade);
		// }
		/***********/

		switch (g) {
		case A:
			System.out.println(g + "成绩优");
			break;
		case B:
			System.out.println(g + "成绩良");
			break;
		case C:
			System.out.println(g + "成绩一般");
			break;
		case D:
			System.out.println(g + "成绩不好");
			break;
		default:
			System.out.println(g + ":不包含该范围");
		}
	}

	/******* 枚举类型结束 ********/

	public boolean StringArray(String s) {
		String[] str = { "one", "two", "three", "four", "five", "six", "seven",
				"eight", "nine", "ten" };
		Arrays.sort(str);
		for (String ing : str) {
			System.out.println(ing);
		}
		if (Arrays.binarySearch(str, s) > 0) {
			return true;
		} else
			return false;

	}

	public void printArray() {
		int sum = 0;
		int[][] b = { { 11 }, { 21, 22 }, { 31, 32, 33 } };
		for (int[] c : b) {
			for (int d : c) {
				sum += d;
			}
		}
		System.out.println(sum);
	}

	/********** this的使用开始 ************/

	public void thisTest() {
		A a = new A();
		// a.id
	}

	class A {
		public A() {
			this(3);
		}

		public A(int a) {
			System.out.println(a);
		}

		String id = "hello";
	}

	/********** this的使用结束 ************/
	/********** ==和equals的使用开始 *****************/
	class E {
		public int id = 0;

		public boolean equals(Object obj) {
			// 第一步先判断是否同一个实例<br/>
			if (this == obj) {
				return true;
			} // 第二步判断要比较的对象是否为null<br/>
			if (obj == null) {
				return false;
			} // 第三步判断是否同一个类型<br/>
			if (obj instanceof E) {
				// 第四步类型相同，先转换成为同一个类型<br/>
				E e = (E) obj;
				// 第五步然后进行对象属性值的比较<br/>
				if (this.id == e.id)
					return true;
				else
					return false;
			} // 类型不同，直接返回false
			else
				return false;
		}

	}

	public void Etest() {
		E e1 = new E();
		e1.id = 3;
		E e2 = new E();
		e2.id = 3;
		System.out.println("e1==e2 result:" + (e1 == e2));
		System.out.println("e1 equals e2 result:" + e1.equals(e2));
		System.out.println(e1.hashCode() + "\n" + e2.hashCode());
	}

	/********** ==和equals的使用结束 *****************/

	/****** 小练习 ********/
	// 说明：有个字符串如下，需要写个方法当做参数，然后按照一定的规则拼接。
	// 此字符串上的每个数字都是4位数，不够的位数前面补0
	//
	// 23 比如拼接之后：0023#
	// 23#24 比如拼接之后：0023#0024#
	// 1001 比如拼接之后：1001#
	// 1001#23 比如拼接之后：1001#0023#
	// 23#24#25 比如拼接之后：0023#0024#0025
	// 1#23 比如拼接之后：0001#0023#
	/**
	 *
	 */
	public void subTest1(String content) {
		System.out.println("输入内容为：" + content);
		String res = "";

		String[] s = content.split("#");
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() < 4) {
				int temp = s[i].length();
				for (int j = 0; j < 4 - temp; j++) {
					s[i] = "0" + s[i];
				}
			}
			res += s[i] + "#";
		}

		System.out.println("输出结果为：" + res);
	}

	public void subTest2(String content) {
		System.out.println("输入内容为：" + content);
		String res = "";

		String[] s = content.split("#");
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() < 4) {
				while (s[i].length() < 4) {
					s[i] = "0" + s[i];
				}
			}
			res += s[i] + "#";
		}

		System.out.println("输出结果为：" + res);
	}

	// "23#24#25"
	public void subTest3(String s) {
		// $1表示匹配第一个子匹配的内容，即()里的匹配规则，由于只有()的内容，故改成$0也是正确的
		s = s.replaceAll("(\\d+)", "1000$1");
		// 前面无限个0无所谓，保证后面的数字为四位即可,即匹配()里的内容为标准，0为参考
		s = s.replaceAll("(\\d{4})", "$1");
		System.out.println(s);
	}

	/**************/

	/****** toString方法日期重写开始 ********/
	class MyDate {
		private int day, month, year;

		public MyDate(int d, int m, int y) {
			day = d;
			month = m;
			year = y;
		}

	}

	class YourDate {
		private int day, month, year;

		public YourDate(int d, int m, int y) {
			day = d;
			month = m;
			year = y;
		}

		public String toString() {
			return day + "-" + month + "-" + year;
		}

	}

	public void dateTest() {
		MyDate md = new MyDate(4, 4, 2014);
		System.out.println(md);
		System.out.println(md.toString());
		YourDate yd = new YourDate(6, 6, 2014);
		System.out.println(yd);
		System.out.println(yd.toString());

	}

	/****** toString方法日期重写结束 ********/
	/********* String方法的训练开始 ***********/
	public String stringTest() {
		char[] arr = { 'H', 'e', 'l', 'l', 'o' };
		String info = new String(arr);
		return info;
	}

	public String stringSub() {
		char[] arr = { 'H', 'e', 'l', 'l', 'o' };
		String info = new String(arr, 2, 3);
		return info;
	}

	public String intTest() {
		char[] in = { 1, 6, 3, 9, 21, 5 };
		String ring = new String(in);
		return ring;
	}

	/********* String方法的训练结束 ***********/

	/**
	 * 判断一个字符串中共出现几个“co”：
	 */
	public void appearCount() {
		int num = 0;
		String s = "collection,conn,second,cool";
		for (int i = 0; i < s.length(); i++) {
			if (s.regionMatches(i, "cool", 0, 2)) {
				num++;
			}
		}
		// System.out.println(num);// 4

		String name = "CoolToo3ls";
		// int indexOf(int ch,int
		// fromIndex)函数：就是字符ch在字串fromindex位后出现的第一个位置.没有找到返加-1

		// 51代表数字3(ASCII)
		System.out.println(name.indexOf(51, 5));// 7
	}

	/**
	 * getBytes[]使用规则
	 */
	public void getBytesTest() {
		String s = "Come on,boy!!!";
		byte[] by = s.getBytes();
		System.out.println(Arrays.toString(by));
		int i = 33;
		System.out.println("--" + (char) i + "-");
	}

	/**
	 * 汉字字符检查
	 * <p>
	 * 使用给定的charset将此String编码到byte序列，并将结果存储到新的 byte 数组。 对于字符串中的汉字，是按照 char
	 * 来计算的，一个中文汉字占两个字节，也就是说，通过 length()得到的是字符串 char 的长度，而不是字节数，利用这个特点，就可以进行中文判
	 * 断了。 例如：如何判断一个字符串里面有没有中文呢？如果字符串对应的 byte[]和 char[]的长
	 * 度是不一样的，那就说明包含中文，还可以顺带计算出有几个汉字。
	 */
	public void cnTest() {
		String con = "你好，世界";
		char[] newCon = con.toCharArray();// 将此字符串转换为一个新的字符数组。
		int charLen = con.length();// 字符串长度
		int byteLen = con.getBytes().length;// 字节数长度（一个汉字俩字节）
		if (byteLen > charLen) {
			int chineseNum = byteLen - charLen;
			System.out.println("str包含汉字，汉字字符共" + chineseNum + "个");
		} else {
			System.out.println("str没有包含汉字");
		}

	}

	/**
	 * 字符串转数组，点号的格式写法
	 */
	public void splitTest() {
		String one = "a.b.c.d";
		String[] o = one.split(".");
		System.out.println(Arrays.toString(o));

		String[] n = one.split("\\.");// "\\|" 即|同理
		System.out.println(Arrays.toString(n));
	}

	public void concatTest() {
		String one = "adf";
		String sd = "123";
		System.out.println(sd.concat(one));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaTest2 j = new JavaTest2();
		// System.out.println(j);
		// j.arrayTest();
		// j.fillTest();
		// StudentGrade g = StudentGrade.D;
		// j.enumTest(g);
		//
		// Scanner can = new Scanner(System.in);
		// System.out.println("请输入内容：");
		// String s = can.next();
		// System.out.println(j.StringArray(s));
		//
		// j.printArray();
		// j.thisTest();
		// j.Etest();
		// j.dateTest();
		// System.out.println(j.stringTest()+"\n"+j.stringSub());
		// System.out.println(j.intTest());
		//
		String info = "23#24#25";
//		 j.subTest1(info);
//		 j.subTest2(info);
		 j.subTest3(info);
		//
		// j.appearCount();
		// j.getBytesTest();
		// j.cnTest();
		// j.splitTest();
		// j.concatTest();

	}

}
