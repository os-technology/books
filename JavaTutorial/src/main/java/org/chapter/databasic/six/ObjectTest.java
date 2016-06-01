package org.chapter.databasic.six;

/**
 * 对象引用变量测试
 * 
 * @author Yujinshui
 *
 */
public class ObjectTest {
	public String sth = "first.";

	public static void main(String[] args) {
		Box1 box1 = new Box1();
		Box1 box2 = box1;
		box1 = null;
		System.out.println(box2.a + "  \r\n" + box1.a);

	}

}

class Box1 {
	public static String a = "1";
}
