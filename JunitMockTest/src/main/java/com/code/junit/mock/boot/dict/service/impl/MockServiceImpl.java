package com.code.junit.mock.boot.dict.service.impl;

import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.dict.dao.MockTableDAO;
import com.code.junit.mock.boot.dict.service.MockService;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        mockTable.setName("new Data");
        mockTableDAO.save(mockTable);
        return mockTable;
    }

    @Override
    public MockTable getById(Long id) {
        return mockTableDAO.selectById(id);
    }


    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test1")//.setId(1)
                .setName("mock1");
        return table;
    }
}
