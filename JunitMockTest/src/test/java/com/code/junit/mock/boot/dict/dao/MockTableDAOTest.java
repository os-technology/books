package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.util.DateUtils;
import org.apache.ibatis.session.SqlSession;
import org.assertj.core.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 参考地址：
 * http://www.mybatis.org/mybatis-3/zh/getting-started.html
 * @author code
 * @Title: MockTableDAOTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:45
 */
@RunWith(SpringRunner.class)
public class MockTableDAOTest extends BaseAppTest {



    @Autowired
    private MockTableDAO mockTableDAO;

    @Test
    public void saveTest() {
        MockTable mockTable = getMockTable();
        mockTableDAO.save(mockTable);
        Assert.assertNotNull(mockTable.getId());
    }

    @Test
    public void updateById(){
        int count = mockTableDAO.updateById(getUpdateMockTable());
        Assert.assertNotNull(count);
    }

    @Test
    public void testselectById(){
        MockTable mockTable = getMockTable();
        mockTableDAO.save(mockTable);
        MockTable result = mockTableDAO.selectById(mockTable.getId());
        Assert.assertNotNull(result);
    }
    private MockTable getUpdateMockTable() {
        MockTable table = new MockTable();
        table.setData("test3").setId(1l)
                .setName("mock3");
        return table;
    }
    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test-"+DateUtils.dateToString("yyyyMMdd-HH:mm"))
                .setName("mock");
        return table;
    }
}
