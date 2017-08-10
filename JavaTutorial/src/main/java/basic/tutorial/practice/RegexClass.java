package basic.tutorial.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式专用类
 * 
 * @author Yu Jinshui
 * 
 */
public class RegexClass {
	/****************** 正则表达式部分开始 *******************/
	/**
	 * 匹配小示例
	 */
	public void matchTest() {
		String str = "010-62972039";
		// 1
		// System.out.println("str是一个正确的电话号码？答案是：" //
		// + str.matches("\\d{3}-\\d{8}"));
		// str.matches("0\\d{0}-\\d{8}"));
		// 2
		Pattern p = Pattern.compile("\\d{3}-\\d{8}");
		Matcher m = p.matcher(str);
		boolean flag = m.matches();
		System.out.println("str是一个正确的电话号码？答案是：" + flag);
	}

	/**
	 * 匹配结果boolean
	 * 
	 * @param cont
	 *            待匹配内容
	 * @param mat
	 *            匹配规则
	 * @return
	 */
	public boolean matchTest2(String cont, String mat) {
		boolean flag = false;
		Matcher m = null;
		try {
			Pattern p = Pattern.compile(mat);
			m = p.matcher(cont);
			// flag = m.matches();
			// while(m.find()){
			// flag = true;
			// }
			if (m.find())
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		System.out.println("子匹配数【以()为组进行数量统计】：" + m.groupCount());
		return flag;
	}

	// ///
	/**
	 * 选出符合结果的内容
	 */
	public void matTest() {
		String a = "xie12shuai123abc1b2c";
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(a);
		while (m.find()) {
			String b = m.group();
			System.out.println(b);
		}
	}

	// ///
	/**
	 * 返回匹配内容
	 * 
	 * @param cont
	 * @param mat
	 * @return
	 */
	public String matchTest2(String cont, String mat, Integer i) {
		String info = null;
		Matcher m = null;

		try {
			Pattern p = Pattern.compile(mat);
			m = p.matcher(cont);
			m.matches();
			if (i != null)
				info = m.group(i);
			else
				info = m.group();
		} catch (Exception e) {

		}

		return info;
	}

	/***** 内容替换部分 *****/

	public void exam1() {
		String info = "Java，你好，我要为你努力学习，我要吃掉你，Java。";
		String rep = "Java";
		info = info.replaceAll(rep, "java基础");
		System.out.println(info);
	}

	/**
	 * 正则的替换方法
	 * 
	 * @param info
	 *            内容
	 * @param regex
	 *            匹配规则
	 * @param replacement
	 *            替换内容
	 * @param i
	 *            0-全部替换<br/>
	 *            1-替换第一个<br/>
	 *            2-其他<br/>
	 */
	public void reInfo(String info, String regex, String replacement, int i) {
		System.out.println("原始内容：" + info);
		if (i == 0)
			info = info.replaceAll(regex, replacement);
		else if (i == 1) {// repalceFirst
			info = info.replaceFirst(regex, replacement);
		} else if (i == 2) {// replace
			info = info.replace(regex, replacement);
		}

		System.out.println("替换结果：" + info);
	}

	/***** 内容替换部分 *****/

	/****************** 正则表达式部分结束 *******************/

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RegexClass j = new RegexClass();
//		j.reInfo("<a><font color='red'>123</font>", "\\d+","000", 0);
//		System.out.println("result = " + j.reInfo("<a><font color='red'>123</font>", "\\d+","000", 0));

		/*********** 正则表达式部分 *************/
		// j.matchTest();
		// j.matTest();
		// String cont = "1232";
		// String match = "\\d{4}";//"\\d*",".{4}"
		// String cont = "1232";
		// String match = "^\\d{4}.*$";//"\\d{4}.*","^\\d{4}.*$"

		/**
		 * 说明：+号代表至少一次 *号代表至少0次
		 * 
		 * eg:"a3213" "\\ba[^a-z]*\\b"(字母a开头，后面不包含a-z的内容字符，无限次至结束),<br/>
		 * "\\ba\\d*\\b":(字母a开头，后面匹配数字至结束）<br/>
		 * "\\ba\\d{4}\\b":(字母a开头，后面只匹配数字4次（或4位数字），至结束<br/>
		 * "\\ba\\d{0,7}\\b"：(字母a开头，后面只匹配0-7位的数字，至结束<br/>
		 * 
		 * eg:"602570224@qq.vip.com"
		 * "\\d*@\\w*(.\\w*){1,2}":匹配数字无限次，@符号，匹配字母数字下划线无限次，匹配点号加字母数字下划线1-2次。
		 * 
		 * eg:"yjsjh2009@sina.com" [^\\W]==\\w
		 * 
		 * 整数匹配（正负和0）：(-|[0,9])?\d+，(-|\d)?\d+,-?\d+
		 * 
		 * eg：1-50000 49999 <br/>
		 * （1）检测是否 Email 地址
		 * ^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|
		 * (([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$<br/>
		 * <br/>
		 * "s-.123q@126.32.1.Vipa]",
		 * <p>
		 * ①^([\\w-\\.]+)@(\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)([a-zA-Z]{
		 * 2 ,4})(\\]?)$<br/>
		 * 
		 * <p>
		 * ②^([\\w-\\.]+)@(\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)([0-9]{1,3
		 * })(\\]?)$
		 * <p>
		 * ③
		 * <p>
		 * ^([\\w-\\.]+)@(\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)([a-zA-Z]{2
		 * ,4})(\\]?)$
		 */
//		String match = "(Windows(?!8))()(())";
//		String cont = "Windows98 Windows8 Windows98";
		// if (j.matchTest2(cont, match)) {
		// System.out.println(j.matchTest2(cont, match, 0));
		// }
//		System.out.println("检测完成:" + j.matchTest2(cont, match));
		/*********** 正则表达式部分 ************/
		/******** 正则内容更改部分 *********/
		/**
		 * \\d——*：每一位数字替换成一位星号 \\d+——*：不论多少位数字，只要是数字部分统一替换成一位星号(n621——n*)
		 */

		// j.exam1();

		/**
		 * "Windows 1.03 and Windows 2.0 first Released in 1985 and 1987 respectively."
		 * "Windows [\\w\\.]+\\b"<br/>
		 * *Windows 1.03* and *Windows 2.0* first Released in 1985 and 1987
		 * respectively.
		 * <p>
		 */

//		String info = "Windows98 is not Windows2000,Windows98 is 7";
//		String regex = "(Windows(?=98))";
//		String replacement = "==$1==";
//		int i = 0;
//		j.reInfo(info, regex, replacement, i);
//		System.out.println(j.matchTest2("1231", "^[0-9]+(.[0-9]{1,3})?$"));
System.out.println("12.1113".matches("^[0-9]+(.[0-9]{1,3})?$"));
		/******** 正则内容更改部分 *********/
	}

}
