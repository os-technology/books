package com.core.context.path.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: BookInfo
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/14上午11:47
 */
@Component
@ConfigurationProperties(prefix = "book")
@PropertySource("classpath:author.properties")
public class BookAttrbutes {

    private String author;

    private String name;

    public String getAuthor() {
        return author;
    }

    public BookAttrbutes setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookAttrbutes setName(String name) {
        this.name = name;
        return this;
    }
}
