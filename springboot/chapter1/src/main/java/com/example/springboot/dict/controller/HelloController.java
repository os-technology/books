package com.example.springboot.dict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HelloController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/5下午12:21
 */
@RestController
public class HelloController {


    @RequestMapping("/boot")
    public String index(){
        return "hello boot";
    }
}
