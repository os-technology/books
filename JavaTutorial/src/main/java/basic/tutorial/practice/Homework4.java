package basic.tutorial.practice;

public class Homework4 {

	public void num(String[] s) {
		try {
			int[] k = new int[2];
			for (int i = 0; i < s.length; i++) {
				k[i] = Integer.parseInt(s[i]);
			}

			int c = k[0] / k[1];
			System.out.println("结果值：" + c);
		} catch (ArrayIndexOutOfBoundsException e3) {
			System.out.println("3 数组下标越界");
			e3.printStackTrace();
		} catch (NumberFormatException e2) {
			System.out.println("2 数字格式转换问题");
			e2.printStackTrace();
		} catch (ArithmeticException e1) {
			System.out.println("1 计算出问题");
			e1.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Homework4 h = new Homework4();
		String[] info = { "2" };
		h.num(info);

	}
}
