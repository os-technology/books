package com.boot.group.dict.service;

import com.boot.group.dict.entity.StudentInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author code
 * @Title: StudentInfoService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午5:47
 */
public interface StudentInfoService {

    StudentInfo addStudent();

    Integer addStudentForTransactional();

    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    Integer addStudentForAspect();

    Integer getStudentInfoForTransactional();

    public Integer test1();
    public Integer test2();
    public Integer abcTest();
}
