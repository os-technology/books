package basic.tutorial.innerClass;

public class Outer {

	private int size;

	/**
	 * Inner类
	 * 
	 * @author admin
	 * 
	 */
	public class Inner {
		private int counter = 10;
		private String info = "";

		public Inner(String str) {
			info = str;
			System.out.println(info);
		}

		public void doStuff() {
			size++;
		}
	}

	/**
	 * Inner2，static 类
	 * 
	 * @author admin
	 * 
	 */
	private static int Inner2size;
	 static class Inner2 {

		public void inner2Print() {
			
			System.out.println("Inner2打印测试+Inner2size="+Inner2size);
		}

		public static void inner2StaticPrint() {
			Inner2size++;
			System.out.println("Inner2_static方法打印测试+Inner2size="+Inner2size);
		}
	}

	public void testInner() {
		Inner in = new Inner("内部类已经创建");
	}

	public Inner getInner() {
		return new Inner("内部类已经创建");
	}

	public MethodClass methodClass(String cont) {
		class InnerMethodClass implements MethodClass {

		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer();
		Inner inner = outer.getInner();
		inner.doStuff();
		System.out.println(outer.size);
		System.out.println(inner.counter);
		// 编译错误，外部类不能访问内部类的private 变量
		// System.out.println(counter);
		/*******************/
		// 静态内部类访问方式
		Outer.Inner2 out2 = new Outer.Inner2();
		out2.inner2Print();
		Outer.Inner2.inner2StaticPrint();
		/*******************/

	}

}
