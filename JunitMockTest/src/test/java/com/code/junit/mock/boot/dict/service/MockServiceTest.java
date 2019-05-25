package com.code.junit.mock.boot.dict.service;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.exceptions.ObjectNullException;
import com.code.junit.mock.boot.util.DateUtils;
import com.code.junit.mock.boot.util.LogPortal;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;

/**
 * @author code
 * @Title: MockServiceTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午1:32
 */
@RunWith(SpringRunner.class)
public class MockServiceTest extends BaseAppTest {

    @Autowired
    private MockService mockService;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getPageList(){
        PageInfo<MockTable> result = mockService.getPageList(1, 3, null);
        Assert.assertNotNull(result.getSize()==3);

        result = mockService.getPageList(1, 3, getCondition());
        Assert.assertNotNull(result.getSize()==2);
    }

    private MockTable getCondition() {
        MockTable table = new MockTable();
        table.setData("test1");
        return table;
    }

    @Test
    public void add() {
        MockTable data = mockService.saveWithoutSameId(getMockTable());
        Assert.assertNotNull(data);
    }

    @Test
    public void privateAndProtectedMethod_Exception() throws ObjectNullException {

        thrown.expect(ObjectNullException.class);
        mockService.privateAndProtectedMethod(null);
    }

    @Test
    public void privateAndProtectedMethod_TryException() {

        try {
            mockService.privateAndProtectedMethod(null);
        } catch (ObjectNullException e) {
            Assert.assertThat(e.getMessage(), is("mocktable object is null"));
        }
    }

    @Test
    public void getById() {
        MockTable data = mockService.saveWithoutSameId(getMockTable());
        MockTable result = mockService.getById(data.getId());
        LogPortal.info(this,"hello---");
//        LogPortal.info("[{}]", JSON.toJSONString(result));
        Assert.assertNotNull(result);
    }

    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test-" + DateUtils.dateToString("yyyyMMdd-HH:mm"))
                .setName("mock");
        return table;
    }
}
