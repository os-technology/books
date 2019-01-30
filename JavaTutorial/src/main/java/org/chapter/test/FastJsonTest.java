package org.chapter.test;

import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public class FastJsonTest {

	public void test1(){
		F2 f = new F2();
		f.setA("a");
		f.setB("b");
		f.setC("c");
		String out = JSON.toJSONString(f);
		System.out.println(out);
		F2 out2 = JSON.parseObject(out, F2.class);
		System.out.println(out2);
	}
	public static void showTime(){
		System.out.println(new Date().getTime()/1000);
	}
	public static void main(String[] args) {
		 Map<String, String> map = System.getenv();
		 for( Entry<String, String> m:map.entrySet()){
			System.out.println(m.getKey()+" - "+m.getValue());
		 }
		
		System.out.println();
	}

}
