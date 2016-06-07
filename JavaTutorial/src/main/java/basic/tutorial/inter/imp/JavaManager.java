package basic.tutorial.inter.imp;

import basic.tutorial.inter.Employee;
import basic.tutorial.inter.Manager;

/**
 * java管理者
 * 
 * @author admin
 * 
 */
public class JavaManager extends Info {

	public String doJob() {
		return WORK + doJob();

	}

	public void rest() {
		System.out.println(REST);

	}

	public void food() {
		System.out.println(FOOD);

	}

	public void speak() {
		System.out.println(SPEAK);

	}

	public String command() {

		return null;
	}

	public String command(String info) {
		return info;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaManager man = new JavaManager();
		// man.speak();
		System.out.println(man.doJob());
		Employee em = new Manager();
		Manager m = (Manager) em;
		((Manager) em).command("");
	}

}
