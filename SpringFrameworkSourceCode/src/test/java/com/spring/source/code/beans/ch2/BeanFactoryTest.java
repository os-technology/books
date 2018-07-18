package com.spring.source.code.beans.ch2;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yuijnshui
 * @Title: BeanFactoryTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/14下午9:19
 */
public class BeanFactoryTest {

    /**
     * XmlBeanFactory 过期。从spring 3.2 后推荐使用DefaultListableBeanFactory和XmlBeanDefinitionReader来代替它。
     */
    @Test
    public void testSimpleLoad_3_2_x_old() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");

        String eqlVal = "myTestBean";
        myTestBean.setStr(eqlVal);
        Assert.assertEquals(eqlVal, myTestBean.getStr());
        System.out.println(this);

        Assert.assertNotNull("BeanAttr is null",myTestBean.getBeanAttr());
    }

    /**
     * xml文件新的读取方式
     *
     * @param
     * @return void
     * @author code
     * @date 2018/7/15 下午7:30
     */
    @Test
    public void testSimpleLoad_new() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        Resource resource = new ClassPathResource("beanFactoryTest.xml");
        new XmlBeanDefinitionReader(factory).loadBeanDefinitions(resource);

        MyTestBean myTestBean = (MyTestBean) factory.getBean("myTestBean");

        String eqlVal = "myTestBean";
        myTestBean.setStr(eqlVal);
        Assert.assertEquals(eqlVal, myTestBean.getStr());
        System.out.println(this);


    }

    /**
     *仅用来代表resource对象可以获取到inputstream信息，非测试内容
     * @author code
     * @date 2018/7/16 下午7:26
     * @param
     * @return void
     */
    @Test
    public void testInputStream() throws IOException {
        Resource resource = new ClassPathResource("beanFactoryTest.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);


    }
    /**
     * 可用于进行代码编写时进行的验证
     * @author code
     * @date 2018/7/16 下午7:27
     * @param
     * @return void
     */
    @Test
    public void testNotNull(){
        Assert.assertNotNull("String is null",null);
    }

}
