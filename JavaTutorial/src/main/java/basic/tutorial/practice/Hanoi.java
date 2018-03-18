package basic.tutorial.practice;

public class Hanoi {
	/**
	 * 
	 * @param n
	 *            盘子的数目
	 * @param origin
	 *            源座
	 * @param assist
	 *            辅助座
	 * @param destination
	 *            目的座
	 */
	public void hanoi(int n, char origin, char assist, char destination) {
		if (n == 1) {
			move(origin, destination);
		} else {
			hanoi(n - 1, origin, destination, assist);
			move(origin, destination);
			hanoi(n - 1, assist, origin, destination);
		}
	}

	// Print the route of the movement
	int count = 0;
	private void move(char origin, char destination) {
		count++;
		System.out.println(count+" Direction:" + origin + "--->" + destination);
	}

	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.hanoi(9, 'A', 'B', 'C');
	}
}
