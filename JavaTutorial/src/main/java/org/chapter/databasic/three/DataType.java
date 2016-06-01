package org.chapter.databasic.three;

/**
 * 3.7 基本数据类型
 * 
 * @author Yujinshui
 *
 */
public class DataType {

	public void intNum() {
		// jdk7开始，允许一个或多个下划线，使阅读更容易，比如电话号码的阅读。
		// 只能位于数字之间，开头或结尾不可使用
		int a = 123_33__4;
		System.out.println(a);
		// jdk7开始，可以使用二进制指定整型字面值。可以使用0b或0B作为数值的前缀。
		int x = 0b101;
		int y = 0b1101;
		double d = 1_2.2_3;

		System.out.println(x + "  " + y + "  " + d);

	}

	public static void main(String[] args) {
		DataType type = new DataType();
		type.intNum();

	}

}
