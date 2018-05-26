package org.dubbo.consumer;

import java.util.Scanner;

import org.dubbo.inter.api.HelloService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */

public class AppTest {

	private static ApplicationContext appConsumer = new ClassPathXmlApplicationContext("consumer.xml");
//	@Autowired
//	private static HelloService hello;
	public static void main(String[] args) {

		HelloService hello = (HelloService) appConsumer.getBean(HelloService.class);
		String output = hello.hello("dubbo搞定。");
		System.out.println(output);
		System.out.println("consumer 启动成功。");
//		Scanner scanner = new Scanner(System.in);
//		scanner.nextLine();
	}


}