package org.dubbo.provider.service.impl;

import java.util.Scanner;

import org.dubbo.inter.api.HelloService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceImplTest {
	@Autowired
	private HelloService hello;
	static ApplicationContext app = new ClassPathXmlApplicationContext("provider.xml");
	public static void main(String[] args) {
		
		System.out.println("provider[hello]已启动.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	@Test
	public void testgetToday() {
		hello = (HelloService)app.getBean("hello");
		String dateTime = hello.getToday();
		System.out.println(dateTime);
	}

}
