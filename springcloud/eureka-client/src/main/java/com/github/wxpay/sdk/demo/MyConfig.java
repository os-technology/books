package com.github.wxpay.sdk.demo;


import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.lib.config.WXPayConfig;
import com.github.wxpay.sdk.WXPayDomain;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author yuijnshui
 * @Title: MyConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com/
 * @Created on 2018/8/3下午2:25
 */


public class MyConfig extends WXPayConfig {

    private byte[] certData;

    public MyConfig() throws Exception {
        String certPath = "/Users/yujinshui/Desktop/千丁互联/项目资料/微信公众号信息/cert/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public String getAppID() {
        return "wxd23d0632ad28c805";
    }

    public String getMchID() {
        return "1510598081";
    }

    public String getKey() {
        return "b141398d39584785900a3b0c1fd72057";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain() {
        return new WXPayDomain();
    }
}
