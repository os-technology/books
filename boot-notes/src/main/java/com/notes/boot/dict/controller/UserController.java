package com.notes.boot.dict.controller;

import com.alibaba.fastjson.JSON;
import com.notes.boot.dict.beans.UserData;
import com.notes.boot.dict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * http://localhost:8095/notes/user
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
    @RequestMapping("list")
    public String getUserList() {

        List<UserData> list = userService.getUserDataList();
        return JSON.toJSONString(list);
    }

    /**
     * http://localhost:8095/notes/user/report
     * @param request
     */
    @RequestMapping("report")
    public void report(HttpServletRequest request) throws Exception {
        System.out.println(readRequestBody(request));

    }
    private String readRequestBody(HttpServletRequest request) throws Exception {
        InputStream is = request.getInputStream();
        StringBuilder buf = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line = null;
        while ((line = br.readLine()) != null) {
            buf.append(line);
            buf.append('\n');
        }
        if (buf.length() > 0) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }
}
