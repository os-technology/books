package basic.tutorial.innerClass2;

public class noNameClass {
	public pr dest() {
		return new pr() {
			public void print1() {
				System.out.println("Hello world!!");
			}
		};
	}

	public static void main(String args[]) {
		noNameClass c = new noNameClass();
		pr hw = c.dest();
		hw.print1();
	}
}
