package org.dubbo.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.dubbo.inter.api.HelloService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */

public class DubboConsumerTest {

	private static ApplicationContext appConsumer = new ClassPathXmlApplicationContext("consumer.xml");
	public static void main(String[] args) {
		String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		HelloService hello = (HelloService) appConsumer.getBean(HelloService.class);
		String output = hello.hello("dubbo搞定。"+dateTime);
		System.out.println(output);
		System.out.println("consumer 启动成功。");
//		Scanner scanner = new Scanner(System.in);
//		scanner.nextLine();
	}


}