package basic.tutorial.add2015.warning;

public class ErrorTest {

	private static final Object[] oa = new Object[0];

	public static <T> T emptyArray() {
		return (T) oa;
	}

	public static void main(String[] args) {
		Object[] o = emptyArray();
		System.out.println("Object run successful.");

		Integer[] o1 = emptyArray();
		System.out.println("Integer run successful.");

	}

}
