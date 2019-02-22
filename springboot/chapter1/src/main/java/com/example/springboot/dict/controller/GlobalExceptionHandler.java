package com.example.springboot.dict.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author code
 * @Title: GlobalExceptionHandler
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/2/15下午6:07
 *
 * 通过使用 @ControllerAdvice 定义统一的异常处理类
 *  ,@ExceptionHandler 用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";


    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
