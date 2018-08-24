package com.springcloud.eureka.client.dict;

import com.springcloud.eureka.client.AppJunitConfig;
import com.springcloud.eureka.client.app.EurekaClientApplication;
import com.springcloud.eureka.client.beans.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author code
 * @Title: EurekaClientForJunitControllerTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/23上午11:29
 */

@SpringBootTest(classes = {EurekaClientApplication.class, EurekaClientForJunitControllerTest.class})
public class EurekaClientForJunitControllerTest extends AppJunitConfig {
    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 无参调用
     *
     * @throws Exception
     */
    @Test
    public void testHello() throws Exception {
        RequestBuilder request = get("/hello");
        mockMvc.perform(request)//对指定URL和参数发起请求
                .andExpect(status().isOk())//HTTP返回状态码验证
                .andExpect(content().string("Hello world"));//参数结果验证
    }

    /**
     * 无参调用
     *
     * @throws Exception
     */
    @Test
    public void testDiscoveryClient() throws Exception {
        RequestBuilder request = get("/findClient");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(discoveryClient.getServices())));
    }


    /**
     * 字符串传参方式测试
     *
     * @throws Exception
     */
    @Test
    public void string() throws Exception {
        String param = "String参数测试，类似于异步回调传参方式";
        RequestBuilder request = get("/string")
                .content(param);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(param));
    }

    /**
     * 对象方式传参
     *
     * @throws Exception
     */
    @Test
    public void defineParam() throws Exception {
        String param1 = "1";
        String param2 = "张三";
        RequestBuilder request = get("/defineParam")
                .param("id", param1).param("name", param2)
                .accept(MediaType.APPLICATION_JSON);//加不加数据类型都可以成功
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(param1 + param2));
    }

    /**
     * 指定参数格式为json
     *
     * @throws Exception
     */
    @Test
    public void json() throws Exception {

        RequestBuilder request = get("/json")
                .param("id", "1").param("name", "user")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success")).andDo(MockMvcResultHandlers.print());
    }


    @InjectMocks
    private EurekaClientForJunitController eurekaClientForJunitController;

    /**
     * ModelAndView方式测试
     *
     * @throws Exception
     */
    @Test
    public void getModelAndViewUser() throws Exception {
        setModelAndView();
        User user = null;

        RequestBuilder request = get("/getModelAndViewUser")
                .param("id", "1").param("name", "user");
        ResultActions response = mockMvc.perform(request);


        response.andExpect(status().isOk())

                .andExpect(model().attributeExists("result"))
                .andDo(MockMvcResultHandlers.print());

        //获取返回结果的对象信息
        ModelAndView modelAndView = response.andReturn().getModelAndView();
        Object u = modelAndView.getModel().get("result");

        Assert.assertTrue(u instanceof User);
        if (u instanceof User) {
            user = (User) u;
        }
        System.out.println("user 对象数据信息 :user.id=" + user.getId() + " user.name=" + user.getName());

    }

    /**
     * 重新配置视图解析器
     */
    private void setModelAndView() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //在test中重新配置视图解析器
        resolver.setPrefix("/WEB_INF/views");
        resolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(eurekaClientForJunitController).setViewResolvers(resolver).build();

    }
}
