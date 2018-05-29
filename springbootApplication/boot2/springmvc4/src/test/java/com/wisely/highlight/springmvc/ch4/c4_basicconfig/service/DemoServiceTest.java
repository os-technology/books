package com.wisely.highlight.springmvc.ch4.c4_basicconfig.service;

import com.wisely.highlight.springmvc.ch4.MyMvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoServiceTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/28下午3:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")//1 该注解用来声明加载的ApplicationContext是一个WebApplicationContext。
public class DemoServiceTest {

    private MockMvc mockMvc;//2 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化

    @Autowired
    private DemoService demoService;//3 可以在测试用例中注入spring的bean
    @Autowired
    WebApplicationContext wac;//4注入WebApplicationContext

    @Autowired
    MockHttpSession session;//5 注入可模拟的HTTPSession，此处仅用作演示
    @Autowired
    MockHttpServletRequest request;//6 可注入模拟的http Request，没有使用


    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();//2
    }
    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/normal"))//8 模拟向/normal进行get请求。
                .andExpect(status().isOk())//9预期控制返回状态为200
                .andExpect(view().name("page"))//10 预期view的名称为page

                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))//11预期页面转向的真正路径为/WEBINF/classes/views/page.jsp
                .andExpect(model().attribute("msg",demoService.saySomething("mockTest")));//12
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest"))//13 模拟向/testRest进行get请求
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))//14 预期返回值的媒体类型为text/plain； charset=UTF-8
        .andExpect(content().string(demoService.saySomething("testRestController")));//15
    }

}
