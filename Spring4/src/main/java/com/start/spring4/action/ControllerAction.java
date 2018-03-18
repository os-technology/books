package com.start.spring4.action;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.start.spring4.entity.Person;

@Controller
@RequestMapping("hello")
public class ControllerAction {

	private String result = "result";

	@RequestMapping("/info")
	public String info(ModelMap model) {
		System.out.println("execute action");
		model.addAttribute("index", "Maven spring4 is ok");
		return result;
	}

	@RequestMapping("/person1")
	public String toPerson(Person p) {
		System.out.println(p.getName() + " " + p.getAge());
		return result;
	}

	@RequestMapping("/show")
	public String showValue(Map<String, Object> map) {
		Person p = new Person();
		p.setAge(21);
		p.setName("shui");
		map.put("p", p);
		return result;
	}

	@RequestMapping("/getPerson")
	public void ajax(String name, PrintWriter pw) {
		pw.write("输入结果为name:" + name);
	}

	@RequestMapping("/test")
	public String test(ModelMap model) {
		model.addAttribute("index", "test url is ok");
		return result;
	}

	// @ModelAttribute
	public void show() {
		System.out.println("show is ok");
	}

	@RequestMapping("/int")
	public String wrong() {
		Integer.parseInt("a");
		return result;
	}

}
