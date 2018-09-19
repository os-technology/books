package com.code.junit.mock.boot.dict.beans;

import java.util.Date;

/**
 * @author code
 * @Title: UserData
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/19下午2:29
 */
public class UserData {
    private Long userId;
    private String username;
    private String companyName;
    private String address;
    private Date userCreateTime;


    public Long getUserId() {
        return userId;
    }

    public UserData setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserData setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public UserData setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserData setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public UserData setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
        return this;
    }
}
