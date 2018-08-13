package com.spring.source.code.beans.ch4.define.xsd;

import com.log.LogPortal;
import com.spring.source.code.beans.BaseJunitTest;
import com.spring.source.code.beans.ch4.UserXsd;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuijnshui
 * @Title: XsdDefineMarkJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/7上午11:28
 */
public class XsdDefineMarkJunitTest extends BaseJunitTest {

    @Test
    public void testXsdDefineMark(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ch4/xsdDefineMarkTest.xml");
        UserXsd userXsd = (UserXsd) context.getBean("userXsdBean");
        LogPortal.info("test",userXsd);
        Assert.assertEquals(userXsd.getEmail(),"aaa");
    }
}
