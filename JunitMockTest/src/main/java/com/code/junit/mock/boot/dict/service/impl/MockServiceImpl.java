package com.code.junit.mock.boot.dict.service.impl;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.dict.dao.MockTableDAO;
import com.code.junit.mock.boot.dict.service.MockService;
import com.code.junit.mock.boot.exceptions.ObjectNullException;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author code
 * @Title: MockServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:03
 */
@Service("mockService")
public class MockServiceImpl implements MockService {
    @Autowired
    private MockTableDAO mockTableDAO;

    @Override
    public void saveMock() {
        mockTableDAO.save(getMockTable());

    }

    @Override
    public MockTable add(MockTable mockTable) {
        MockTable result = mockTableDAO.selectById(mockTable.getId());
        if (result != null) {
            return null;
        }
        mockTableDAO.save(mockTable);
        return mockTable;
    }

    @Override
    public MockTable getById(Long id) {
        return mockTableDAO.selectById(id);
    }

    @Override
    public void privateAndProtectedMethod(MockTable mockTable) throws ObjectNullException {
        if (mockTable == null) {
            throw new ObjectNullException("mocktable object is null");
        }

        String json = convertJson(mockTable);

        if (StringUtils.isEmpty(json)) {
            throw new NullPointerException("json is null");
        }

        mockTable = converMockTable(json);

        printObject(mockTable);
        mockTable.getName().equals(System.getProperty("mockName"));

    }

    protected MockTable converMockTable(String json) {

        MockTable mocktable = JSON.parseObject(json, MockTable.class);
        mocktable.setName(System.getProperty("mockName"));
        return mocktable;
    }

    private void printObject(MockTable json) {
        if (json != null) {
            System.out.println(json);
        }
    }

    private String convertJson(MockTable mockTable) {

        return JSON.toJSONString(mockTable);
    }


    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test1")//.setId(1)
                .setName("mock1");
        return table;
    }
}
