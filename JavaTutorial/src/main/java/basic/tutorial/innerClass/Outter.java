package basic.tutorial.innerClass;

public class Outter {
	private String out = "外部类String";
	public static String outStat = "外部类static";

	/**
	 * 本地类练习
	 * 
	 * @return
	 */
	public String test() {
		String result = null;
		class Inner {
			public Inner(int in) {

				System.out.println("本地类初始化成功:" + in);
			}

			private String innerReturn(String ring) {
				return ring;
			}
		}
		Inner inner = new Inner(1);
		result = inner.innerReturn("innerClass return.");
		return result;
	}

	/*********************************/
	/**
	 * 匿名内部类
	 * 
	 * @author admin
	 * 
	 */
	interface Binterface {
		void testB(String yes);
	}

	public Binterface noNameClass() {
		System.out.println("匿名内部类部分(new 接口)");
		return new Binterface() {
			public void testB(String yes) {
				System.out.println("匿名内部类方法调用完成:" + yes);
			}
		};
	}

	/*** ============== ***/
	abstract class Bclass {
		public Bclass() {
			System.out.println("内部类初始化完成");
		}

		abstract void print();
	}

	public void getInnerClass() {
		Bclass bc = new Bclass() {
			public void print() {
				System.out.println("内部类打印成功,准备返回对象Bclass");

			}
		};
		bc.print();
		// return bc;
	}

	/*** ============== ***/

	class Cclass {

	}

	public void test3() {
		new Cclass() {
			public void Cprint() {
				System.out.println("内部类对象创建之后直接调用方法完成" + out);

			}
		}.Cprint();
	}

	/*********************************/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outter out = new Outter();
		// String info = new Outter().test();
		// System.out.println(info);
		/*****************/
		// Binterface b = out.noNameClass();
		// b.testB("YES!!");
		// out.getInnerClass();
		out.test3();
		/************/
		
		

	}

}
