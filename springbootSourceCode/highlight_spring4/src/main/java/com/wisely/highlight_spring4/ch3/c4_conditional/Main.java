package com.wisely.highlight_spring4.ch3.c4_conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConditionConifg.class);
		
		ListService listService = context.getBean(ListService.class);
		
		
		System.out.println(context.getEnvironment().getProperty("os.name") 
				+ "ϵͳ�µ��б�����Ϊ: " 
				+ listService.showListCmd());
		
		context.close();
	}
}
