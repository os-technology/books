package basic.tutorial.practice.stract;

public class Boy extends People implements B, C {

	@Override
	public void run() {
		System.out.println("The boy is running.");

	}

	@Override
	public String speak(String cont) {
		String info = "boy说话的内容为：" + cont;
		return info;
	}

	@Override
	public double height() {
		double h = 181.5;
		return h;
	}

	@Override
	public void c() {
		System.out.println("implements接口C");

	}

	@Override
	public void b() {
		System.out.println("implements接口B");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		People p = new Boy();
		String s = p.speak("Hi,I am a boy.");
		System.out.println(s);
		
		//
		Human h = Human.getInstance();
		h.sleep();
		

	}

	@Override
	public Boy getInstance() {
		Boy b = new Boy();
		return b;
	}
}

interface B {
	Object getInstance();

	public void b();
}

interface C {
	Object getInstance();

	public void c();
}
