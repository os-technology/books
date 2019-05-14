package org.beans;

import java.util.Date;

/**
 * @author code
 * @Title: User
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午12:37
 */
public class UserBean {
    private Long id;
    private String username;
    private String companyId;
    private Date createTime;
    private Date updateTime;
    private int age;

    public int getAge() {
        return age;
    }

    public UserBean setAge(int age) {
        this.age = age;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserBean setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserBean setUsername(String username) {
        this.username = username;
        return this;
    }


    public String getCompanyId() {
        return companyId;
    }

    public UserBean setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserBean setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserBean setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
