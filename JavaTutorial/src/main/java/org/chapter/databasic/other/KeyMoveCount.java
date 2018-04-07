/**
 * 
 */
package org.chapter.databasic.other;

/**
 * 求任意给定序列 abcd 到 badc 挪动的最小次数 挪动规则,每次仅允许挪动一个字母,并且仅能放置到序列的最前方
 * 
 * 
 * @author Jann Liu
 *
 */
public class KeyMoveCount {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final String src = "gsdopiqweiovnxvfsdgreteyukjtyaada";
		final String target = "ayjtovnxqpikdasdgviweyteudoraefsg";
		final int[] ar = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// final int[] ar1 = new int[] { 6, 0, 2, 4, 3, 5, 9, 1, 8, 7 };
		final int[] ar1 = new int[] { 0, 5, 1, 9, 4, 6, 2, 3, 8, 7 };
		int mc = moveCount(src, target);
		System.out.println(mc);
		int mc1 = moveCount(ar, ar1);
		System.out.println(mc1);

	}

	public static int moveCount(int[] src, int[] target) {
		int count = 0;
		int sc = src.length - 1;
		int tc = target.length - 1;
		while (sc >= 0 && tc >= 0) {
			if (src[sc] == target[tc]) {
				sc--;
				tc--;
			} else {
				sc--;
				count++;
			}
		}
		return count;
	}

	public static int moveCount(String src, String target) {
		int count = 0;
		char[] ct = target.toCharArray();
		char[] cs = src.toCharArray();
		int sc = cs.length - 1;
		int tc = ct.length - 1;
		while (sc >= 0 && tc >= 0) {
			if (cs[sc] == ct[tc]) {
				sc--;
				tc--;
			} else {
				sc--;
				count++;
			}
		}
		return count;
	}
}
