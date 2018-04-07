package basic.tutorial.practice;

public class Employer {
	String name;

	public Employer(String n) {
		name = n;
	}
	public Employer(){
		
	}
	
	public static void main(String[] args){
		String s=  "1";
		String d = "2";
		Manager m = new Manager(s, d);
		Employer e1 = new Manager(s,d);
		Employer e = new Contractor();
		Employer e2 = new Employer();
		Employer k = (Employer)m;
		m.test(e);
		new Manager(s, d).test(e);
	}
	
}

class Manager extends Employer {
	String department;

	public Manager(String s, String d) {
		 // 调用父类参数为 String 类型的构造方法，没有这句话，编译会出错（每个类都有个隐式的构造函数，如果没有的话，继承该类就必须调用他的其他构造函数	）
		super(s);
		department = d;
	}
	
	public void test(Employer e){
		if(e instanceof Manager){
			System.out.println("该对象是Manager");
		}
//		if(e instanceof Employer){
//			System.out.println("该对象是Employer");
//		}
		if(e instanceof Contractor){
			System.out.println("该对象是Contractor");
		}
	}
	
	
}

class Contractor extends Employer{
	
	
	public static void main(String[] args){
		System.out.println("Contractor is running!");
	}
}


