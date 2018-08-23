package com.springcloud.eureka.client.beans;

import java.io.Serializable;

/**
 * @author code
 * @Title: User
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/23下午4:57
 */
public class User implements Serializable {
    private String id;

    private String name;


    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
