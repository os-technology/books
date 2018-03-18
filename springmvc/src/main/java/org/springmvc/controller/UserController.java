package org.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	private String result = "result";

	/**
	 * 1.使用@RequestMapping来映射请求的URL<br>
	 * 2.返回值会通过视图解析器解析为实际的物理视图,对于InternalResourceViewResolver而言，会做如下解析：
	 * 通过 prefix(前缀) + returnValue + 后缀 的方式得到实际的物理视图，然后进行转发操作<br>
	 *
	 * @param request
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年6月7日 下午7:26:42
	 */
	@RequestMapping("/user")
	public String input(HttpServletRequest request) {
		request.setAttribute("res", "张三");
//		ClassPathXmlApplicationContext
		return result;
	}
}
