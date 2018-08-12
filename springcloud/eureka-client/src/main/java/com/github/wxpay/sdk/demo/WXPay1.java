package com.github.wxpay.sdk.demo;

import com.github.wxpay.sdk.MD5Util;
import com.github.wxpay.sdk.WXPayUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 微信调起支付类
 * 
 * @author Sunlight
 * 
 */
public class WXPay1 {



	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	public static String createSign(SortedMap<String, String> packageParams, String AppKey) throws Exception {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + AppKey);
		System.out.println("sb="+sb.toString());

		String sign = WXPayUtil.HMACSHA256(sb.toString(),AppKey).toUpperCase();
		return sign;
	}
}
