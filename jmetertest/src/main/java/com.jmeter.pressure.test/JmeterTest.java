package com.jmeter.pressure.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.IOException;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: JmeterTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/17下午5:47
 */

public class JmeterTest implements JavaSamplerClient {
    SampleResult sr =null;
    @Override
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        sr = new SampleResult();
    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        sr.sampleStart();
        int code = httpRequest();
        if (code == 200) {
            //设置响应数据为resutlData;也可以用sr.setSamplerData("OK");
            sr.setResponseData("success", null);
            //设置响应代码为0
            sr.setResponseCode("0000");
            //设置响应类型为text
            sr.setContentType(SampleResult.TEXT);
            //设置响应状态为true
            sr.setSuccessful(true);
            //设置响应信息
            sr.setResponseMessage("方法执行成功！");
        } else {
            sr.setResponseData("failure", null);
            //设置响应代码为-9999
            sr.setResponseCode("-9999");
            //设置响应类型为txt
            sr.setContentType(SampleResult.TEXT);
            //设置响应状态为true
            sr.setSuccessful(false);
            //设置响应信息
            sr.setResponseMessage("方法执行失败！");
        }
        return sr;
    }

    @Override
    public void teardownTest(JavaSamplerContext javaSamplerContext) {

    }

    @Override
    public Arguments getDefaultParameters() {
        return null;
    }


    private int httpRequest() {
        CloseableHttpClient httpCilent2 = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)   //设置连接超时时间
                .setConnectionRequestTimeout(5000) // 设置请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();
        HttpGet httpGet2 = new HttpGet("http://localhost:2111/eurekaclient");
        httpGet2.setConfig(requestConfig);
        String srtResult = "";
        int code = 0;
        try {
            HttpResponse httpResponse = httpCilent2.execute(httpGet2);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                srtResult = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
                System.out.println(srtResult);
                code = httpResponse.getStatusLine().getStatusCode();
            } else if (httpResponse.getStatusLine().getStatusCode() == 400) {
                //..........
            } else if (httpResponse.getStatusLine().getStatusCode() == 500) {
                //.............
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpCilent2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return code;
    }
}
