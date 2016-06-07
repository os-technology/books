package basic.tutorial.p4_2;

public class TestP4 {
	private int width = 0;
	private int height = 0;

	public TestP4(int w, int h) {
		width = w;
		height = h;
	}

	public TestP4() {

	}

	private void all() {
		int mianji = width * height;
		System.out.println(mianji);
	}

	@Override
	protected void finalize() {
		System.out.println("in finalize");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestP4 t = new TestP4(12, 4);
		t.finalize();
	}

}
