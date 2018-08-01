package com.spring.source.code.beans.ch2.constructor_arg;

import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuijnshui
 * @Title: ConstructorArgJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/24下午4:39
 */
public class ConstructorArgJunitTest extends BaseJunitTest {

    @Test
    public void constructorDoubleParamTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("constructorArgTest.xml");
        ConstructorBean cb = (ConstructorBean)ac.getBean("constructorBean");
        Assert.assertTrue((cb instanceof ConstructorBean));
    }

    @Test
    public void constructorSingleParamTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("constructorArgTest.xml");
        ConstructorBean cb = (ConstructorBean)ac.getBean("constructorSingleBean");
        Assert.assertTrue((cb instanceof ConstructorBean));
    }
}
