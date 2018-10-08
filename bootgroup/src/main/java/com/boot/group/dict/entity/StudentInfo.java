package com.boot.group.dict.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author code
 * @Title: StudentInfo
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午2:34
 */
@Entity
@DynamicUpdate(true)
public class StudentInfo extends BaseEntity {


    private String studentName;

    private int age;

    private String grade;

    private int addressId;
    @Column(insertable = false, updatable = false)
    private Date updateTime;


    public String getStudentName() {
        return studentName;
    }

    public StudentInfo setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public StudentInfo setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public int getAddressId() {
        return addressId;
    }

    public StudentInfo setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public StudentInfo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
