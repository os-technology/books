package org.chapter.databasic.interview;

public class ImpClass extends Base {
private String in = "hello";
	@Override
	void preProcess(){
		in = "world";
	}
	public static void main(String[] args) {
		ImpClass imp =new ImpClass();
//		System.out.println(imp.in);
	}
}
