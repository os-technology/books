package com.core.context.path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SpringContextPathApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/14上午10:23
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.core.context.path")
@RestController//@RestController = @Controller+@ResponseBody ，使用@RestController就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
public class SpringContextPathApplication {
//    http://localhost:9090/helloboot/
    @RequestMapping("/")
    public String contextpath(){

        return "context-path config is right.";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringContextPathApplication.class,args);
    }

}
