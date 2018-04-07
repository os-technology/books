package org.chapter.databasic.other;

/**
 * 给定两个字符串 仅由小写字母组成 它们包含了相同字符
 * 
 * 求把第一个字符串变成第二个字符串的最小操作次数 且每次操作只能对第一个字符串中的某个字符移动到此字符串中的开头
 * 
 * 例如给定两个字符串“abcd" "bcad" 输出：2 因为需要操作2次才能把"abcd"变成“bcad" 方法是：abcd->cabd->bcad。
 * 
 * 休息的程序员们，看明白了吗？没事敲几行代码试试
 * 
 * @author Yujinshui
 *
 */
public class StringOrder {

	public static void main(String[] args) {
		StringOrder os = new StringOrder();

		String a = "gsdopiqweiovnxvfsdgreteyukjtyaada";
		String b = "ayjtovnxqpikdasdgviweyteudoraefsg";
		int res = os.getResult(a, b);
		System.out.println(res);
	}

	/**
	 * 获取结果
	 * 
	 * @param input
	 *            输入值
	 * @param result
	 *            目标值
	 * @author Yujinshui
	 * @return
	 * @time 2016年3月26日 下午4:05:10
	 */
	public int getResult(String input, String result) {
		String[] in = convertString2Array(input);
		String[] res = convertString2Array(result);
		return order(in, res);
	}

	/**
	 * 转换字符串为数组形式
	 * 
	 * @param input
	 * @return
	 * @author Yujinshui
	 * @time 2016年3月26日 下午5:41:58
	 */
	private String[] convertString2Array(String input) {
		char[] in = input.toCharArray();
		String[] inp = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			inp[i] = String.valueOf(in[i]);
		}
		return inp;

	}

	/**
	 * 排序主函数,返回排序结果值
	 * 
	 * @param input
	 *            输入值
	 * @param result
	 *            目标结果值
	 * @author Yujinshui
	 * @time 2016年3月26日 下午4:20:23
	 */
	public int order(String[] input, String[] result) {
		int in = input.length - 1;
		StringBuilder builder = new StringBuilder();
		a: for (int i = input.length - 1; i > 0; i--) {
			boolean flag = result[i].equals(input[in]);
			if (!flag) {
				builder.append(input[in]);
				if (in == 0)
					break a;
				in = lastValue(builder, in - 1, input, result[i]);
			}
			if (in > 0)
				in--;
			else
				break a;
		}
		return builder.length();
	}

	/**
	 * 递归处理
	 * 
	 * @param builder
	 * @param i
	 * @param input
	 * @param result
	 * @return
	 * @author Yujinshui
	 * @time 2016年3月26日 下午4:20:16
	 */
	public int lastValue(StringBuilder builder, int i, String[] input, String result) {

		if (i >= 0) {
			boolean flag = result.equals(input[i]);
			if (!flag) {
				builder.append(input[i]);
				if (i > 0)
					return lastValue(builder, i - 1, input, result);
				else
					return i;
			}
		}
		return i;
	}

}
/**
 * 排序说明(方便说明，故进行大小写区分，实际排序两者需内容值相同，可以不同顺序)：ABCDE - >abdec,<br>
 * 根据目标结果<br>
 * 从最后一位开始找起，c对应的第五位的E，不是C，E需要排序；<br>
 * c对应的第四位是D，也不为C，D需要排序；<br>
 * c对应的第三位是C，则进行e位置的查找；<br>
 * e对应第二位的是B，需要排序；<br>
 * e对应的第一位是A，需要排序；<br>
 * 由此，得出排序次数结果值，即需要排序的内容为EDBA，从length值得到，排序次数为4次。<br>
 */
