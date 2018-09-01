package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.MockTable;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

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
public class MockTableDAOTest extends BaseAppTest {



//    @Autowired
//    private MockTableDAO mockTableDAO;

    @Test
    public void saveTest() {
        MockTableDAO mockTableDAO = session.getMapper(MockTableDAO.class);
         int a = mockTableDAO.save(getMockTable());
        Assert.assertNotNull(a);
    }

    @Test
    public void selectById_1() {
        MockTable mockTable = (MockTable) session.selectOne("com.code.junit.mock.boot.dict.dao.MockTableDAO.selectById", 1);
        Assert.assertNotNull(mockTable);
    }

    @Test
    public void testselectById(){
        MockTableDAO mockTableDAO = session.getMapper(MockTableDAO.class);
        MockTable result = mockTableDAO.selectById(1);
        Assert.assertNotNull(result);
    }

    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test1")
                .setName("mock1");
        return table;
    }
}
