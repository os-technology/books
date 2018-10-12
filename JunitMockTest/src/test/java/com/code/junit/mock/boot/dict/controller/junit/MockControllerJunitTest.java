package com.code.junit.mock.boot.dict.controller.junit;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.app.JunitMockApplication;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.dict.controller.MockController;
import com.code.junit.mock.boot.dict.controller.MockControllerTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author code
 * @Title: MockControllerJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/12下午5:36
 */

@ContextConfiguration(locations = {"classpath:spring-mvc-test.xml",
        "classpath:application-bean-test.xml",
        "classpath:application-controller-test.xml"})
@MapperScan("com.code.junit.mock.boot.dict.dao")
@EnableTransactionManagement
@ComponentScan("com.code.junit.mock.boot")

//替代@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@Transactional(transactionManager="transactionManager")
@Rollback(value = true)
@SpringBootTest

public class MockControllerJunitTest extends AbstractTransactionalJUnit4SpringContextTests {

    MockHttpSession session;//5 注入可模拟的HTTPSession，此处仅用作演示
    MockHttpServletRequest request;//6 可注入模拟的http Request，没有使用
    MockHttpServletResponse response;

    @Before
    public void setUp() throws Exception {

        this.session = new MockHttpSession();
        this.request = new MockHttpServletRequest();
        this.response = new MockHttpServletResponse();

    }

    @Test
    public void modelAndView(){
        String jsonMockTable = "{\"createTime\":"+System.currentTimeMillis()+",\"data\":\"test-20180902-13:36\",\"name\":\"mock\"}";

        MockTable mockTable = JSON.parseObject(jsonMockTable, MockTable.class);

        MockController mockController = this.applicationContext.getBean(MockController.class);
        ModelAndView modelAndView = mockController.modelAndView(mockTable);
        Object object = modelAndView.getModel().get("result");
        if(object instanceof MockTable){
            MockTable mockTableResponse = (MockTable)object;
            Assert.assertNotNull(mockTable.getId());
        }else{
            Assert.assertTrue(false);
        }

    }
}
