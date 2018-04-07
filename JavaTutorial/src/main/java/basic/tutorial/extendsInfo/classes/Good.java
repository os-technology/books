package basic.tutorial.extendsInfo.classes;

public class Good extends Human {

	public void attribute(){
		System.out.println("我是 Good");
	}
	
	public static void main(String[] args) {
		Good g = new Good();
		Human h = (Human)g;
		h.attribute();

	}

}
