package org.chapter.test;

public class AFather {
	AFather(){
		System.out.println("AParent");
	}
	{
		System.out.println("块 AParent");
	}
	static{
		System.out.println("static AParent");
	}
	AFather(int i){
		System.out.println("a");
	}

}
