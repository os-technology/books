package com.mvn.share.spring.notes.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author code
 * @Title: User
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/91:32 PM
 */
//@Component
    @Service
public class User {
    private String username = "zhangsan";
    private String password;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
