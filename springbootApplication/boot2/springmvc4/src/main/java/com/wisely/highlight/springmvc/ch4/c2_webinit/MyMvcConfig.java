package com.wisely.highlight.springmvc.ch4.c2_webinit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *此处无任何特别， 只是一个普通的Spring配置类。
 * 这里我们配置了一个JSP的ViewResolver， 用来映射路
 * 径和实际页面的位置， 其中， @EnableWebMvc注解会
 * 开启一些默认配置， 如一些ViewResolver或者MessageConverter等
 * @Created on 2018/5/18下午7:17
 */
@Configuration
@ComponentScan("com.wisely.highlight.springmvc")
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }

    //默认页面配置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        ViewControllerRegistration viewRegistration = registry.addViewController("/");
        viewRegistration.setViewName("hello");
    }


}
