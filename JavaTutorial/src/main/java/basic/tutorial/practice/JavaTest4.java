package basic.tutorial.practice;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaTest4 {

	public void stringBuffer(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(str);
		// buffer.append("abc", 1, 3);
		int i = buffer.capacity();// 得到buffer的容量
		System.out.println(i);

		char at = buffer.charAt(3);// 返回 StringBuffer 对象中指定位置的字符
		System.out.println(at);

		buffer.setCharAt(3, (char) 65);// 设置 StringBuffer 对象中指定位置的字符
		buffer.reverse();// 将 StringBuffer 对象中的字符序列按逆序方式排列，可用作字符串倒序
		System.out.println(buffer);
	}

	/**
	 * Math方法测试
	 * 
	 * @param d
	 */
	public void mathTest(double d) {
		double s = 2 * Math.PI * d;
		BigDecimal bg = new BigDecimal(s);
		s = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("圆面积：" + s);

		System.out.println(Math.floor(s));// 返回不大于 d 的最大整数
		System.out.println(Math.ceil(s));// 返回不小于 d 的最小整数

	}

	/**
	 * 返回不小于 d 的最小整数
	 * 
	 * @param i
	 *            总数
	 * @param num
	 *            每组个数
	 */
	public void MathTest2(int i, int num) {
		int count = (int) Math.ceil(i * 1.0 / num);
		System.out.println(count);
	}

	/**
	 * 检查日期是否在指定日期之前/后
	 * 
	 * @param date
	 * @return
	 */
	public String dateTest(SimpleDateFormat sdf, Date date) {
		String result = null;
		if (new Date().after(date))// 测试此日期是否在参数之后
			result = "今天在" + sdf.format(date) + "之后";
		if (new Date().before(date))// 测试此日期是否在参数之前
			result = "今天在" + sdf.format(date) + "之前";
		else
			result = "今天就是" + sdf.format(date);
		return result;

	}

	/**
	 * 指定日期格式，输出结果
	 * 
	 * @param dateformat
	 *            日期格式定义
	 * @param setdate
	 *            指定日期
	 * @throws ParseException
	 */
	public void dateFormat(String dateformat, String setdate) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		Date date = null;
		if (setdate == null)
			date = new Date();
		else {
			try {
				date = sdf.parse(setdate);
			} catch (ParseException e) {
				System.out.println("setdate内容有误");
			}
		}
		String format = sdf.format(date);
		System.out.println(format);

	}

	public void date() {
		SimpleDateFormat sdf = new SimpleDateFormat("a h:mm");
		System.out.println(sdf.format(new Date()));
	}

	/**
	 * Calendar相关
	 * 
	 * @param days
	 */
	@SuppressWarnings("static-access")
	public void calendarTest(int days) {
		Calendar c = Calendar.getInstance();
		c.add(c.DATE, days);
		int year = c.get(c.YEAR);
		int month = c.get(c.MONTH) + 1;// 从0开始计算

		int day = c.get(c.DAY_OF_MONTH);
		System.out.println("输出日期为：" + year + "年" + month + "月" + day + "日");
	}

	/**
	 * Calendar和Date的相互转化
	 * 
	 * @param flag
	 */
	public void dateAndCalendar(boolean flag) {
		if (flag) {
			System.out.println("Calendar--->Date");
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			System.out.println(date);
		} else {
			System.out.println("Date--->Calendar");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

			Date date = null;
			try {
				date = sd.parse("2013-1-3");
			} catch (ParseException e) {
				e.printStackTrace();
			}

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			Calendar c = Calendar.getInstance();
			c = gc;
			System.out.println(c.get(Calendar.YEAR));
		}

	}

	/**
	 * 系统属性部分
	 */
	@SuppressWarnings("rawtypes")
	public void sysProperties() {
		// System.out.println("返回系统属性：");
		// Properties props = System.getProperties();
		// Enumeration prop_names = props.propertyNames(); // 这是个早期的集合类
		// while (prop_names.hasMoreElements()) {
		// String prop_name = (String) prop_names.nextElement();
		// String property = props.getProperty(prop_name);
		// System.out.println("Property '" + prop_name + "' is '" + property
		// + "'");
		// }
		// //////////////
		// int x = 4;
		// int y = 2;
		// int sum = x+y;
		// System.out.printf("%d = %d\n",x,sum);
		// ///////////////////

		try {
			String name = "test.properties";
			InputStream in = new BufferedInputStream(new FileInputStream(name));
			Properties p = new Properties();
			p.load(in);
			System.out.println("test1的值==" + p.getProperty("test1"));
			System.out.println("test2的值==" + p.getProperty("test2"));
			System.out.println("test3的值==" + p.getProperty("test3"));
		} catch (Exception err) {
			err.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		JavaTest4 j = new JavaTest4();
		// String s = "123456";
		// j.stringBuffer(s);
		//
		// j.mathTest(2);
		// j.MathTest2(123, 21);
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String result = null;
		// try {
		// result = j.dateTest(sdf, sdf.parse("2014-3-8"));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// System.out.println(result);
		/*********** 指定日期格式输出结果 ****************/
		/**
		 * "yyyy.MM.dd G 'at' HH:mm:ss z"——2014.03.08 公元 at 19:57:25 CST
		 * <p>
		 * "EEE, MMM d, ''yyyy"——星期六, 三月 8, '2014
		 * <p>
		 * "h:mm a"——7:59 下午
		 * <p>
		 * "hh 'o''clock' a, zzzz"——08 o'clock 下午, 中国标准时间
		 * <p>
		 * "K:mm a, z"——8:43 下午, CST
		 * <p>
		 * "yyyyy.MMMMM.dd GGG hh:mm aaa"——02014.三月.08 公元 08:43 下午
		 * <p>
		 * "yyMMddHHmmssZ"——140308205613+0800
		 * <p>
		 */
		// String date = "";
		// String datedefine = null;
		// j.dateFormat(date, datedefine);

		/*********** 指定日期格式输出结果 ****************/
		/********* Calendar ***********/

		// j.calendarTest(30);
		// j.dateAndCalendar(false);
		/********* Calendar ***********/

//		j.sysProperties();
		
		String info= "12";
		String regex = "\\d+(\\.\\d{2})?";
			
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(info);
		
		if(m.matches())
			System.out.println(info);
		
		
	}
}
