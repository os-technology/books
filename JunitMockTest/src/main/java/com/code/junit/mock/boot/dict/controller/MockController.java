package com.code.junit.mock.boot.dict.controller;

import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.dict.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author code
 * @Title: WebBootController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:00
 */
@RestController
public class MockController {
    @Autowired
    private MockService mockService;

    @RequestMapping("/index")
    public String init() {
        return "index is success";
    }

    @RequestMapping("save")
    public String save() {
        mockService.saveMock();
        return "save is ok";
    }

    @RequestMapping("addMock")
    public String addMock(MockTable mockTable) {

        mockService.add(mockTable);
        return "addMock is ok";
    }
}
