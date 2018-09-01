package com.code.junit.mock.boot.dict.controller;

import com.code.junit.mock.boot.app.JunitMockApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * controller层其他详细单元测试参考：
 * https://github.com/os-technology/books/tree/dev/springcloud/eureka-client
 *
 * @author code
 * @Title: MockControllerTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午10:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JunitMockApplication.class, MockControllerTest.class})
//@WebAppConfiguration("src/main/resources")//1 该注解用来声明加载的ApplicationContext是一个WebApplicationContext。
public class MockControllerTest {
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

    /**
     * 无参请求
     *
     * @throws Exception
     */
    @Test
    public void index() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/index");//被调用接口地址
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("index is success"));
    }

    @Test
    public void params() {

    }

}
