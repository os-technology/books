package org.dubbo.consumer;

import java.util.Scanner;

import org.dubbo.inter.api.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) {
		ApplicationContext appConsumer = new ClassPathXmlApplicationContext("consumer.xml");
		HelloService hello = (HelloService) appConsumer.getBean("hello");
		String output = hello.hello("加油，dubbo搞定。");
		System.out.println(output);
		System.out.println("consumer 启动成功。");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

}