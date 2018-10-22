package com.boot.group.dict.controller;

import com.boot.group.dict.entity.User;
import com.boot.group.dict.service.UserService;
import com.boot.group.util.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author code
 * @Title: UserController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/10上午11:13
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 用户的登录功能     * @return
     * 用户名：shiro
     * 密码：pass
     */
    @RequestMapping("/login1")
    public String userLogins(String loginName, String password) {
        Map map = new HashMap<>();
        map.put("loginName", loginName);
        map.put("password", password);
        if (userService.login(map)) {
            return "login  success";
        }
        return "login fail";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Boolean rememberMe) {
        System.out.println(username);
        UsernamePasswordToken token = new UsernamePasswordToken(username, Md5Util.MD5Encode(Md5Util.MD5Encode(password)), rememberMe);
        SecurityUtils.getSubject().login(token);

        return "loginSuccess";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home() {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();

        return "Home";
    }
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}
