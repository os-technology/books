package com.wisely.highlight.springmvc.ch4.c4_basicconfig.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用@ControllerAdvice处理全局异常类
 *
 * @author yuijnshui@lxfintech.com
 * @Title: ExceptionHandlerAdvice
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/23上午9:17
 */
@ControllerAdvice//声明一个控制器建言，@ControllerAdvice 组合了 @Component 注解，所以自动注册为Spring的Bean。
public class ExceptionHandlerAdvice {


    //在此处定义为全局处理，通过 @ExceptionHandler 的value属性
    //可过滤拦截的条件，在此处我们可以看出我们拦截所有的Exception
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView mav = new ModelAndView("error");//error页面
        mav.addObject("errorMessage", exception.getMessage());
        return mav;
    }

    //该注解将键值对添加到全局，所有注解的 @RequestMapping 的方法可获得此键值对
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder//通过该注解定制 WebDataBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //此处颜值忽略request参数的id,更多关于WebDataBinder的配置，请参考WebDataBinder的API文档。
        webDataBinder.setDisallowedFields("id");
    }
}
