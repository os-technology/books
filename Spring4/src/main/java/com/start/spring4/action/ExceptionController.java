package com.start.spring4.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	public void exception() {
		System.out.println("异常处理方法");
	}
}
