package com.github.wxpay.lib.pay_protocol;

/**
 * User: rizenguo
 * Date: 2014/10/22
 * Time: 21:29
 */

import com.github.wxpay.lib.config.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号服务商版统一下单接口需要提交的数据
 * URL：https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_1
 */
public class WeChatPayReqData {

    //每个字段具体的意思请查看API文档
    private String appid;
    private String mch_id;
    private String sub_appid;
    private String sub_mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String body;
    private String detail;
    private String attach;
    private String out_trade_no;
    private String fee_type = "CNY";
    private int total_fee;
    private String spbill_create_ip;
    private String time_start;
    private String time_expire;
    private String goods_tag;
    private String notify_url;
    private String trade_type = "JSAPI";
    private String product_id;
    private String limit_pay;
    private String openid;
    private String sub_openid;
    private Object scene_info;


    public WeChatPayReqData(WXPayConfig configure) {
        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(configure.getAppID());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(configure.getMchID());
    }


    public void generateSign(String key){
        //随机字符串，不长于32 位
        setNonce_str(WXPayUtil.generateNonceStr());
        //根据API给的签名规则进行签名
        String sign = null;
        try {
            sign = WXPayUtil.generateSignature(toMap(), key, WXPayConstants.SignType.HMACSHA256);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSign(sign);//把签名数据设置到Sign这个属性中
    }
    public String getAppid() {
        return appid;
    }

    public WeChatPayReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public WeChatPayReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public WeChatPayReqData setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public WeChatPayReqData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public WeChatPayReqData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public WeChatPayReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WeChatPayReqData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public WeChatPayReqData setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }

    public String getBody() {
        return body;
    }

    public WeChatPayReqData setBody(String body) {
        this.body = body;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public WeChatPayReqData setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public WeChatPayReqData setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WeChatPayReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public WeChatPayReqData setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public WeChatPayReqData setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public WeChatPayReqData setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
        return this;
    }

    public String getTime_start() {
        return time_start;
    }

    public WeChatPayReqData setTime_start(String time_start) {
        this.time_start = time_start;
        return this;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public WeChatPayReqData setTime_expire(String time_expire) {
        this.time_expire = time_expire;
        return this;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public WeChatPayReqData setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public WeChatPayReqData setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public WeChatPayReqData setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getProduct_id() {
        return product_id;
    }

    public WeChatPayReqData setProduct_id(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public WeChatPayReqData setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public WeChatPayReqData setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public WeChatPayReqData setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
        return this;
    }

    public Object getScene_info() {
        return scene_info;
    }

    public WeChatPayReqData setScene_info(Object scene_info) {
        this.scene_info = scene_info;
        return this;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), String.valueOf(obj));
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
