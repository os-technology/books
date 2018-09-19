package com.code.junit.mock.boot.dict.service;

import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.UserData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author code
 * @Title: UserServiceTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/19下午3:54
 */
@RunWith(SpringRunner.class)
public class UserServiceTest extends BaseAppTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserDataList(){
        List<UserData> list = userService.getUserDataList();
        Assert.assertFalse(list.isEmpty());
    }
}
