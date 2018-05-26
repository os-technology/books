package org.dubbo.provider.boot;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProviderMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext
                context = new ClassPathXmlApplicationContext("provider.xml");
//        app.start();
//        System.out.println("provider is started!");
//        try {
//            Thread.sleep(100000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        com.alibaba.dubbo.container.Main.main(args);
    }
}
