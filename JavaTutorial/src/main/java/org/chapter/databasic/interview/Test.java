package org.chapter.databasic.interview;

/**
 * 一个字符串数组，一个字符串，按照字符串数组的字母顺序，判断给定的字符串是否符合要求，给定的字符串重复的不算。 <br>
 * <ul>
 * <li>【括号为了标记出正确字符用】</li>
 * <li>比如：abce，输入abbcce,输出true</li>
 * <li>abce,输入abdee,输出false</li>
 * <li>abce,输入(ab)b(c)ccddd(e),输出true</li>
 * <li>abce,输入(a)aa(bc)fn(e)d,输出true</li>
 * 
 * @author Yu Jinshui
 * @createTime 2016年6月3日 下午7:51:19
 */
public class Test {

	public static boolean info(String[] n, String con) {
		boolean flag = false;
		char[] check = con.toCharArray();// 待检测
		a: for (String s : n) {
			int m = 0;
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

	public static void main(String[] args) {
		String[] n = { "abce", "sfcs", "adee" };
		String a1 = "asadb";
		String a2 = "abcced";
		String a3 = "abcf";
		System.out.println(info(n, a2));

	}

}
