package basic.tutorial.practice;

public class ClassTest {

	private String s1 = "初始化无形参";
	private String s2 = "初始化包含形参:";
	String name = "";
	int height = 0;
	String color = "";
	int year = 0;

	public ClassTest(String info) {
		System.out.println(s2 + info);
		name = "dog"+ info;
		height = 30;
		color = "white"+ info;
		year = 4;

	}

	public ClassTest() {
		System.out.println(s1);
		name = "cat";
		color = "black";
		height = 20;
		year = 2;
	}

	final int i=0;
	private void test(){
		
	}
	public static void main(String[] args) {
		ClassTest c = new ClassTest();
		 
		// System.out.println(c);
		System.out.println(c.color);
		
		ClassTest cl = new ClassTest(",hello");
		System.out.println(cl.color);
		

	}

}
