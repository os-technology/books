package com.github.wxpay.sdk;

import com.github.wxpay.lib.config.WXPayConfig;

/**
 * @author code
 * @Title: WXPayDomain
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/9下午2:12
 */
public class WXPayDomain implements IWXPayDomain {
    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {
        System.out.println("domain is :"+domain);
        System.out.println("elapsedTimeMillis = "+elapsedTimeMillis);

    }

    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API,true);
    }
}
