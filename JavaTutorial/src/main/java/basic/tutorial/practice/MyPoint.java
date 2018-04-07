package basic.tutorial.practice;

public class MyPoint {

	private int x, y;

	public void setX(int x) {
		this.x = x;

	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String xyToString() {
		return ("(" + getX() + "," + getY() + ")");
	}

	public void one(MyPoint my) {

		my.setX(12);
		my.setY(22);
		System.out.println(my.xyToString());
	}

	/**
	 * 0,1,1,2,3,5,8,13,21
	 * 
	 * @param i
	 * @return
	 */
	public void num1(int i) {
		int k1 = 0;
		int k2 = 1;
		int[] s = new int[i];

		for (int m = 0; m < i; m++) {
			if (m < 2) {
				s[m] = m;
			}
			if (m >= 2)
				s[m] = s[m - 1] + s[m - 2];
		}
		for (int k = 0; k < s.length; k++) {
			System.out.print(s[k] + ",");
		}

	}

	/**
	 * 水仙花数是指一个 n 位数 ( n≥3 )，它的每个位上的数字的 n 次幂之和等于它本身。（例如：1^3 + 5^3 + 3^3 = 153）
	 */
	private void flowerNum(int limit) {
		int num = 100;
		for (int i = 100; i < limit; i++) {
			flowerNum2(i);
		}
	}

	private void flowerNum2(int i) {
		// String s = String.valueOf(i);
		StringBuffer buff = new StringBuffer();
		buff.append(i);
		int len = buff.length();
		int sum = 0;
		for (int k = 0; k < len; k++) {
			// /int temp = Integer.parseInt(s.substring(k, k + 1));
			int temp = Integer.parseInt(String.valueOf(buff.charAt(k)));
			// System.out.println(temp);
			double d = Math.pow(temp, len);
			sum += d;
		}
		if (buff.toString().equals(String.valueOf(sum)))
			System.out.println(i + "--" + sum);

	}

	public static void main(String[] args) {
		MyPoint my = new MyPoint();
		// my.one(my);
		// my.num1(2);
		// double u = Math.pow(4, 3);
		// System.out.println(u);
		my.flowerNum(1000);
	}

}
