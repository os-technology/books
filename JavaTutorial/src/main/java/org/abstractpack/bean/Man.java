package org.abstractpack.bean;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Man
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/11/2下午7:16
 */

public class Man {

    private String sex;

    private String height;

    private int age;

    public String getSex() {
        return sex;
    }

    public Man setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public Man setHeight(String height) {
        this.height = height;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Man setAge(int age) {
        this.age = age;
        return this;
    }
}
