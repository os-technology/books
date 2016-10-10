package org.springmvc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.entity.User;

//@SessionAttributes(value = { "user" }, types = { String.class })
@RequestMapping("mapping")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS = "success";
	private static final String res = "res";

	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("test redirect");
		return "redirect:/output/result.jsp";
	}

	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(HttpServletRequest request) {
		System.out.println("view : testViewAndViewResolver");
		return SUCCESS;
	}

	/**
	 * 运行流程：<br>
	 * 1.执行@ModelAttribute 注解修饰的方法：从数据库中取出对象，把对象放到了map中，键为user<br>
	 * 2.SpringMVC从Map中取出User对象，并把表单的请求参数赋给该User对象对应的属性<br>
	 * 3.SpringMVC把上述对象传入目标方法的参数<br>
	 * 注意：在@ModelAttribute修饰的方法中，放入到Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致！
	 * 
	 * @param user
	 * @param request
	 * @return
	 * @Author yujinshui
	 * @createTime 2016年7月30日 上午11:19:28
	 */
	@RequestMapping("/testModelAttributes")
	public String testModelAttributes(User u, HttpServletRequest request) {
		request.setAttribute(res, "testModelAttributes修改：" + u);
		System.out.println("修改：" + u);
		String ip = getIpAddr(request);
		System.out.println("输出IP：" + ip);
		return SUCCESS;
	}

	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}

	/**
	 * 由@ModelAttribute标记的所有方法，会在每个目标方法执行之前被SpringmMVC调用
	 *
	 * @param id
	 * @param map
	 * @createTime 2016年6月15日 下午3:43:59
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		System.out.println("ModelAttribute Method");
		if (id != null) {
			// 模拟从数据库中获取对象
			User user = new User(1, "Tom", "12345", 12, "tom@126.com");
			System.out.println("从数据库中获取一个对象：" + user);

			map.put("user", user);

		}
	}

	/**
	 * @SessionAttributes(value = { "user" }, types = { String.class })
	 * 
	 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是value属性值)，
	 *                    还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是types属性值)。<br>
	 *                    注意：该注解只能放在类的上面，而不能用于修饰方法。
	 *
	 * @param map
	 * @return
	 * @createTime 2016年6月15日 下午3:12:11
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User("Tom", "12345", 12, "tom@126.com");
		map.put("user", user);
		map.put("school", "qingsoft");
		return SUCCESS;
	}

	/**
	 * 常用<br>
	 * 目标方法可以添加Map类型(实际上也可以是Model类型或ModelMap类型)的参数 {方法功能描述}
	 *
	 * @param map
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年6月15日 下午12:41:56
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		System.out.println(map.getClass().getName());
		map.put(res, Arrays.asList("Tom", "Jerry", "John", "Pola"));
		return SUCCESS;
	}

	/**
	 * 目标方法的返回值可以是ModelAndView 类型。<br>
	 * 其中可以包含视图和模型信息<br>
	 * springMVC 会把ModelAndView 的 model中数据放入request域对象中。
	 * 
	 * @createTime 2016年6月13日 下午6:41:55
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView view = new ModelAndView(viewName);
		view.addObject(res, "testModelAndView");
		return view;
	}

	/**
	 * <pre>
	 * 可以使用Servlet 原生的API作为目标方法的参数 具体支持以下类型<br>
	 * HttpServletRequest
	 * HttpServletResponse
	 * HttpSession
	 * java.security.Principal
	 * Locale
	 * InputStream
	 * OutputStream
	 * Reader
	 * Writer
	 * </pre>
	 * 
	 * @param request
	 * @param response
	 * @createTime 2016年6月13日 下午3:43:53
	 */
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute(res, "testServletAPI," + request + "," + response);
		return SUCCESS;
	}

	@RequestMapping("/testServletAPI_2")
	public void testServletAPI_2(HttpServletRequest request, HttpServletResponse response, Writer out)
			throws IOException {

		out.write("hello springmvc:testServletAPI_2");

	}

	/**
	 * Spring MVC
	 * 会按请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值。支持级联属性。如dept.deptId、dept.address.tel等。
	 * 
	 * @param user
	 * @param request
	 * @createTime 2016年6月13日 上午7:58:53
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		request.setAttribute(res, user);
		return SUCCESS;
	}

	/**
	 * 了解：
	 * 
	 * @CookieValue 映射一个cookie值。属性同@RequestParam
	 * @param sessionId
	 * @param request
	 * @createTime 2016年6月13日 上午7:35:25
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId, HttpServletRequest request) {
		request.setAttribute(res, sessionId);
		return SUCCESS;
	}

	/**
	 * 了解<br>
	 * 用法同@RequestParam
	 *
	 * @createTime 2016年6月12日 下午10:32:07
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "Cookie") String language, HttpServletRequest request) {

		request.setAttribute(res, language);
		return SUCCESS;
	}

	/**
	 * <pre>
	 * 重要
	 * &#64;RequestParam 来映射请求参数
	 * value 值即请求参数的参数名
	 * required 该参数是否必须 . 默认为true
	 * defaultValue 请求参数的默认值
	 * </pre>
	 * 
	 * @createTime 2016年6月12日 下午10:23:01
	 */
	@RequestMapping("/testRequestParams")
	public String testRequestParams(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age, HttpServletRequest request) {
		request.setAttribute(res, username + "  " + age);
		System.out.println(username);
		System.out.println(age);

		return SUCCESS;
	}

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
