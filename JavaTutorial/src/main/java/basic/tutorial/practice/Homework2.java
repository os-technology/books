package basic.tutorial.practice;

public class Homework2 {

	public void overrideTest(String str) {
		System.out.println("方法的重载测试:" + str);
	}

	public void overrideTest() {
		System.out.println("原始方法");
	}

	class Test {
		public void printinfo() {
			Homework2 hw = new Homework2();
			hw.overrideTest("success！！");
		}
	}

	/*************************************/
	// 类之间的继承作业
	public static class Rodent {// 啮齿动物[ˈrəʊdnt]

		public void bodyColor(Object names) {
			String name = names.getClass().toString();
			name = name.substring(name.lastIndexOf(".") + 1);
			if (names instanceof Mouse)
				System.out.println(name + ":颜色为灰色");
			if (names instanceof Gerbil)
				System.out.println(name + ":颜色为土色");
			if (names instanceof Hamster)
				System.out.println(name + ":颜色为绿色");
		}

		public String teeth(String len) {
			return len;
		}

		public static void main(String[] args) {
			System.out.println("Rodent主方法调用");
		}
	}

	class Mouse extends Rodent {// 老鼠
		@Override
		public void bodyColor(Object names) {
			System.out.println("Mouse  覆盖后的bodyColor方法：");
			String name = names.getClass().toString();
			name = name.substring(name.lastIndexOf(".") + 1);
			if (names instanceof Gerbil)
				System.out.println(name + ":颜色为黄土色");
			if (names instanceof Hamster)
				System.out.println(name + ":颜色为青绿色");
			System.out.println("Mouse");
		}
	}

	class Gerbil extends Mouse {// 鼹鼠[ˈdʒə:bil]
		public String teeth(String len) {
			int yan = Integer.parseInt(len) + 1;
			return "鼹鼠:" + yan;
		}
	}

	class Hamster extends Mouse {// 大颊鼠[ˈhæmstə(r)]
		public String teeth(String len) {
			int yan = Integer.parseInt(len) + 2;
			return "大颊鼠:" + yan;
		}
	}

	/*************************************/

	/****/
	String s;

	void Mystery() {
		s = "constructor";
	}

	void go() {
		System.out.println(s);
	}

	/****/
	public void StringBufferInsert() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("12345");
		buffer.insert(0, "abc");
		System.out.println(buffer);
	}

	/*******/
	// 数组部分
	public void arrayTest() {
		int[][] in = new int[3][4];
		int a = 1;
		// int[][] in = new int[][5];

		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < 4; j++) {
				in[i][j] = i + j;
			}
		}

		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[i].length; j++) {
				System.out.print(in[i][j] + "-");
			}
			System.out.println();
		}
	}

	/*******/
	// 数组的排序
	/**
	 * 冒泡排序1-9 <br/>
	 * 对未排序的各元素从头到尾依次比较相邻的两个元素是否逆序（与欲排顺序相
	 * 反），若逆序就交换这两元素，经过第一轮比较排序后便可把最大（或最小）的元素排好，然后
	 * 再用同样的方法把剩下的元素逐个进行比较，就得到了你所要的顺序。
	 */
	public void testOrder(int[] in) {

		int temp;
		for (int i = 0; i < in.length; i++) {
			for (int j = i + 1; j < in.length; j++) {
				if (in[i] > in[j]) {
					temp = in[j];
					in[j] = in[i];
					in[i] = temp;
				}
			}
		}
		for (int i = 0; i < in.length; i++) {
			System.out.println(in[i]);
		}
	}

	/**
	 * 选择排序<br/>
	 * 基本思路：从所有元素中选择一个最小元素a[i]放在 a[0]（即让最小元素 a[i]与 a[0] 交换），作为第一轮；第二轮是从
	 * a[1]开始到最后的各个元素中选择一个最小元素，放 在 a[1] 中；……依次类推。n 个数要进行（n－1）轮。比较的次数与冒泡法一样多，但是在每
	 * 一轮中只进行一次交换，比冒泡法的交换次数少，相对于冒泡法效率高
	 */
	public void testOpt(int[] in) {

		int lowIndex;
		int count = 0;
		for (int i = 0; i < in.length; i++) {
			int temp = i;
			for (int j = i + 1; j < in.length; j++) {
				if (in[temp] > in[j]) {
					temp = j;

				}
			}
			lowIndex = in[i];
			in[i] = in[temp];
			in[temp] = lowIndex;
			count++;
		}
		System.out.println("排序次数："+count);
		for (int i = 0; i < in.length; i++) {
			System.out.println(in[i]);
		}
	}

	/**
	 * 插入法排序(1-9)<br/>
	 * 基本思路：每拿到一个元素，都要将这个元素与所有它之前的元素遍历比较一遍，让符合排 序顺序的元素挨个移动到当前范围内它最应该出现的位置。
	 * 举个例子来说，就用前面的数组，我们要对一个有 5 个元素的数组进行升序排列，假设第 一个元素的值被假定为已排好序了，那么我们就将第 2
	 * 个元素与数组中的部分进行比较， 如果 第 2 个元素的值较小，则将它插入到第 1 个元素的前面，现在就有两个元素排好序了， 我们
	 * 再将没有排序的元素与排好序的元素列表进行比较，同样，如果小于第一个元素，就将 它插入
	 * 到第一个元素前面，但是，如果大于第一个元素的话，我们就将它再与第 2 个元素的 值进行比 较，小于的话就排在第 2 个元素前面，大于的话，就排在第
	 * 2 个元素的后面。以此类推，直到 最后一个元素排好序。
	 */
	public void testOpt2(int[] a) {

		int temp;
		for (int i = 1; i < a.length; i++) {
			// i=1开始，因为第一个元素认为 是已经排好序了的
			for (int j = i; (j > 0) && (a[j] < a[j - 1]); j--) {
				// 交换
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
		// 检测一下排序的结果
		for (int i : a) {
			System.out.println("i=" + i);
		}

	}

	/*******/
	/**
	 * @param args
	 */
	static boolean b;

	public static void main(String[] args) {
		Homework2 hw = new Homework2();
		Rodent[] rd = new Rodent[3];
		Mouse m = hw.new Mouse();
		Gerbil g = hw.new Gerbil();
		Hamster h = hw.new Hamster();
		rd[0] = m;
		rd[1] = g;
		rd[2] = h;
		System.out.println(rd[2].teeth("1"));
		Rodent r = new Rodent();

		// hw.go();
		// hw.StringBufferInsert();
		// hw.arrayTest();
		/*************/
		int[] in = { 11,9,7,4 };
//		int[] in = { 8, 4, 7, 3, 12, 6 };
		// hw.testOrder();
		// hw.testOpt();

		hw.testOpt2(in);
		/*************/
	}

}
