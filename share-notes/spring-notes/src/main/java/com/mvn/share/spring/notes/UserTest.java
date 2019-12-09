package com.mvn.share.spring.notes;

import com.mvn.share.spring.notes.beans.Student;
import com.mvn.share.spring.notes.beans.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author code
 * @Title: UserTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/91:33 PM
 */
public class UserTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.mvn");

        User user = (User)applicationContext.getBean("user");
        System.out.println(user.getUsername());
    }

    @Test
    public void test2(){
ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student.getName());
    }
}
