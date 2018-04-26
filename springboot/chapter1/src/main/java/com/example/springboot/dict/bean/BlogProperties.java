package com.example.springboot.dict.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: BlogProperties
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/7下午2:23
 */

@Component
public class BlogProperties {


    @Value("${com.example.springboot.name}")
    private String name;
    @Value("${com.example.springboot.title}")
    private String title;

    @Value("${com.example.springboot.value}")
    private String value;
    @Value("${com.example.springboot.number.int}")
    private String numberInt;
    @Value("${com.example.springboot.number.int.range}")
    private String intRange;
    @Value("${com.example.springboot.number.int.limit}")
    private String intLimit;

    public String getName() {
        return name;
    }

    public BlogProperties setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BlogProperties setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getValue() {
        return value;
    }

    public BlogProperties setValue(String value) {
        this.value = value;
        return this;
    }

    public String getNumberInt() {
        return numberInt;
    }

    public BlogProperties setNumberInt(String numberInt) {
        this.numberInt = numberInt;
        return this;
    }

    public String getIntRange() {
        return intRange;
    }

    public BlogProperties setIntRange(String intRange) {
        this.intRange = intRange;
        return this;
    }

    public String getIntLimit() {
        return intLimit;
    }

    public BlogProperties setIntLimit(String intLimit) {
        this.intLimit = intLimit;
        return this;
    }

    @Override
    public String toString() {
        return "BlogProperties{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", numberInt='" + numberInt + '\'' +
                ", intRange='" + intRange + '\'' +
                ", intLimit='" + intLimit + '\'' +
                '}';
    }
}
