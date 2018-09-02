package com.code.junit.mock.boot.dict.service;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.dict.dao.MockTableDAO;
import com.code.junit.mock.boot.dict.service.impl.MockServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * 所有mock测试需要提前准备数据信息
 *
 * @author code
 * @Title: MockServiceMockTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午2:10
 */
@RunWith(MockitoJUnitRunner.class)
public class MockServiceMockTest extends BaseAppTest {
    /**
     * @Mock: 创建一个Mock.
     * @InjectMocks: 创建一个实例，其余用@Mock（或@Spy）注解创建的mock将被注入到用该实例中。
     * 注意：必须使用@RunWith(MockitoJUnitRunner.class) 或 Mockito.initMocks(this)进行mocks的初始化和注入。
     */
    @InjectMocks //此处该注解只能用于实现类，不可用于接口
    private MockServiceImpl mockService;

    @Mock
    private MockTableDAO mockTableDAO;

    @Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save(){
        String jsonMockTable = "{\"createTime\":1535866590000,\"data\":\"test-20180902-13:36\",\"id\":21,\"name\":\"mock\"}";

        MockTable mockTable = JSON.parseObject(jsonMockTable,MockTable.class);

        //数据库不存在该数据的逻辑顺序
        Mockito.when(mockTableDAO.selectById(mockTable.getId())).thenReturn(null);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                MockTable mockTableAnswer = (MockTable) invocationOnMock.getArguments()[0];
                System.out.println("=======================分割线=======================");
                Assert.assertTrue("new Data".equals(mockTableAnswer.getName()));
                return null;
            }
        }).when(mockTableDAO).save(Mockito.any(MockTable.class));

        mockService.add(mockTable);

        //数据库已存在该数据的逻辑顺序
        Mockito.when(mockTableDAO.selectById(mockTable.getId())).thenReturn(mockTable);
        mockService.add(mockTable);
    }
}
