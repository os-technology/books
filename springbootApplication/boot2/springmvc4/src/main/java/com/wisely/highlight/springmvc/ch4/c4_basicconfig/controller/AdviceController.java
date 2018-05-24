package com.wisely.highlight.springmvc.ch4.c4_basicconfig.controller;

import com.alibaba.fastjson.JSON;
import com.wisely.highlight.springmvc.ch4.c3_annotation.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演示控制器
 *
 * @author yuijnshui@lxfintech.com
 * @Title: AdviceController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/23上午10:30
 */
@Controller
public class AdviceController {


    //http://localhost:8080/boot/springmvc4/advice?id=1&name=xx
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
        System.out.println(JSON.toJSONString(obj));//此处会发现id参数被拦截了。
        throw new IllegalArgumentException("非常抱歉，参数有误/"
                + "来自@ModelAttribute:" + msg);
    }
}
