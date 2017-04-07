package org.genericity;

import com.alibaba.fastjson.JSON;

public class GenericityUtil<T> {

	public static <T> T getObject(String json,Class clazz){
		return (T)JSON.parseObject(json, clazz);
	}
}
