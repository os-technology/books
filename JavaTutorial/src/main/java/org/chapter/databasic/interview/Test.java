package org.chapter.databasic.interview;

/**
 * 
 * 
 * @author Yu Jinshui
 * @createTime 2016年6月3日 下午7:51:19
 */
public class Test {
	/**
	 * 一个字符串数组，一个字符串，按照字符串数组的字母顺序，判断给定的字符串是否符合要求，给定的字符串重复的不算。 <br>
	 * <ul>
	 * <li>【括号为了标记出正确字符用】</li>
	 * <li>比如：abce，输入abbcce,输出true</li>
	 * <li>abce,输入abdee,输出false</li>
	 * <li>abce,输入(ab)b(c)ccddd(e),输出true</li>
	 * <li>abce,输入(a)aa(bc)fn(e)d,输出true</li>
	 *
	 * @param n
	 * @param con
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年6月3日 下午9:06:25
	 */
	public static boolean info(String[] n, String con) {
		boolean flag = false;
		char[] check = con.toCharArray();// 待检测
		int m = 0;
		a: for (String s : n) {
			char[] set = s.toCharArray();// 给定值
			for (int i = 0; i < check.length; i++) {
				if (set[m] == check[i]) {
					if (m < set.length - 1)
						m++;
					else {
						flag = true;
						break a;
					}
					continue;
				} else {
					continue;
				}
			}
		}

		return flag;
	}

	private static boolean check(String[] n, String input) {
		boolean flag = false;
		int m = 0;
		int tmp = 0;
		boolean bool = true;
		char[] in = input.toCharArray();
		for (int t = 0; t < n.length; t++) {
			char[] ch = n[t].toCharArray();
			if (t > 0) {
				if (in[m] == ch[tmp]) {
					m++;
				} else {
					if (tmp < ch.length - 1) {
						if (in[m] == ch[tmp + 1] || in[m] == ch[tmp - 1]) {
							m = (in[m] == ch[tmp + 1]) ? tmp + 1 : ((in[m] == ch[tmp - 1]) ? tmp - 1 : m);
						} else {
							 
						}
					}
				}
			} else {
				for (int i = m; i < in.length; i++) {
					if (in[m] == ch[i]) {
						m++;
					} else {
						if (i < ch.length - 1) {
							if (in[i] == ch[i + 1] || in[i] == ch[i - 1]) {
								m = (in[i] == ch[i + 1]) ? i + 1 : ((in[i] == ch[i - 1]) ? i - 1 : m);
							} else {
								tmp = m - 1;
								break;
							}
						} else {
							tmp = m - 1;
							break;
						}
					}
				}
			}
		}

		return flag;
	}

	public static void main(String[] args) {
		String[] n = { //
				"abce"//
				, "sfcs"//
				, "adee" };
		String a1 = "asbd";// false
		String a2 = "abcced";// true
		String a3 = "abcf";// false
		String a4 = "abccs";// true
		System.out.println(check(n, a4));

	}

}
