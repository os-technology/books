package com.wisely.highlight.springmvc.ch4.c4_basicconfig.service;

import org.springframework.stereotype.Service;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/28下午3:26
 */
@Service
public class DemoService {

    public String saySomething(String in){
        return "Hello "+in;
    }
}
