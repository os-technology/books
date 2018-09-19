package com.code.junit.mock.boot.dict.service.impl;

import com.code.junit.mock.boot.dict.beans.UserData;
import com.code.junit.mock.boot.dict.dao.UserDAO;
import com.code.junit.mock.boot.dict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author code
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/19下午2:24
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserData> getUserDataList() {

        //获取用户综合数据
        List<UserData> list = userDAO.getUserDataList();
        return list;
    }
}
