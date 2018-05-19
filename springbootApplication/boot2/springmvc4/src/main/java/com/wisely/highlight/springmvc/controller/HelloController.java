package com.wisely.highlight.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HelloController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/19下午6:26
 */
@Controller//利用@Controller注解声明是一个控制器
public class HelloController {

    @RequestMapping("/index")//利用@RequestMapping配置URL和方法之间的映射。
    public String hello() {
        return "index";//通过上面ViewResolver的Bean配置， 返回值为index， 说明我们的页面放置的路径为/WEBINF/classes/views/index.jsp
    }

    @RequestMapping("/entity")
    @ResponseBody
    public ResponseEntity entity() {
        System.out.println("entity request is ok");
        return new ResponseEntity("responseEntity is ok", HttpStatus.OK);
    }
}
