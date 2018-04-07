package basic.tutorial.innerClass;

public class Prac {

	public int test() {
		int a = 0;
		try {
			a = 12;
			return a;
		} finally {
			System.out.println("asf");
		}

	}

	private void labelTest3() {

		String o = "";
		z: for (int i = 0; i < 5; i++) {
			System.out.println("i="+i);
			for (int x = 3; x < 8; x++) {
				System.out.println("x="+x);
				if (x == 6)
					break z;
				o = o + x;
			}
		}
		System.out.println(o);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Prac p = new Prac();
		p.labelTest3();
	}

}
