package com.wisely.highlight.springmvc.ch4.c4_basicconfig.controller;

import com.wisely.highlight.springmvc.ch4.c4_basicconfig.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: MyRestController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/29上午9:24
 */
@RestController
public class MyRestController {


    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
    public String testRest() {
        return demoService.saySomething("testRestController");
    }

}
