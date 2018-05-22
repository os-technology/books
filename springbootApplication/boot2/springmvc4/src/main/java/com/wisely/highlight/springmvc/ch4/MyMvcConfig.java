package com.wisely.highlight.springmvc.ch4;

import com.wisely.highlight.springmvc.ch4.c4_basicconfig.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 此处无任何特别， 只是一个普通的Spring配置类。
 * 这里我们配置了一个JSP的ViewResolver， 用来映射路
 * 径和实际页面的位置， 其中， @EnableWebMvc注解会
 * 开启一些默认配置， 如一些ViewResolver或者MessageConverter等
 *
 * @Created on 2018/5/18下午7:17
 */
@Configuration
@ComponentScan("com.wisely.highlight.springmvc")
@EnableWebMvc//开启springMVC支持，若无此注解，重写WebMvcConfigurerAdapter无效
public class MyMvcConfig extends WebMvcConfigurerAdapter {//继承WebMvcConfigurerAdapter类，重写其方法可对SpringMVC进行配置。

    @Bean
    public InternalResourceViewResolver viewResolver() {
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

    /**
     * 静态资源配置
     * http://localhost:8080/boot/springmvc4/assets/js/jquery.js
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //addResourceLocations 指的是文件放置目录，
        // addResourceHandler 指的是对外暴露的访问路径
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");
    }

    @Bean//配置拦截器的bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    /**
     * 重写addInterceptors，注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }
}
