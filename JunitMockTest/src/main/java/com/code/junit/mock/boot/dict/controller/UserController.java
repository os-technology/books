package com.code.junit.mock.boot.dict.controller;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.beans.UserData;
import com.code.junit.mock.boot.dict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * http://localhost:8095/junit/user
 * @author code
 * @Title: UserController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/19下午2:22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 获取用户列表信息,乱码问题解决
     *
     * @return
     */
    @RequestMapping(value= "list",produces = { "application/json;charset=UTF-8" })
    public String getUserList() {

        List<UserData> list = userService.getUserDataList();
        return JSON.toJSONString(list);
    }

}
