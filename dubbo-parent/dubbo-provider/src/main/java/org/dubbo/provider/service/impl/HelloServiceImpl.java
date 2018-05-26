package org.dubbo.provider.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dubbo.inter.api.HelloService;
import org.springframework.stereotype.Service;
@Service//("helloService")
//@com.alibaba.dubbo.config.annotation.Service//(interfaceName = "helloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String input) {
		return "您输入的内容为：" + input;
	}

	@Override
	public String getToday() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		return sdf.format(date);
	}

}
