package org.dubbo.provider.boot;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	 static ApplicationContext app = new ClassPathXmlApplicationContext("provider.xml");

	public static void main(String[] args) {
		System.out.println("provider[hello]已启动.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}
