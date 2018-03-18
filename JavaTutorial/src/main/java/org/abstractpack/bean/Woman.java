package org.abstractpack.bean;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Woman
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/11/2下午7:17
 */

public class Woman {
    private String sex;

    private String height;

    private int age;

    public String getSex() {
        return sex;
    }

    public Woman setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public Woman setHeight(String height) {
        this.height = height;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Woman setAge(int age) {
        this.age = age;
        return this;
    }
}
