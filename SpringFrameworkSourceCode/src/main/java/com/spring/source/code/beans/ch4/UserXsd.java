package com.spring.source.code.beans.ch4;

/**
 * 自定义标签的使用bean
 *
 * @author yuijnshui
 * @Title: UserXsd
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/6下午4:13
 */
public class UserXsd {

    private String userName;
    private String email;

    public String getUserName() {
        return userName;
    }

    public UserXsd setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserXsd setEmail(String email) {
        this.email = email;
        return this;
    }
}
