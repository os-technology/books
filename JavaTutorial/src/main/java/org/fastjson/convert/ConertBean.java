package org.fastjson.convert;

import org.fastjson.bean.Apple;

import com.alibaba.fastjson.JSON;

public class ConertBean {

	
	private static String convert(){
		Apple app = new Apple();
		app.setColor_1("red");
		app.setPlace("山东");
		app.setShape_1("圆形");
		app.setSize_1(10);
		
		return JSON.toJSONString(app); 
	}
	 private static <T> T convertResultData(String result, Class<T> clazz) {
	       
	        T t = null;
	        try {
	            t = JSON.parseObject(result, clazz);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return t;
	    }
	
	public static void main(String[] args) {
//		String result = convert();
//		System.out.println(result);
		String text = "{\"color_1\":\"red\"}";
		Apple ap = convertResultData(text,Apple.class);
//		Apple ap = JSON.parseObject(text, Apple.class);
		System.out.println(JSON.toJSONString(ap));
	}

}
