package org.chapter.test;

import com.alibaba.fastjson.JSON;

public class FastJsonTest {

	public static void main(String[] args) {
		F2 f = new F2();
		f.setA("a");
		f.setB("b");
		f.setC("c");
		String out = JSON.toJSONString(f);
		System.out.println(out);
		F2 out2 = JSON.parseObject(out, F2.class);
		System.out.println(out2);
	}

}
