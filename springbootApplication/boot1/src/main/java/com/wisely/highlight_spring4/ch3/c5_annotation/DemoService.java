package com.wisely.highlight_spring4.ch3.c5_annotation;

import org.springframework.stereotype.Service;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17下午4:50
 */
@Service
public class DemoService {

    public void outputResult(){
        System.out.println("从组合注解配置照样获得的bean");
    }
}
