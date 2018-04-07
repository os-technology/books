package com.view.temp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	
	public void getRes(String s){
		
	}
	public String getRes(int s){
		return null;
		
	}
	
	public void MapTest(){
		Map map = new HashMap();
		map.put("a0", "10");
		map.put("a1", "11");
		map.put("a2", "12");
		map.put("a3", "13");
		
		
		for(Object o:map.keySet()){
			
			System.out.println("1 key is "+o +" and value is "+map.get(o));
		}
		
		Set set = map.entrySet();
		Iterator ator = set.iterator();
		while(ator.hasNext()){
			 Map.Entry<Object, Object> res = (Entry<Object, Object>) ator.next();
			System.out.println("2 key is "+res.getKey()+" and value is "+res.getValue());

		}
		

		for(Object o:map.entrySet()){
			Entry<Object, Object> res = (Map.Entry<Object, Object>)o;
			System.out.println("3 key is "+res.getKey()+" value is "+res.getValue());
		}
		
		for(Object o:map.values()){
			System.out.println("4 value is "+o);
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		t = null;
		t.MapTest();
	}

}
