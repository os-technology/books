package com.example.springboot.dict.controller;

import com.example.springboot.app.BootCollectionApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author code
 * @Title: HttpSpringTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/164:45 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootCollectionApplication.class)
public class HttpSpringTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void httpTest(){
//        ResponseEntity<String> response = restTemplate.getForEntity("http://dev.api.qdingnet.com/qds-payment-admin-web/statement/downloadBillTask?statementDate={date}", String.class, "20190603");
//        System.out.println("返回结果："+response.getBody());
//        Assert.assertEquals(200,response.getStatusCode().value());

        ResponseEntity<String> response = restTemplate.getForEntity("http://dev.api.qdingnet.com/qds-payment-admin-web/notify/wechat/receive",String.class);
        System.out.println("返回结果："+response.getBody());
        Assert.assertEquals(200,response.getStatusCode().value());

    }
}
