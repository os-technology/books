package com.spring.source.code.beans.ch5;

import com.alibaba.fastjson.JSON;
import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author code
 * @Title: CarFactoryBeanTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/13上午11:33
 */
public class CarFactoryBeanTest  extends BaseJunitTest {

    @Test
    public void carInfo(){
        DefaultListableBeanFactory factory = getDefaultListableBeanFactory("ch5/DefineFactoryBean.xml");
        //通过反射机制发现CarFactoryBean实现了FactoryBean的接口，这时Spring容器就调用接口方法CarFactoryBean#getObject()方法返回。
        //如果希望获取CarFactoryBean的实例，则需要在使用getBean(beanName)方法时在beanName前显示的加上"&"前缀，例如getBean("&car")。
        Car car = (Car) factory.getBean("car");
        System.out.println(JSON.toJSONString(car));
        Assert.assertNotNull(car);
        //获取CarFactoryBean的实例
        Object carfactoryBean = factory.getBean("&car");
        System.out.println(JSON.toJSONString(carfactoryBean));
        Assert.assertTrue(carfactoryBean instanceof CarFactoryBean);
    }
}
