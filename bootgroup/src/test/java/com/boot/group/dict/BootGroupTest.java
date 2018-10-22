package com.boot.group.dict;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author code
 * @Title: BootGroupTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午3:17
 */
@EnableJpaRepositories("com.boot.group.dict.dao")
@ComponentScan("com.boot.group")
@EnableTransactionManagement
//替代@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@Transactional(transactionManager="transactionManager")
@Rollback(value = true)
@SpringBootTest
@ContextConfiguration(locations = {"classpath:spring-mvc-test.xml",
        "classpath:application-bean-test.xml"})
public class BootGroupTest {
}
