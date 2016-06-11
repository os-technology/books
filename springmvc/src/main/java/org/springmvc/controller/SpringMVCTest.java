package org.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("mapping")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS = "success";
	private static final String res = "res";

	/**
	 * <pre>
	 * Rest 风格的URL
	 * 以CRUD为例:             老式风格
	 * 新增：/order POST
	 * 修改：/order/1 PUT       update?id=1
	 * 获取：/order/1 GET       get?id=1
	 * 删除：/order/1 DELETE    delete?id=1
	 * 
	 * 如何发送 PUT 请求跟 DELETE 请求呢?
	 * 1. 需要配置HiddenHttpMethodFilter
	 * 2. 需要发送 POST 请求
	 * 3. 需要发送 POST 请求时携带一个 name="_method"的隐藏域，值为 DELETE 或 PUT
	 * 
	 * 在SpringMVC 的目标方法中如何得到id 呢？
	 * 使用@PathVariable 注解
	 * </pre>
	 */

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id, HttpServletRequest request) {
		request.setAttribute(res, "testRest  put请求：" + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id, HttpServletRequest request) {
		request.setAttribute(res, "testRest  delete请求：" + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest(HttpServletRequest request) {
		request.setAttribute(res, "testRest  post请求 ");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id, HttpServletRequest request) {
		request.setAttribute(res, "testRest  get请求：" + id);
		return SUCCESS;
	}

	/**
	 * @PathVariable 可以映射URL中的占位符到目标方法的参数中
	 *
	 * @param id
	 * @param request
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年6月11日 上午11:09:52
	 */
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") String id, HttpServletRequest request) {
		request.setAttribute(res, "testPathVariable " + id);
		return SUCCESS;
	}

	@RequestMapping("/**")
	public String testAntPath2(HttpServletRequest request) {
		request.setAttribute(res, "testAntPath2");
		return SUCCESS;
	}

	@RequestMapping("/**/path")
	public String testAntPath(HttpServletRequest request) {
		request.setAttribute(res, "path is success");
		return SUCCESS;
	}

	/**
	 * 了解：可以使用params 和headers 来更加精确的映射请求，params和headers支持简单的表达式
	 *
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Author Yu Jinshui
	 * @createTime 2016年6月11日 上午10:08:25
	 */
	@RequestMapping(value = "testParamsAndHeaders", params = { "username", "age!=10" }//
	// , headers = { "Accept-Language=zh-CN,zh;q=0.8" }//使用
	// Accept-Language=，而不是Accept-Language+冒号 的格式
			, headers = { "Accept-Language=en-US,zh;q=0.8" }//
	)
	public String testParamsAndHeaders(HttpServletRequest request) throws UnsupportedEncodingException {
		// request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		System.out.println(username + "  " + age);

		request.setAttribute(res, "testParamsAndHeaders");

		return SUCCESS;
	}

	/**
	 * 常用：使用method属性指定请求方式
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Author Yu Jinshui
	 * @createTime 2016年6月10日 下午12:22:51
	 */
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String input = request.getParameter("input");
		System.out.println("输入内容：" + input);
		request.setAttribute(res, "testMethod " + input);
		return SUCCESS;
	}

	@RequestMapping("/testSpringRequestMapping")
	public String testSpringRequestMapping(HttpServletRequest request) {
		request.setAttribute("res", "testSpringRequestMapping");
		System.out.println("testSpringRequestMapping");
		return SUCCESS;
	}

}
