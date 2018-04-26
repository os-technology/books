package com.example.springboot.bean;

import com.example.springboot.app.SpringbootApplication;
import com.example.springboot.dict.bean.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SpringbootBeanTests
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/7下午2:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootBeanTests {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getPropertyValue(){

        String blogName = blogProperties.getName();
        Assert.assertNotNull(blogName);
        String blog = blogProperties.toString();
        System.out.println(blog);
    }
}
