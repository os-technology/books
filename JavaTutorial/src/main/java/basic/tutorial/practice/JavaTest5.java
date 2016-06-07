package basic.tutorial.practice;

/**
 * 自定义异常，断言(assert)
 * 
 * @author Yu Jinshui
 * 
 */
public class JavaTest5 {

	/**
	 * 当Java运行时系统检查到被零除的情况，它构造一个新的异常对象然后引发该异常。这导致
	 * Exc0的执行停止，因为一旦一个异常被引发，它必须被一个异常处理程序捕获并且被立即处理。
	 * 该例中，没有提供任何异常处理程序，所以异常被Java运行时系统的默认处理程序捕获。任何不
	 * 是被你程序捕获的异常最终都会被该默认处理程序处理。默认处理程序显示一个描述异常的字符 串，打印异常发生处的堆栈轨迹并且终止程序。
	 */
	public void intTest() {
		int a = 0;
		int k = 0;
		try {
			res(2, k);
			System.out.println(k);
		} catch (IntException e) {
			System.out.println(e.getMessage());// 显示自定义异常结果信息
			e.printStackTrace();// 打印堆栈轨迹
		}

	}

	/**
	 * 自定义异常类处理方案
	 * 
	 * @param m
	 * @param k
	 * @return
	 * @throws IntException
	 */
	public int res(int m, int k) throws IntException {
		if (k == 0) {

			IntException i = new IntException("除数不可以为" + k);
			throw i;

		}
		return m / k;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void intTest2() throws Exception {
		int a = 0;
		int k;
		try {
			k = 2 / a;
		} catch (Exception e) {
			throw new Exception("Can not be divided by zero!");
			// System.out.println("after throw");//该行代码不会被执行
		}
		System.out.println(k);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JavaTest5 j = new JavaTest5();
		// j.intTest();
		AssertLearn ass = new AssertLearn();
		ass.main(args);

	}

}

/**
 * 自定义异常类
 * 
 * @author Yu Jinshui
 * 
 */
class IntException extends Throwable {
	public IntException() {
		super();

	}

	public IntException(String msg) {
		super(msg);

	}
}

/******************************************************************************************/

/**
 * .断言用于证明和测试程序的假设，比如“这里的值大于 5”。<br/>
 * .断言可以在运行时从代码中完全删除，所以对代码的运行速度没有影响。 断言的使用
 * <p>
 * 断言有两种方法：
 * <p>
 * .一种是 assert<<布尔表达式>> ；<br/>
 * .另一种是 assert<<布尔表达式>> ：<<细节描述>>。<br/>
 * 如果布尔表达式的值为false ， 将抛出AssertionError 异常； 细节描述是 AssertionError异常的描述文本<br/>
 * 使用 javac –source 1.4 MyClass.java 的方式进行编译
 * 
 * @author Yu Jinshui
 * 
 */
class AssertLearn {

	/**
	 * 断言推荐使用方法<br/>
	 * 用于验证方法中的内部逻辑，包括：<br/>
	 * -内在不变式<br/>
	 * -控制流程不变式<br/>
	 * -后置条件和类不变式<br/>
	 * 注意：不推荐用于公有方法内的前置条件的检查
	 */
	public AssertLearn() {

	}

	/**
	 * run->run Configurations->Arguments,在 VM arguments 文本框中输入： -ea 注意
	 * 中间没有空格，如果输入 -da 表示禁止断言。
	 * 
	 * 然后关闭该窗口，提示保存，然后保存就开启了断言 如果禁止断言，则按第二步操作中，删除 -ea 或者将 -ea 改为 -da 即可。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		assert a == b : "It's fault!";
		System.out.println("a==b is true");
	}

}