package com.example.springboot;

import com.example.springboot.dict.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//SpringBootTest注解中，如果不在三层目录以内，需要指定class类名称
@SpringBootTest(classes = SpringbootApplicationTests.class)
@WebAppConfiguration//controller接口测试，需要添加该注解
public class SpringbootApplicationTests {


	private MockMvc mvc;
	@Before
	public void setUp(){
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

	}

	@Test
	public void getBoot() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/boot").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello boot")));

	}

}
