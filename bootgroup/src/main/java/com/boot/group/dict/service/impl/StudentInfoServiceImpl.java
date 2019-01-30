package com.boot.group.dict.service.impl;

import com.boot.group.dict.dao.StudentInfoDAO;
import com.boot.group.dict.entity.StudentInfo;
import com.boot.group.dict.service.StudentInfoService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author code
 * @Title: StudentInfoServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午5:48
 */
@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    StudentInfoDAO studentInfoDAO;

    @Override
    public StudentInfo addStudent() {
        return studentInfoDAO.save(getStudentInfo());
    }

    private StudentInfo getStudentInfo() {

        StudentInfo info = new StudentInfo();
        info.setAddressId(1)
                .setAge(13)
                .setGrade("5")
                .setStudentName("李明");
        return info;
    }


    /**
     * 动态代理方式
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    @Override
    public Integer addStudentForTransactional() {
        System.out.println("add StudentForTransactional 方法执行");
        try {
            ((StudentInfoService)AopContext.currentProxy()).getStudentInfoForTransactional();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StudentInfo info = new StudentInfo();
        info.setAddressId(1)
                .setAge(13)
                .setGrade("5")
                .setStudentName("李明parent");
        studentInfoDAO.save(info);

        int a = 10 / 0;
        return Integer.MAX_VALUE;
    }

    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    @Override
    public Integer addStudentForAspect() {
        System.out.println("add StudentForTransactional 方法执行");
        try {
            getStudentInfoForTransactional();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StudentInfo info = new StudentInfo();
        info.setAddressId(1)
                .setAge(13)
                .setGrade("5")
                .setStudentName("李明parent");
        studentInfoDAO.save(info);

        int a = 10 / 0;
        return Integer.MAX_VALUE;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW ,rollbackFor = Exception.class)
    @Override
    public Integer getStudentInfoForTransactional() {
        System.out.println("get StudentInfoForTransactional 方法执行");
        StudentInfo info = new StudentInfo();
        info.setAddressId(1)
                .setAge(130)
                .setGrade("5")
                .setStudentName("李明child");
        studentInfoDAO.save(info);
//        int a = 10 / 0;

        return Integer.MAX_VALUE;
    }

    @Override
    public Integer test1() {
        System.out.println("test1 被调用");
        test2();
        System.out.println("--------");
        return Integer.MAX_VALUE;
    }

    @Override
    public Integer test2() {
        System.out.println("test2 被调用");
        System.out.println("--------");
        return Integer.MAX_VALUE;
    }

    @Override
    public Integer abcTest() {
        System.out.println("abcTest 被调用");
        System.out.println("--------");
        return null;
    }
}
