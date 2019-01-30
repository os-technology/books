package org.chapter.databasic.interview;

import java.util.ArrayList;
import java.util.List;

public class Temp {

	
	static  String[][] arrays={{"a","b","c","d"},{"b","d","b","r"},{"m","b","c","k"},{"a","v","k","c"}};
	boolean result = false;
/*
 * abcd
 * dbba
 * bbac
 */
	public static void main(String[] args) {
		boolean f = new Temp().check("dbcbv");
		System.out.println(f);
	}

	/**
	 * 判断是否存在
	 * 
	 * @param searchStr
	 *            待查串
	 * @return
	 */
	public boolean check(String searchStr) {
		if (searchStr != null && !searchStr.trim().isEmpty()) {
			String[] charss = searchStr.trim().split("");
			String[] chars = new String[charss.length - 1];
			for (int i = 0; i < charss.length - 1;) {
				chars[i] = charss[++i];
			}
			List<Integer[]> firstList = searchFirstStr(chars[0]);
			if (firstList != null) {
				for (Integer[] tarr : firstList) {
					searchAroundCycle(tarr, 1, chars);
					if (result) {
						return result;
					} else {
						continue;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 递归查询
	 * 
	 * @param tarr
	 *            当前位置数组 0：row 1: colum
	 * @param count
	 *            : 当前待查字符串的位
	 * @param chars
	 *            待查字符串的 array形式
	 */
	private void searchAroundCycle(Integer[] tarr, int count, String[] chars) {
		int i = count;
		if (i == chars.length) {
			result = true;
		} else {
			List<Integer[]> tarrlist = searchAround(tarr, i, chars);
			if (tarrlist != null) {
				i += 1;
				for (Integer[] s : tarrlist) {
					if (result) {
						break;
					} else {
						searchAroundCycle(s, i, chars);
					}
				}

			}
		}

	}

	/**
	 * 查找四周，并返回list位置
	 * 
	 * @param tarr
	 *            list位置
	 * @param index
	 *            待查串位置
	 * @param chars
	 *            待查串的array 形式
	 * @return
	 */
	private List<Integer[]> searchAround(Integer[] tarr, int index, String[] chars) {
		List<Integer[]> list = new ArrayList<Integer[]>();
		if (tarr[0].intValue() != 0) {
			addUp(tarr, list, chars[index]);

		}
		if (tarr[0].intValue() != arrays.length - 1) {
			addDown(tarr, list, chars[index]);
		}
		if (tarr[1].intValue() != 0) {
			addLeft(tarr, list, chars[index]);
		}
		if (tarr[1].intValue() != arrays[tarr[0]].length - 1) {
			addRight(tarr, list, chars[index]);
		}
		return list;
	}

	/**
	 * 添加上
	 * 
	 * @param tarr
	 * @param list
	 * @param s
	 */
	private void addUp(Integer[] tarr, List<Integer[]> list, String s) {
		int col = arrays[tarr[0] - 1].length;
		if (col - 1 >= tarr[1]) {
			if (s.equals(arrays[tarr[0] - 1][tarr[1]])) {
				Integer[] ai = new Integer[2];
				ai[0] = tarr[0] - 1;
				ai[1] = tarr[1];
				list.add(ai);
			}
		}
	}

	/**
	 * 添加下
	 * 
	 * @param tarr
	 * @param list
	 * @param s
	 */
	private void addRight(Integer[] tarr, List<Integer[]> list, String s) {
		int c = arrays[tarr[0]].length;
		if (c - 1 >= tarr[1]) {
			if (s.equals(arrays[tarr[0]][tarr[1] + 1])) {
				Integer[] ai = new Integer[2];
				ai[0] = tarr[0];
				ai[1] = tarr[1] + 1;
				list.add(ai);
			}
		}
	}

	/**
	 * 添加左
	 * 
	 * @param tarr
	 * @param list
	 * @param s
	 */
	private void addLeft(Integer[] tarr, List<Integer[]> list, String s) {
		if (s.equals(arrays[tarr[0]][tarr[1] - 1])) {
			Integer[] ai = new Integer[2];
			ai[0] = tarr[0];
			ai[1] = tarr[1] - 1;
			list.add(ai);
		}

	}

	/**
	 * 添加右
	 * 
	 * @param tarr
	 * @param list
	 * @param s
	 */
	private void addDown(Integer[] tarr, List<Integer[]> list, String s) {
		int col = arrays[tarr[0] + 1].length;
		if (col - 1 >= tarr[1]) {
			if (s.equals(arrays[tarr[0] + 1][tarr[1]])) {
				Integer[] ai = new Integer[2];
				ai[0] = tarr[0] + 1;
				ai[1] = tarr[1];
				list.add(ai);
			}
		}
	}

	/**
	 * 查找待查串首字母位置
	 * 
	 * @param chars
	 * @return list,0: row ,1: colum
	 */
	private static List searchFirstStr(String chars) {
		List<Integer[]> list = new ArrayList<Integer[]>();
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				if (chars.equals(arrays[i][j])) {
					Integer[] iarray = new Integer[2];
					iarray[0] = i;
					iarray[1] = j;
					list.add(iarray);
				}
			}
		}
		return list;
	}

}
