package com.code.junit.mock.boot.dict.controller;

import com.code.junit.mock.boot.app.JunitMockApplication;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.util.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
//如果不添加 JunitMockApplication 类，则需要继承单元测试父类，以保证数据库部分可以被正常访问。若有启动类，尽量添加启动类方式操作
@SpringBootTest(classes = {JunitMockApplication.class, MockControllerTest.class})
@Transactional(transactionManager = "transactionManager")
@Rollback(value = true)
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
    public void addMock() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/addMock");


        mockMvc.perform(addMockTable(request))
                .andExpect(status().isOk())
                .andExpect(content().string("addMock is ok"));

    }

    private MockHttpServletRequestBuilder addMockTable(MockHttpServletRequestBuilder request) {

        String name = "time " + DateUtils.dateToString("yyyy-MM-dd HH:mm");
        System.out.println(name.length());
        return request.param("name", name)
                .param("data", "random");
    }

    @Test
    public void getModelAndView() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/getModelAndView");

        ResultActions response = mockMvc.perform(addMockTable(request));

        response.andExpect(status().isOk())
                .andExpect(model().attributeExists("result"))
                .andDo(MockMvcResultHandlers.print());

        //获取返回结果的对象信息
        ModelAndView modelAndView = response.andReturn().getModelAndView();
        Object object = modelAndView.getModel().get("result");
        if(object instanceof MockTable){
            MockTable mockTable = (MockTable)object;
            Assert.assertNotNull(mockTable.getId());
        }
    }
}
