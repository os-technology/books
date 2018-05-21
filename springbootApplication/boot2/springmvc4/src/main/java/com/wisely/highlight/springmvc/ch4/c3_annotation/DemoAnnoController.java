package com.wisely.highlight.springmvc.ch4.c3_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoAnnoController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/21上午9:43
 */
@Controller//声明此类是一个控制器
@RequestMapping("/anno")//映射此类的访问路径是/anno
public class DemoAnnoController {

    //此方法未标注路径， 因此使用类级别的路径/anno； produces可定制返回的response
    // 的媒体类型和字符集， 或需返回值是json对象， 则设置
    // produces=“application/json； charset=UTF-8”， 在后面的章节我们会演示此项特性
    @RequestMapping(produces = "text/plain;charset=utf-8")
    public @ResponseBody
    String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/pathvar/{path}",
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String demoPathVar(@PathVariable String path, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,path:" + path;
    }


    @RequestMapping(value = "/requestParam",
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String passRequestParam(Long id, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,path:" + id;
    }

    @RequestMapping(value = "/obj",
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,obj.id:" + obj.getId() + " obj.name:" + obj.getName();
    }

    @RequestMapping(value = {"/name1", "/name2"},
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String remove(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access";
    }
}
