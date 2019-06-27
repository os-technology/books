package com.notes.boot.dict.beans;

import java.util.Date;

/**
 * @author code
 * @Title: User
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午12:37
 */
public class User {
    private Long id;
    private String username;
    private String companyId;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }


    public String getCompanyId() {
        return companyId;
    }

    public User setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public User setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
