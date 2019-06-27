package com.notes.boot.dict;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;


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
@MapperScan("com.code.junit.mock.boot.dict.dao")
@ComponentScan("com.code.junit.mock.boot")

//替代@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@Transactional(transactionManager="transactionManager")
@Rollback(value = true)
@SpringBootTest
public class BaseAppTest {

}
