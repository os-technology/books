package org.dubbo.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.dubbo.inter.api.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */

public class DubboConsumerTest {
    DubboConsumerConfig consumerConfig;

    DubboProxyFactory dubbo ;
    @Before
	public void init(){
         consumerConfig = new DubboConsumerConfig();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
//        application.setName("payment-remote");
        application.setName("dubbo_hello");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        //dev
        String zookeeper_address_dev="zookeeper://127.0.0.1:2181?backup=127.0.0.1:2182,127.0.0.1:2183";
        registry.setAddress(zookeeper_address_dev);

         dubbo = new DubboProxyFactory(application,registry);



    }

    @Test
    public void consumer(){

//        HelloService helloService = (HelloService)dubbo.create(HelloService.class, "1.0.0");

        HelloService helloService = consumerConfig.getConsumer(HelloService.class);
        System.out.println("时间信息："+helloService.getToday());

    }

    private static ApplicationContext appConsumer = new ClassPathXmlApplicationContext("consumer.xml");

    public static void main(String[] args) {
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        HelloService hello = (HelloService) appConsumer.getBean(HelloService.class);
        String output = hello.hello("dubbo搞定。" + dateTime);
        System.out.println(output);
        System.out.println("consumer 启动成功。");
//		Scanner scanner = new Scanner(System.in);
//		scanner.nextLine();
    }


}