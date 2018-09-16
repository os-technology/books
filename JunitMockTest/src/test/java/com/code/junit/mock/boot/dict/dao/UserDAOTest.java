package com.code.junit.mock.boot.dict.dao;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.User;
import com.code.junit.mock.boot.util.LogPortal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author code
 * @Title: UserDAOTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午12:44
 */
@RunWith(SpringRunner.class)
public class UserDAOTest extends BaseAppTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void list(){
        List<User> list = userDAO.list();
        LogPortal.info(JSON.toJSONString(list));
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void save(){
        User user = getUser();
        userDAO.save(user);
        Assert.assertNotNull(user.getId());
    }

    private User getUser() {
        User user = new User();
        user.setCreateTime(new Date())
                .setUsername("测试")
                .setCompanyId("3")
//                .setUpdateTime()
        ;
        return user;
    }
}
