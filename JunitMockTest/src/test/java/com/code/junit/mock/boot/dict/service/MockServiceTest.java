package com.code.junit.mock.boot.dict.service;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.util.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void add(){
        MockTable data = mockService.add(getMockTable());
        Assert.assertNotNull(data);
    }

    @Test
    public void getById(){
        MockTable result = mockService.getById(12l);
        System.out.println(JSON.toJSONString(result));
    }

    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test-"+DateUtils.dateToString("yyyyMMdd-HH:mm"))
                .setName("mock");
        return table;
    }
}
