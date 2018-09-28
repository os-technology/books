package com.spring.source.code.beans.ch5.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 激活Aware方法
 * 在分析其原理之前，我们先了解一下Aware 的使用。Spring中提供一些Aware相关接口，
 * 比如BeanFactoryAware、ApplicationContextAware、ResourceLoaderAware、 ServletContextAware等，
 * 实现这些Aware接口的bean在被初始之后，可以取得一~些相对应的资源，例如实现BeanFactoryAware的bean 在初始后，
 * Spring容器将会注人BeanFactory 的实例，而实现ApplicationContextAware的bean,在bean被初始后，将会被注入
 * ApplicationContext的实例等。我们首先通过示例方法来了解一下Aware的使用。
 *
 * @author code
 * @Title: BeanAwareTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/28下午3:11
 */
public class BeanAwareTest implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware() {
        HelloAware helloAware = (HelloAware) beanFactory.getBean("helloAware");
        helloAware.say();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch5/BeanFactoryAware.xml");
        BeanAwareTest beanAwareTest = (BeanAwareTest) ctx.getBean("beanAwareTest");
        beanAwareTest.testAware();
    }
}
/**
 *按照上面的方法我们可以获取到Spring中的BeanFactory，并且可以根据BeanFactory获取所有bean，以及进行相关设置。当然还有其他Aware
 * 的使用方法都大同小异
 */