package com.notes.boot.dict.dao;

import com.notes.boot.dict.BaseAppTest;
import com.notes.boot.dict.beans.MockTable;
import com.notes.boot.util.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public void aa(){
        Map<String,String> mapval =new HashMap<>();

        Map<String,Map<String,String>> map = new HashMap<>();

        map.put("hello",mapval);
    }

    @Test
    public void getPageList(){
        List<MockTable> list = mockTableDAO.getPageList(null);
        Assert.assertNotNull(list);
    }

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
    @Test
    public void testselectByName(){
        MockTable mockTable = getMockTable();
        mockTableDAO.save(mockTable);
        List<MockTable> result = mockTableDAO.selectByName(mockTable.getName());
        List<MockTable> result2 = mockTableDAO.selectByName(null);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result2.size()>0);
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
                .setName("mock"+DateUtils.dateToString("yyyyMMdd-HH:mm"));
        return table;
    }
}
