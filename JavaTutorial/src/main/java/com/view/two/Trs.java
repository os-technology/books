package com.view.two;

import com.view.Normal;

//拓尔思复试题
public class Trs extends Normal {
	public void A_1() {
	}

	// 验证输出结果
	public void A_2() {
		A a = new A();
		a.go();
		A a1 = new B();
		a1.go();
	}

	public void A_3() {
		String[] s = new String[5];
		for(int i=0;i<s.length;i++){
			System.out.println("s[i] is "+s[i]+" and length is "+s.length);
		}
	}

	public void A_4() {
	}

	public void A_5() {
	}

	public void A_6() {
	}

	public void A_7() {
	}

	public void A_8() {
	}

	public void A_9() {
	}

	public void A_10() {
	}

	public static void main(String[] args) {
		Trs t = new Trs();
		 t.A_3();

	}

}

class A {
	void go() {
		System.out.println("A");
	}
}

class B extends A {
	void go() {
		System.out.println("B");
	}
}