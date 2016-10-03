package org.dubbo.provider.service.impl;

import org.dubbo.inter.api.HelloService;
import org.springframework.stereotype.Service;
@Service("hello")
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String input) {
		return "您输入的内容为：" + input;
	}

}
