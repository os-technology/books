package org.chapter.databasic.interview.cal;

/**
 * 一串内容，每隔三个输出一个值，直到全部结束为止。
 * <p>
 * abcde<br>
 * c ->abde，然后从d开始继续循环，dea,输出a,剩下bde,输出e,剩下bd,b-d-b,输出b,最后输出d
 * 
 * @author yujinshui
 * @createTime 2016年7月2日 下午8:29:23
 */
public class PrintString {

	private void output(String[] input) {
		int count = 0;
		int time = 0;
		while (input.length - time > 0) {
			for (int i = 0; i < input.length; i++) {
				if (!"".equals(input[i])) {
					count++;
				} else {
					continue;
				}
				if (count == 3) {
					System.out.print(input[i] + " ");
					input[i] = "";
					time++;
					count = 0;
				}
			}
		}

	}

	private static String[] newout(String[] tmp, int i) {
		for (int j = i; j < tmp.length - 1; j++) {
			tmp[j] = tmp[j + 1];
		}
		tmp[tmp.length - 1] = tmp[0];
		return tmp;
	}

	// 一次只能删除一个元素
	private static String[] remove(String[] arr, int num) {
		String[] tmp = new String[arr.length - 1];
		int idx = 0;
		boolean hasRemove = false;
		for (int i = 0; i < arr.length; i++) {
			if (!hasRemove && i == num) {
				hasRemove = true;
				continue;
			}
			tmp[idx++] = arr[i];
		}
		return tmp;
	}

	public static void main(String[] args) {
		PrintString ps = new PrintString();

		String[] input = { "a", "b", "c", "d", "e" };
		// System.out.println(Arrays.toString(res));
		ps.output(input);
		// c,a,e,b,d

	}

}
