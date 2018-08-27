package com.github.wxpay.sdk.demo;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yuijnshui
 * @Title: WXPayExample
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com/
 * @Created on 2018/8/3下午2:26
 */
public class WXPayExample {
    public static void main(String[] args) throws Exception {

        createOrder();
//        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
//        System.out.println("b141398d39584785900a3b0c1fd72057".toUpperCase());
    }

    private static void sandbox() throws Exception {
        MyConfig config = new MyConfig();
//        WXPay wxpay = new WXPay(config, WXPayConstants.SignType.MD5Util, true);
    }

    private static void downloadBill() throws Exception{
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("bill_date", "20140603");
        data.put("bill_type", "ALL");

        try {
            Map<String, String> resp = wxpay.downloadBill(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void refundQuery() throws Exception{
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595900000012");

        try {
            Map<String, String> resp = wxpay.refundQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     *订单查询
     * @author code
     * @date 2018/8/3 下午2:31
     * @param
     * @return void
     */
    private static void orderQuery() throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595900000012");

        try {
            Map<String, String> resp = wxpay.orderQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 统一下单
     * @author code
     * @date 2018/8/3 下午2:29
     * @param
     * @return void
     */
    private static void createOrder() throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);
        //appid,mch_id,nonce_str,sign_type,sign
        Map<String, String> data = new HashMap<String, String>();
//        data.put("","");
        data.put("sub_mch_id","1511458511");
        data.put("body", "2");
        data.put("out_trade_no", "2016090910595900000012");
//        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "127.0.0.1");
        data.put("notify_url", "http://e60c36d9.ngrok.io/wechat/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
//        data.put("trade_type", "JSAPI");  // 此处指定为扫码支付
//        data.put("openid", "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
//        data.put("product_id", "12");

        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
