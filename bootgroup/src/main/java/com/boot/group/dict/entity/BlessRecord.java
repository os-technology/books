package com.boot.group.dict.entity;

import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;

/**
 * @author code
 * @Title: BlessRecord
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/30上午11:55
 */
@Entity
@DynamicUpdate(true)
public class BlessRecord extends BaseEntity {

    private String username;

    private String content;

    public String getUsername() {
        return username;
    }

    public BlessRecord setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getContent() {
        return content;
    }

    public BlessRecord setContent(String content) {
        this.content = content;
        return this;
    }
}
