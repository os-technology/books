package com.wisely.highlight.springmvc.ch4.c4_basicconfig.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 示例拦截器
 *
 * @author yuijnshui@lxfintech.com
 * @Title: DemoInterceptor
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/22上午10:08
 */

public class DemoInterceptor extends HandlerInterceptorAdapter {//继承HandlerInterceptorAdapter类实现自定义拦截

    /**
     * 重写preHandle，在请求发生前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response, Object handler) throws Exception {

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);

        return true;
    }

    /**
     * 重写postHandle,在请求完成后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request
            , HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间："+new Long(endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
