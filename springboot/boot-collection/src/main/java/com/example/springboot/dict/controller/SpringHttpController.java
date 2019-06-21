package com.example.springboot.dict.controller;

import com.example.springboot.dict.SpringHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

/**
 * @author code
 * @Title: SpringHttpController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/164:29 PM
 */
@RestController
public class SpringHttpController {

    @Autowired
    private SpringHttpService springHttpService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("async")
    public Callable<String> asyncRequest(String userId) {

        //主线程
        System.out.println("主线程开始....."+Thread.currentThread()+"----"+System.currentTimeMillis());

        //子线程处理业务逻辑
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("子线程开始....."+Thread.currentThread()+"----"+System.currentTimeMillis());
                String user = springHttpService.getUserInfo(userId);
                System.out.println("子线程结束....."+Thread.currentThread()+"----"+System.currentTimeMillis());

                return user;
            }
        };

        System.out.println("主线程结束....."+Thread.currentThread()+"----"+System.currentTimeMillis());
        return callable;
    }

    @RequestMapping("springhttp")
    public String httpRequest() {


        ResponseEntity<String> response = restTemplate.getForEntity("http://dev.api.qdingnet.com/qds-payment-admin-web/statement/downloadBillTask?statementDate={date}", String.class, "20190603");
        System.out.println(response.getBody());
        return response.getBody();
    }
}
