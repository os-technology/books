package com.springcloud.eureka.client;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author code
 * @Title: AppJunitConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/23上午11:30
 */
@RunWith(SpringRunner.class)
//@WebAppConfiguration//1 该注解用来声明加载的ApplicationContext是一个WebApplicationContext。
//@ContextConfiguration
//@WebAppConfiguration("src/main/resources")//1 该注解用来声明加载的ApplicationContext是一个WebApplicationContext。
public class AppJunitConfig {
    protected MockMvc mockMvc;//2 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化

    @Autowired
    WebApplicationContext wac;//4 注入WebApplicationContext

//    @Autowired
//    MockHttpSession session;//5 注入可模拟的HTTPSession，此处仅用作演示
//    @Autowired
//    MockHttpServletRequest request;//6 可注入模拟的http Request，没有使用

    @Before
    public void setUp() {
        //2 MockMvc-模拟MVC对象，通过MockMvcBuilders.webAppContextSetup（ this.wac）.build（）初始化。
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
}
