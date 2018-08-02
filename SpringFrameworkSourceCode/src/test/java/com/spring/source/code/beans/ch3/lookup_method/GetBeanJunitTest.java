package com.spring.source.code.beans.ch3.lookup_method;

import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuijnshui
 * @Title: GetBeanJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/23下午4:31
 */
public class GetBeanJunitTest  extends BaseJunitTest {

    @Test
    public void lookupGetBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("lookupTest.xml");
        GetBeanTest getBeanTest = (GetBeanTest)ac.getBean("getBeanTest");
        getBeanTest.showMe();
    }
}
