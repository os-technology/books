package com.spring.source.code.beans.ch2.replaced_method;

import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuijnshui
 * @Title: MethodReplacerJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/23下午6:14
 */
public class MethodReplacerJunitTest extends BaseJunitTest {

    @Test
    public void testChangeMe() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("replaceMethodTest_local.xml");
        TestChangeMethod tcm = (TestChangeMethod) ac.getBean("testChangeMethod");
        String input = "replace method";
        String output = tcm.changeMe(input);
        System.out.println(output);
        Assert.assertEquals(output, input + " is ok");

    }



}
