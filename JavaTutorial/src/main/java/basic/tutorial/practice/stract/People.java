package basic.tutorial.practice.stract;

/**
 * 抽象类部分练习
 * 
 * @author Yu Jinshui
 * 
 */
public abstract class People {
	/**
	 * 奔跑
	 */
	public abstract void run();

	// String speak(String cont);//这样写是错误的
	/**
	 * 说话
	 * 
	 * @param cont
	 * @return
	 */
	public abstract String speak(String cont);

	/**
	 * 高度
	 * 
	 * @return
	 */
	public abstract double height();

}

/**
 * 抽象类不一定存在抽象方法
 * 
 * @author Yu Jinshui
 * 
 */
abstract class Human {

	public static Human getInstance() {
		Human h = new Friend();
		return h;

	}

	void man() {
		System.out.println("man");
	}

	void girl() {
		System.out.println("girl");
	}

	abstract void sleep();

}

class Friend extends Human {

	@Override
	void sleep() {
		System.out.println("friend实现Human的睡觉方法，且Friend类被隐藏掉");

	}

	public String dothing(String thing) {
		String th = "friend正在做的事情为：" + thing;
		return null;
	}

}
