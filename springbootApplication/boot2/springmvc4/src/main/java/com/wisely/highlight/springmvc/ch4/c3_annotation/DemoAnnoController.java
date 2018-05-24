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
        return "url:" + request.getRequestURL() + " can access";//演示可接受HttpServletRequest作为参数， 当然也可以接受HttpServletReponse作为参数。 此处的 @ReponseBody用在返回值前面。
    }

    //http://localhost:8080/boot/springmvc4/anno/pathvar/xx
    @RequestMapping(value = "/pathvar/{path}",
            produces = "text/plain;charset=utf-8")//演示接受路径参数， 并在方法参数前结合@PathVariable使用， 访问路径为/anno/pathvar/xx。
    @ResponseBody
    public String demoPathVar(@PathVariable String path, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,path:" + path;
    }


    //演示常规的request参数获取， 访问路径为/anno/requestParam?id=1。
    @RequestMapping(value = "/requestParam",
            produces = "text/plain;charset=utf-8")
    @ResponseBody//@ReponseBody也可以用在方法上。
    public String passRequestParam(Long id, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,path:" + id;
    }

    //演示解释参数到对象， 访问路径为
    // http://localhost:8080/boot/springmvc4/anno/obj?id=1&name=xx
    @RequestMapping(value = "/obj",
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,obj.id:" + obj.getId() + " obj.name:" + obj.getName();
    }

    //演示映射不同的路径到相同的方法， 访问路径为/anno/name1或/anno/name2
    @RequestMapping(value = {"/name1", "/name2"},
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String remove(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access";
    }
}
