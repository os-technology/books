package com.boot.group.dict.handler;

import com.boot.group.dict.BootGroupTest;
import com.boot.group.dict.service.StudentInfoService;
import com.boot.group.dict.service.impl.StudentInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

/**
 * https://blog.csdn.net/cdsn13082487212/article/details/79515423
 * @author code
 * @Title: MyInvocationHandlerTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/24上午10:28
 */
@EnableAspectJAutoProxy(exposeProxy=true)
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MyInvocationHandlerTest.class)
public class MyInvocationHandlerTest extends BootGroupTest {

    /**
     * 这也就是spring 的事务控制大致实现。
     */
    @Test
    public void handlerTest() {
        MyInvocationHandler invocationHandler = new MyInvocationHandler(new StudentInfoServiceImpl());
        StudentInfoService studentInfoService = (StudentInfoService) Proxy.newProxyInstance(StudentInfoService.class.getClassLoader(),
                new StudentInfoServiceImpl().getClass().getInterfaces(), invocationHandler);

        studentInfoService.test1();
        studentInfoService.test2();
        studentInfoService.abcTest();
    }

    /**
     * 这也就是spring 的事务控制大致实现。
     */
    @Test
    public void handlerTestForTransactional() {
        SpringInvocationHandler invocationHandler = new SpringInvocationHandler(new StudentInfoServiceImpl());
        StudentInfoService studentInfoService = (StudentInfoService)invocationHandler.getCglibProxy();
        studentInfoService.test1();
        studentInfoService.addStudentForTransactional();
    }

}
