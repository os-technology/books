package com.springcloud.eureka.client.dict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DcController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/16下午5:36
 */
@RestController
@RequestMapping("test/")
public class TmpHttpClientController extends AbstractController{


    @RequestMapping("/json")
    public String json(HttpServletRequest request) throws Exception {
        String json = readRequestBody(request);

        System.out.println("接收的内容为："+json);
        return json;
    }

    private String readRequestBody(HttpServletRequest request) throws Exception {
        InputStream is = request.getInputStream();
        StringBuilder buf = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line = null;
        while ((line = br.readLine()) != null) {
            buf.append(line);
            buf.append('\n');
        }
        if (buf.length() > 0) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

}
