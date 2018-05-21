package com.wisely.highlight.springmvc.ch4.c3_annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoRestController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/21下午2:23
 */
@RestController//
@RequestMapping("/rest")
public class DemoRestController {


    // /rest/getjson?id=1&name=xx
    @RequestMapping(value = "/getjson",produces = "application/json;charset=utf-8")
    public DemoObj getJson(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+" come on,json is good!!!");
    }

    @RequestMapping(value = "/getxml",produces = "application/xml;charset=utf-8")
    public DemoObj getXml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+" come on ,xml is ok!!!");
    }
}
