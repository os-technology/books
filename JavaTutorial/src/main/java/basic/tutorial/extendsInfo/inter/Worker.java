package basic.tutorial.extendsInfo.inter;

public class Worker implements Employee{

	public static void main(String[] args) {
		Worker w = new Worker();
		Employee e = (Employee)w;
		e.job();

	}

	@Override
	public void job() {
		System.out.println("我是员工");
		
	}

}
