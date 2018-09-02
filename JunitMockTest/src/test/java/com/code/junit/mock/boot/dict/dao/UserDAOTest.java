package com.code.junit.mock.boot.dict.dao;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.User;
import com.code.junit.mock.boot.util.LogPortal;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author code
 * @Title: UserDAOTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午12:44
 */
public class UserDAOTest extends BaseAppTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void list(){
        List<User> list = userDAO.list();
        LogPortal.info(JSON.toJSONString(list));
        Assert.assertNotNull(list);
    }
}