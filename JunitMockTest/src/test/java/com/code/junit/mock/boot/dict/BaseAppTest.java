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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @author code
 * @Title: BaseAppTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:46
 */

@ContextConfiguration(locations = {"classpath:spring-mvc-test.xml",
        "classpath:application-bean-test.xml"})
@SpringBootTest
@MapperScan("com.code.junit.mock.boot.dict.dao")
@EnableTransactionManagement
@ComponentScan("com.code.junit.mock.boot")

//替代@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@Transactional(transactionManager="transactionManager")
@Rollback(value = true)

public class BaseAppTest {

}
