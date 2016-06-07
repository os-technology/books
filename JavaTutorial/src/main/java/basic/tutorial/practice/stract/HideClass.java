package basic.tutorial.practice.stract;

/**
 * 1、实现对接口实现类的隐藏，从而达到不显示类名但是可以调用其方法的目的 <br/>
 * 2、抽象类对接口的实现
 * 
 * @author Yu Jinshui
 * 
 */
public class HideClass {

	/**
	 * 隐藏Boys实现类
	 * 
	 * @return
	 */
	public Person getPerson() {
		return new Boys();
	}

	/**
	 * Think1的实例化类——Impthink1
	 * 
	 * @return
	 */
	public Think1 getInstance1() {
		return new Impthink1();
	}

	/**
	 * Think2的实例化类——Impthink2
	 * 
	 * @return
	 */
	public Think2 getInstance2() {
		return new Impthink2();
	}

	/**
	 * 接口作为引用类型来使用,Java 运行时系统会动态地确定应该使用哪 个类中的方法，实际上是调用相应的实现类的方法。
	 * 
	 * @param th
	 */
	public void testThink1(Think1 th) {
		th.goodMind();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HideClass hc = new HideClass();
		// // 隐藏类的实现
		// Person p = hc.getPerson();
		// String gen = p.gender();
		// System.out.println(gen);

		// 接口(Mind)-抽象类(Think1,2)-实现类(Impthink1,2)
		Think1 th1 = hc.getInstance1();
		// th1.goodMind();
		/*****************/
		// th1.impThink1();
		// Impthink1 imp = (Impthink1)th1;
		// imp.impThink1();
		/*****************/
		// th1.sadMind();
		// ((Impthink1)th1).testImpthink1();

		// 接口作为引用类型使用
		// hc.testThink1(th1);

	}

}

/**
 * Person接口
 * 
 * @author Yu Jinshui
 * 
 */
interface Person {
	void run();

	void sleep();

	String speak(String str);

	String gender();

}

/**
 * Boys类实现接口Person
 * 
 * @author Yu Jinshui
 * 
 */
class Boys implements Person {
	private String sex = "boys ";

	@Override
	public void run() {
		System.out.println(sex + "正奔跑在前进的路上");

	}

	@Override
	public void sleep() {
		System.out.println(sex + "正在睡觉");

	}

	@Override
	public String speak(String str) {
		return sex + "说：" + str;
	}

	@Override
	public String gender() {

		return sex;
	}

	public void bb() {
		System.out.println("非实现方法");
	}

}

/**
 * Mind接口
 * 
 * @author Yu Jinshui
 * 
 */
interface Mind {
	void goodMind();

	void sadMind();
}

abstract class Think1 implements Mind {

	@Override
	public abstract void goodMind();

	@Override
	public abstract void sadMind();

	public void impThink1() {
		System.out.println("Think1抽象类的方法实现");
	}

}

abstract class Think2 implements Mind {

	@Override
	public void goodMind() {
		System.out.println("Think2抽象类实现接口Mind的goodMind方法");

	}

	@Override
	public void sadMind() {
		System.out.println("Think2抽象类实现接口Mind的sadMind方法");
	}

	public abstract void rest();
}

class Impthink2 extends Think2 {

	@Override
	public void rest() {
		System.out.println(Impthink2.this + "--Impthink2类对抽象类Think2的实现");

	}

}

class Impthink1 extends Think1 {

	@Override
	public void goodMind() {
		System.out.println("Impthink1实现类对Think1的goodMind方法实现");

	}

	@Override
	public void sadMind() {
		System.out.println("Impthink1实现类对Think1的sadMind方法实现");

	}

	public void testImpthink1() {
		System.out.println("Impthink1类非继承方法的打印");
	}

}
