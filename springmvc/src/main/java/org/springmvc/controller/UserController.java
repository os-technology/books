package org.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	private String result = "output/result";

	@RequestMapping("/user")
	public String input(HttpServletRequest request) {
		request.setAttribute("res", "张三");

		return result;
	}
}
