package com.boot.group.dict.service.impl;

import com.boot.group.dict.dao.StudentInfoDAO;
import com.boot.group.dict.entity.StudentInfo;
import com.boot.group.dict.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .setStudentName("李莉");
        return info;
    }
}
