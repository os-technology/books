package com.code.junit.mock.boot.dict.service;

import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.util.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author code
 * @Title: MockServiceTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午1:32
 */
public class MockServiceTest extends BaseAppTest {

    @Autowired
    private MockService mockService;

    @Test
    public void add(){
        MockTable data = mockService.add(getMockTable());
        Assert.assertNotNull(data);
    }

    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test-"+DateUtils.dateToString("yyyyMMdd-HH:mm"))
                .setName("mock");
        return table;
    }
}
