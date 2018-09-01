package com.code.junit.mock.boot.dict;

import com.code.junit.mock.boot.dict.dao.MockTableDAO;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author code
 * @Title: BaseAppTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:46
 */

@ContextConfiguration(classes = BaseAppTest.class)
@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("com.code.junit.mock.boot.dict.dao")
@EnableTransactionManagement
@ComponentScan("com.code.junit.mock.boot")
//@TransactionConfiguration(defaultRollback = false)
public class BaseAppTest {
    protected SqlSessionFactory sqlSessionFactory;
    protected SqlSession session ;

    @Before
    public void setUp() throws Exception {
        DataSource dataSource = getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(MockTableDAO.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
          session = sqlSessionFactory.openSession();
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
}
