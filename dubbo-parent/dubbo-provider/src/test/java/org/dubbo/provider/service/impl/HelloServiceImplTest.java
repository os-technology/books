package org.dubbo.provider.service.impl;

import org.dubbo.inter.api.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:provider.xml"})
public class HelloServiceImplTest {
	@Autowired
	private HelloService helloService;

	@Test
	public void testgetToday() {
		String dateTime = helloService.getToday();
		System.out.println(dateTime);
		Assert.assertNotNull(dateTime);
	}

}
