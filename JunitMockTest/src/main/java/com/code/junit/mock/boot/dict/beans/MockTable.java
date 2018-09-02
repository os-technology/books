package com.code.junit.mock.boot.dict.beans;

import java.util.Date;

/**
 * @author code
 * @Title: MockTable
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:05
 */
public class MockTable {
    private Long id;

    private String name;
    private String data;
    private Date createTime;


    public Long getId() {
        return id;
    }

    public MockTable setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MockTable setName(String name) {
        this.name = name;
        return this;
    }

    public String getData() {
        return data;
    }

    public MockTable setData(String data) {
        this.data = data;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MockTable setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
