package com.code.junit.mock.boot.dict.service;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.dict.dao.MockTableDAO;
import com.code.junit.mock.boot.dict.service.impl.MockServiceImpl;
import com.code.junit.mock.boot.exceptions.ObjectNullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

import static org.hamcrest.Matchers.is;

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
//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(MockServiceImpl.class)
public class MockServiceMockTest {


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
        //表示对该service实例进行监控，保证需要mock的全部方法可以返回指定结果
        mockService = PowerMockito.spy(mockService);
    }

    /**
     * 测试方法内部new出来的对象
     *
     * @throws Exception
     */
    @Test
    public void innerObjectCreate() throws Exception {
        File file = PowerMockito.mock(File.class);

        PowerMockito.whenNew(File.class).withArguments(Mockito.anyString()).thenReturn(file);
        PowerMockito.when(file.exists()).thenReturn(true);

        boolean result = mockService.callInternalInstance("bbb");
        Assert.assertTrue(result);
    }


    /**
     * 私有方法测试 之 json转换结果异常抛出
     */
    @Test
    public void privateAndProtectedMethod_PrivateMethod() throws Exception {
        String jsonMockTable = "{\"createTime\":1535866590000,\"data\":\"test-20180902-13:36\",\"id\":21,\"name\":\"mock\"}";

        MockTable mockTable = JSON.parseObject(jsonMockTable, MockTable.class);

        //这三种写法效果在此是一样的
        //传入任何符合条件的对象类型是MockTable的参数即可
        PowerMockito.when(mockService, "convertJson", Mockito.any(MockTable.class)).thenReturn("");
        //执行 convertJson 方法后，需要返回 空字符串
//        PowerMockito.when(mockService, "convertJson", mockTable).thenReturn("");
        //当要执行 convertJson 方法时，直接返回 空字符串
//        PowerMockito.doReturn("").when(mockService, "convertJson", mockTable);
        try {
            mockService.privateAndProtectedMethod(mockTable);
        } catch (Exception e) {
            Assert.assertTrue("json is null".equals(e.getMessage()));
        }
    }

    @Test
    public void privateAndProtectedMethod_protectAndDoAnswerMethod() throws Exception {
        String jsonMockTable = "{\"createTime\":1535866590000,\"data\":\"test-20180902-13:36\",\"id\":21,\"name\":\"mock\"}";
        String jsonMockTable2 = "{\"createTime\":1535866590000,\"data\":\"test-20180902-13:36\",\"id\":100,\"name\":\"mock\"}";

        MockTable mockTable = JSON.parseObject(jsonMockTable, MockTable.class);
        MockTable mockTable2 = JSON.parseObject(jsonMockTable2, MockTable.class);

        PowerMockito.when(mockService, "converMockTable", jsonMockTable).thenReturn(mockTable2);


        PowerMockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                MockTable actualObject = (MockTable) invocation.getArguments()[0];
                Assert.assertTrue(mockTable2.getId() == actualObject.getId());
                return null;
            }
        }).when(mockService, "printObject", Mockito.any(MockTable.class));
        try {
            mockService.privateAndProtectedMethod(mockTable);
        } catch (Exception e) {
            Assert.assertTrue("json is null".equals(e.getMessage()));
        }
    }




    @Test
    public void save() {
        String jsonMockTable = "{\"createTime\":1535866590000,\"data\":\"test-20180902-13:36\",\"id\":21,\"name\":\"mock\"}";

        MockTable mockTable = JSON.parseObject(jsonMockTable, MockTable.class);

        //数据库不存在该数据的逻辑顺序
        Mockito.when(mockTableDAO.selectById(mockTable.getId())).thenReturn(null);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) {
                MockTable mockTableAnswer = (MockTable) invocationOnMock.getArguments()[0];
                System.out.println("=======================分割线=======================");
                Assert.assertTrue(mockTable.getName().equals(mockTableAnswer.getName()));
                return null;
            }
        }).when(mockTableDAO).save(Mockito.any(MockTable.class));

        mockService.saveWithoutSameId(mockTable);

        //数据库已存在该数据的逻辑顺序
        Mockito.when(mockTableDAO.selectById(mockTable.getId())).thenReturn(mockTable);
        mockService.saveWithoutSameId(mockTable);
    }
}
