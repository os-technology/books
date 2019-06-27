package com.notes.boot.dict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author code
 * @Title: OuterController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/26上午11:47
 */
@RestController
public class OuterController {

    /**
     * http://localhost:8095/junit/wechat/receive
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("wechat/receive")
    public void receiveData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String xml = readRequestBody(request);
        System.out.println(xml);
        String success = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<xml>\n" +
                "<return_msg>SUCCESS</return_msg>\n" +
                "<return_code>SUCCESS</return_code>\n" +
                "</xml>\n";
        writeToStream(response, success);
    }


    public void writeToStream(HttpServletResponse response, String result) throws IOException {
        response.setHeader("Content-type", "text/plain;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(result.getBytes());
        out.flush();
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
