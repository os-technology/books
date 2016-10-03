package org.dubbo.provider.service.impl;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceImplTest {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("provider.xml");
		System.out.println("provider[hello]已启动.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}
