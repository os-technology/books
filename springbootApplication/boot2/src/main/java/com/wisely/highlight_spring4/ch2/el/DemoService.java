package com.wisely.highlight_spring4.ch2.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15上午8:39
 *
 * 此处注入普通字符串
 */
@Service
public class DemoService {
    @Value("DemoService类的属性")
    private String author;

    public String getAuthor() {
        return author;
    }

    public DemoService setAuthor(String author) {
        this.author = author;
        return this;
    }
}
