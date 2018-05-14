package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.stereotype.Service;

//1
public class FunctionService {
	
	public String sayHello(String word){
		return "Hello " + word +" !"; 
	}


}
