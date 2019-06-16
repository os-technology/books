package com.example.springboot.dict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @RequestMapping("springhttp")
    public String httpRequest(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://dev.api.qdingnet.com/qds-payment-admin-web/statement/downloadBillTask?statementDate={date}", String.class, "20190603");
        System.out.println(response.getBody());
        return response.getBody();
    }
}
