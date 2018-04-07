package com.view.one;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class A {
	/**
	 * ⑴⑵⑶⑷⑸⑹⑺⑻ old:原内容<br>
	 * new：新内容或修改后的正确内容
	 */

	public void A_1() {
		float f = 1.3f;// 原内容：float f = 1.3;
		char c = 'a';// 原内容：char c="a"
		byte b = (byte) 257;// 若不强转，报错
		boolean b1 = (Boolean) null;// 若不强转，则报错
		int i = 10;
	}

	public void A_2(String args[]) {
		System.out.println(args);
		System.out.println(args[1]);
	}

	public void A_4() {
		int i = 1;
		switch (i) {
		case 0:
			System.out.println("zero");
			break;
		case 1:
			System.out.println("one");
		case 2:
			System.out.println("two");
		default:
			System.out.println("default");

		}
	}

	public void A_5() {
		// 1------------
		// int i=0;
		// if(i){//java中if条件只能是boolean结果值，不可为非零或者0
		// System.out.println("Hello");
		// }

		// 2------------
		boolean b = true;
		boolean b2 = true;
		if (b == b2) {
			System.out.println("So true");
		}
		// 3------------
		int i = 1;
		int j = 2;
		if (i == 1 || j == 2) {
			System.out.println("OK");
		}
		// 4------------
		// int m = 1;
		// int n = 2;
		// if(m==1&|n==2){
		// System.out.println("OK");
		// }

	}

	// ⑴⑵⑶⑷⑸⑹⑺⑻
	public void A_6() {
		System.out.println(-1 >>> 2);// ⑴//will output a result larger than 10
		System.out.println(-1 >>> 2);// ⑵//will output a positive number
		System.out.println(2 >> 1);// ⑶ //will output the number 1
		// System.out.println(1<<<2);//⑷报错//will output the number 4
	}

	public void A_8() {
		int i;
		int j;
		outer: for (i = 1; i < 3; i++) {
			inner: for (j = 1; j < 3; j++) {
				if (j == 2)
					continue outer;
				System.out.println("Value for i=" + i + "Value for j=" + j);
			}
		}
	}

	// map遍历的四种方法
	public void MapList() {
		Map map = new HashMap();
		map.put("a", "11");
		map.put("b", "12");
		map.put("c", "13");
		map.put("d", "14");

		// 第一种：普遍使用，二次取值
		System.out.println("1.通过Map.keySet遍历key和value：");
		// key类型随map的key变化【Map<String, String> map = new HashMap<String,
		// String>();】
		for (Object key : map.keySet()) {
			System.out.println("key=" + key + "  value=" + map.get(key));

		}
		//第二种
		System.out.println("2.通过Map.entrySet使用iterator遍历key和value：");
		Set set = map.entrySet();
		Iterator s = set.iterator();
		Map.Entry<Object, Object> val = null;
		while (s.hasNext()) {
			val = (Entry<Object, Object>) s.next();
			System.out.println(val.getKey() + " -  " + val.getValue());
		}

		// 第三种：推荐，尤其是容量大时
		System.out.println("3.通过Map.entrySet遍历key和value");
		for (Object info : map.entrySet()) {
			Map.Entry<Object, Object> in = (Map.Entry<Object, Object>) info;
			System.out.println("key=" + in.getKey() + "  value="
					+ in.getValue());

		}

		// 第四种
		System.out.println("4.通过Map.values()遍历所有的value，但不能遍历key");
		for (Object res : map.values()) {
			System.out.println("value = " + res.toString());
		}

	}

	public static void main(String[] args) {
		A a = new A();
		// A_2(args);
		// a.A_4();
		// a.A_8();
		a.MapList();
	}

}

class A_10 {
	public void amethod(int i) {

	}
}

class A_10_10 extends A_10 {
	public static void main(String[] args) {

	}
	// ⑴错//void amethod(int i) throws Exception{}
	// ⑵对//void amethod(long i) throws Exception{}
	// ⑶ 对//void amethod(long i){}
	// ⑷错//public void amethod(int i) throws Exception{}
}
