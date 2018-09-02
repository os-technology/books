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

    public DataSource getDataSource() throws Exception {


        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dataService?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(5);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("select 1");
        return dataSource;
    }

    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test1")//.setId(1)
                .setName("mock1");
        return table;
    }
}
