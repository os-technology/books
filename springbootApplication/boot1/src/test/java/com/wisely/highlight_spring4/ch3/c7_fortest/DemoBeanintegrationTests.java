package com.wisely.highlight_spring4.ch3.c7_fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Target;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoBeanintegrationTests
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/18上午10:42
 */
@RunWith(SpringJUnit4ClassRunner.class)//SpringJUnit4ClassRunner在Junit环境下提供Spring TestContext Framework 的功能。
@ContextConfiguration(classes = TestConfig.class)//@ContextConfiguration用来加载配置ApplicationContext,其中classes属性用来加载配置类
@ActiveProfiles("dev")//
public class DemoBeanintegrationTests {
    @Autowired
    private TestBean testBean;

    @Test
    public void devBeanShouldInject(){
        String expected = "from dev profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected,actual);
    }



}
