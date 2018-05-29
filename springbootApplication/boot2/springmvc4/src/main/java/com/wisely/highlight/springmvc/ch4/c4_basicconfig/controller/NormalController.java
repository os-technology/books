package com.wisely.highlight.springmvc.ch4.c4_basicconfig.controller;

import com.wisely.highlight.springmvc.ch4.c4_basicconfig.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: NormalController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/29上午9:15
 */

@Controller
public class NormalController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg",demoService.saySomething("mockTest"));
        return "page";
    }
}
