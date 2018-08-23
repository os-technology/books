package com.springcloud.eureka.client.dict;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springcloud.eureka.client.beans.User;
import com.springcloud.eureka.client.util.HxbDecodeUtil;
import com.springcloud.eureka.client.util.JXMConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 单元测试专用
 *
 * @author yuijnshui@lxfintech.com
 * @Title: DcController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/16下午5:36
 */
@RestController
public class EurekaClientForJunitController {


    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/findClient")
    public String dc() {
        String services = String.valueOf(discoveryClient.getServices());
        System.out.println(services);
        return services;
    }
    @RequestMapping("/hello")
    public String home() {
        return "Hello world";
    }


    @RequestMapping("/hxb")
    public String testRequest(HttpServletRequest request) throws Exception {


        Map<String, Object> parameterMap = getStringObjectMap(request);
        System.out.println(JSON.toJSONString(parameterMap));

        String dataContent = parameterMap.get("dataContent").toString();
        if (dataContent != null) {
            String base64DecodeResData = HxbDecodeUtil.getHXBEntryDataStr(dataContent);
            String jsonResData = JXMConvertUtil.XmlConvertJson(base64DecodeResData);

            System.out.println(jsonResData);
        }

        return "OK";
    }

    @RequestMapping("/string")
    public String string(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();

        String str, wholeStr = "";
        while ((str = br.readLine()) != null) {
            wholeStr += str;
        }
        System.out.println(wholeStr);

        return wholeStr;
    }

    @RequestMapping("/defineParam")
    public String defineParam(Integer id, String name) throws IOException {

        return id + name;
    }

    @RequestMapping("/json")
    public String json(HttpServletResponse response, User user) throws IOException {
        response.addHeader("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        System.out.println(JSON.toJSONString(user));
        return "success";
    }

    @RequestMapping("/getModelAndViewUser")
    @ResponseBody
    public ModelAndView getUser( User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",user);
        return modelAndView;
    }

    /**
     * 解析请求参数为Map类型
     *
     * @param request
     * @return
     */
    private Map<String, Object> getStringObjectMap(HttpServletRequest request) {
        Map properties = request.getParameterMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name;
        String value;
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    parameterMap.put(name, values[i]);
                }
            }
        }
        return parameterMap;
    }




}
