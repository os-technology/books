package com.mvn.share.spring.notes.beans;

/**
 * @author code
 * @Title: User
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/91:32 PM
 */
public class Student {
    private String name = "小明";
    private String age;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Student setAge(String age) {
        this.age = age;
        return this;
    }
}
