package com.wisely.highlight.springmvc.ch4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: WebInitializer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/19下午6:03
 */
//WebApplicationInitializer是Spring提供用来配置Servlet 3.0+配置的接口，
// 从而实现了替代web.xml的位置。 实现此接口将会自动被
// SpringServletContainerInitializer（用来启动Servlet 3.0容器）获取到
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {


        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);////新建WebApplicationContext， 注册配置类，并将其和当前servletContext关联。
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new
                DispatcherServlet(ctx));//注册Spring MVC的DispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
