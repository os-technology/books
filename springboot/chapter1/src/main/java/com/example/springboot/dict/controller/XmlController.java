package com.example.springboot.dict.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.dict.bean.BundingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * xml  https://blog.csdn.net/dmw412724/article/details/75106254
 *
 * @author yuijnshui@lxfintech.com
 * @Title: XmlController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/12上午9:29
 */

@Controller
public class XmlController {

    @RequestMapping(value = "/xmlPrase", headers = {"content-type=application/xml"})
    @ResponseBody
    public String addUser(@RequestBody BundingBean xml) {
        System.out.println(JSON.toJSONString(xml));
        return "success";
    }

    /* 请求参数demo：
    请求头：content-type=application/xml
    <xml>
    <toUserName><![CDATA[1]]></toUserName>
    <fromUserName><![CDATA[2]]></fromUserName>
    <createTime>3</createTime>
    <msgType><![CDATA[4]]></msgType>
    <event><![CDATA[5]]></event>
    <deviceType><![CDATA[6]]></deviceType>
    <deviceID><![CDATA[7]]></deviceID>
    <content><![CDATA[8]]></content>
    <sessionID>9</sessionID>
    <openID><![CDATA[10]]></openID>
</xml>
     */
}
