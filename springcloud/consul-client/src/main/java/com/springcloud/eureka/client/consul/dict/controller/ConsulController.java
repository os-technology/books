package com.springcloud.eureka.client.consul.dict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yuijnshui@lxfintech.com
 * @Title: ConsulController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/20下午5:47
 */

@RestController
public class ConsulController {
    @RequestMapping("/")
    public String root() {
        return "Hello consul root";
    }
    @RequestMapping("/consul/client")
    public String home() {
        return "Hello consul";
    }
}
