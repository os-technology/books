package com.boot.group.dict.dao;

import com.boot.group.dict.BootGroupTest;
import com.boot.group.dict.entity.StudentInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author code
 * @Title: StudentInfoDAOTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午3:22
 */
@RunWith(SpringRunner.class)
public class StudentInfoDAOTest extends BootGroupTest {

    @Autowired
    private StudentInfoDAO studentInfoDAO;

    @Test
    public void list(){
        Iterable<StudentInfo> result = studentInfoDAO.findAll();
        Assert.assertTrue(result.iterator().hasNext());
    }

    @Test
    public void save(){
        StudentInfo info = getStudentInfo();
        info = studentInfoDAO.save(info);
        Assert.assertNotNull(info.getId());
    }

    @Test
    public void findById(){
        StudentInfo studentInfo = studentInfoDAO.findById(1l);
        Assert.assertNotNull(studentInfo);
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
