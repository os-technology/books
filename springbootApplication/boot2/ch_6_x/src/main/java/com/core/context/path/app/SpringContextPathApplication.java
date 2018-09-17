package com.core.context.path.app;

import com.core.context.path.beans.BookAttrbutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages = "com.core.context.path")//只能写到path路径，如果写到app路径位置，则BookInfo类无法在加载过程中被扫描到。即无法创建实体bean
@RestController//@RestController = @Controller+@ResponseBody ，使用@RestController就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
public class SpringContextPathApplication {
//    http://localhost:9090/helloboot/

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private BookAttrbutes bookAttrbutes;

    /**
     * http://localhost:9090/helloboot/
     *
     * @return
     */
    @RequestMapping("/")
    public String contextpath() {

        System.out.println(bookAttrbutes.getAuthor() + "__" + bookAttrbutes.getName());

        return "context-path config is right. Author is " + bookAuthor + " ,book name is " + bookName;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringContextPathApplication.class, args);
    }

}
