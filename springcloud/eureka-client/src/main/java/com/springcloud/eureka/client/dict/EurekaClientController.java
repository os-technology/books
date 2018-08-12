package com.springcloud.eureka.client.dict;

import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPayUtil;
import com.github.wxpay.sdk.WXPayXmlUtil;
import com.springcloud.eureka.client.util.HxbDecodeUtil;
import com.springcloud.eureka.client.util.JXMConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DcController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/16下午5:36
 */
@RestController
public class EurekaClientController extends AbstractController {


    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/wechat/notify")
    public String callback(@RequestBody String notifyXml) {
        if (notifyXml != null && !notifyXml.isEmpty()) {

            try {
                Map<String, String> map = WXPayUtil.xmlToMap(notifyXml);
                System.out.println(JSON.toJSONString(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "<xml>\n" +
                "\n" +
                "   <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "   <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
    }

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @RequestMapping("/hxb")
    public String testRequest(HttpServletRequest request) throws Exception {
        String platformCode = (String) request.getHeader("PlatformCode");
//        BufferedReader br = request.getReader();
//
//        String str, wholeStr = "";
//        while((str = br.readLine()) != null){
//            wholeStr += str;
//        }
//        System.out.println(wholeStr);

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

    @RequestMapping("/hxb/res")
    public String testResponse(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();

        String str, wholeStr = "";
        while ((str = br.readLine()) != null) {
            wholeStr += str;
        }
        System.out.println(wholeStr);

        return "OK";
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

    @RequestMapping("/hello")
    public String home() {
        return "Hello world";
    }

    @RequestMapping("/eurekaclient")
    public String client() {
        return "Hello eureka-client";
    }
}
