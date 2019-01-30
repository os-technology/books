package org.dubbo.provider.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = "org.dubbo.provider")
@ImportResource(locations = {"classpath:provider.xml"})
public class DubboProviderMain {

    public static void main(String[] args) {
        springStart(args);
//        dubboStart(args);
    }

    private static void springStart(String[] args) {
        SpringApplication.run(DubboProviderMain.class, args);

        System.out.println("dubbo-provider is started.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 不需要spring部分的注解
     *
     * @param args
     */
    private static void dubboStart(String[] args) {
        ClassPathXmlApplicationContext
                context = new ClassPathXmlApplicationContext("provider.xml");
        com.alibaba.dubbo.container.Main.main(args);
        System.out.println("dubbo-provider is started.");
    }
}
