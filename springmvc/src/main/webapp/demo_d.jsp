<%@ page import="java.io.IOException" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.security.spec.PKCS8EncodedKeySpec" %>
<%@ page import="java.security.KeyFactory" %>
<%@ page import="java.security.PrivateKey" %>
<%@ page import="sun.misc.BASE64Decoder" %>
<%@ page import="sun.misc.BASE64Encoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    /* *
     Paymax 聚合收银台demo
     * */
%>
<%!
    //编码必须使用UTF-8,因为服务端使用UTF-8解码
    public static final String CHARSET = "UTF-8";
    //Paymax提供给商户的SecretKey，登录网站后查看
    public static final String AUTHORIZATION = "b81363648c6d4ab2af3b8a95683353b2";
    //商户自己的私钥【用com.Paymax.sign.RSAKeyGenerateUtil生成RSA秘钥对，公钥通过Paymax网站上传到Paymax，私钥设置到下面的变量中】
    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJHl5gKLdkg1Wb1jiZ7nQABUxc2Oo0OdlziOzgUAwVB+C87jXvGuALFcpcihdcNonuMuJdg2tL8Nbwts7SZ/X/sXxPOkHxI9Raw3qt/T8/GIBoNOWz0W06ZXnKkSohgXxXgKN2yR+8tXwQNMJRQP162Y3ix/JOnLSScW9eJjDL3lAgMBAAECgYAuxAFhSXDFnoxAX7qKO9fRA1tQE2uTzdzeHTA+fEp60ZxZWZpiX4MLVwYw9Eg6NbvQWEd7MbXoE5dHk0fE8klCR8faRfrm0utc7hqhUZEZAQGsKYxBvuEln3qP6eH+e+tgT75drLU01l4yUrb7miLUsniSwSHECBqsmK9/jEFzoQJBANE3pwZNKSUCTX0A4hLiqb/dnaOZ9syUgTM8TKXxN3DFH4ftHPPT3SrTz+hJP0p/m+4yN7fnxAbrqI12v8M1dF0CQQCyhZ8F5uj8vnRkEp5eY5e5NgH2D9lXgbza9pQDeXxfFC6yJnc15xRvD9N77FPiyxYfjF3Bcagjjo94ybN5n9cpAkEAobVxTOaQ+cEI4aiwFMbLS7hgotZbMw9Jua9O0yhZoLlMQMSeDzxfgz3KQhFzcQKnJHn+JRBnrK2zTvxNBfYoJQJAL52ENMbKDd+em7J7myFlLnlBPKgtiDGKdbye7e5RRerUKaAo26+uu5C1D7CRD0Srue5uc1IlTpaPnd/uhtojQQJAG+lvtqRuCgoVRkoJj+7U0bc+TVc/pD8TQM9PakFPsScp01NvIoaiHdS1tLsjzXBpUycdQ2fXD5krlCEleK6XQQ==";

    /**
     * 签名加密算法
     * @param content       内容
     * @param privateKey    私钥
     * @return
     */
    public String sign(String content, String privateKey) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] result = decoder.decodeBuffer(privateKey);

            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(result);
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature
                    .getInstance("SHA1WithRSA");// 摘要加密算法;

            signature.initSign(priKey);
            signature.update(content.getBytes(CHARSET)); //数据

            byte[] signed = signature.sign();

            return new BASE64Encoder().encode(signed).replaceAll("[\\s*\t\n\r]", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 按照 Paymax 的签名要求,组装数据并签名
     * @param nonce
     * @param timestamp
     * @param authorization
     * @param request_data
     * @return
     * @throws IOException
     */
    public String signData(String nonce,Long timestamp, String authorization,String request_data) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write("POST".toLowerCase().getBytes(CHARSET)); //请求方法必须是POST
        out.write('\n');//method

        out.write("/js/charges".getBytes(CHARSET)); //请求URL固定为 "/js/charges"
        out.write('\n');//uri path
        out.write(nonce.getBytes(CHARSET)); //nonce:8~128位的随机字符串,由字⺟数字组成,不允许特殊字符
        out.write('\n');
        out.write(timestamp.toString().getBytes(CHARSET)); //timestamp:13位的时间戳,标准北京时间，时区为东⼋区，⾃1970年1⽉1⽇0点0分0秒 以来的毫秒数
        out.write('\n');
        out.write(authorization.getBytes(CHARSET));  //Authorization: 商户secretkey,Paymax 提供给商户的唯⼀标识,从Paymax商户后台的个⼈中⼼获取
        out.write('\n');
        byte[] data = request_data.getBytes(CHARSET); //request_data,请求数据对象,JSON格式，数据会放在POST请求request body中传输到后台
        out.write(data);//body
        out.close();
        String toSignString = out.toString(CHARSET);
        System.out.println("signData:"+toSignString);
        return sign(toSignString, PRIVATE_KEY);
    }

    public String generateUUID(){
        String str = UUID.randomUUID().toString();
        // 去掉"-"符号
        String temp = str.replaceAll("-","");
        return temp;
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">

    <title>Paymax demo</title>

    <!--Step 1. 嵌入Paymax JS SDK -->
    <%--<script type='text/javascript' src='http://172.30.8.57:9001/js/config?config=app_57194bC9Gy6Q23G5'></script>--%>
    <script type='text/javascript' src='http://dev2.paymax.cc/merchant-api/js/config?config=app_57194bC9Gy6Q23G5'></script>
    <%--<script type='text/javascript' src='https://www.paymax.cc/merchant-api/js/config?config=app_7hqF2S6GYXET457i'></script>--%>

</head>
<body>
<button id="charge">Paymax 体验支付</button>
</body>


<%
    //构造参数
    Map<String,Object> map = new java.util.HashMap();

    Map<String,String> extra = new java.util.HashMap();
    extra.put("return_url", "http://www.paymax.cc");
    extra.put("user_id", "100");
    extra.put("show_url", "http://www.paymax.cc");

    map.put("time_expire",(new Date().getTime()+10*60*1000));

    map.put("title","Paymax demo");
    map.put("subject","subject1");
    map.put("body","body1");
    map.put("amount",0.01);
    map.put("order_no", generateUUID());
    map.put("client_ip","127.0.0.1");
    map.put("extra",extra);

    String nonce = generateUUID();
    Long timestamp = new Date().getTime();
    //JSON格式数据
    String requestBody = JSONObject.toJSONString(map);
    System.out.println("requestBody:"+requestBody);
    //Step 2. 根据订单数据,生成支付参数,并且签名 sign
    //注:签名详细说明见Paymax集合收银台技术对接文档
    String sign = signData(nonce,timestamp,AUTHORIZATION,requestBody);
    System.out.println("sign:"+sign);
%>

<script type="text/javascript">
    document.getElementById("charge").onclick = function() {
        /**
         * Step 3. 用户确认支付的时候,出发按钮绑定的 Paymax.charge事件,传入参数
         * 注: sign,使用上面的签名值
         */
        Paymax.charge({
            "debug" : false,
            "Authorization": "<%= AUTHORIZATION %>",
            "nonce": "<%= nonce %>",
            "timestamp": "<%= timestamp %>",
            "sign": "<%= sign %>", //商品信息hash值
            "request_data" : <%= requestBody %>
        },{ wxJsApiFinish: function(response) {},
            wxJsApiSuccess: function(response) {},
            wxJsApiFail: function(response) {},
            dataError: function(msg) {}
        });

    };
</script>
</html>
