package com.boot.group.dict.controller;

import com.alibaba.fastjson.JSON;
import com.boot.group.dict.entity.StudentInfo;
import com.boot.group.dict.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author code
 * @Title: StudentInfoController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午5:46
 */
@RestController
public class StudentInfoController {
    @Autowired
    StudentInfoService studentInfoService;

    @RequestMapping("/add")
    public String addStudent() {
        StudentInfo result = studentInfoService.addStudent();
        return JSON.toJSONString(result);
    }
}
