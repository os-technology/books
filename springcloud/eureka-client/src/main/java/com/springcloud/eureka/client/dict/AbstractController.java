package com.springcloud.eureka.client.dict;

/**
 * @Author: Leo
 * @Blog: http://blog.csdn.net/lc0817
 * @CreateTime: 2017/3/27 10:47
 * @Description: 统一异常处理, 将controller继承该类, 即可.
 */
public abstract class AbstractController {


//    @ExceptionHandler({Exception.class})
//    public Map<String, String> exceptionHandler(Exception e, WebRequest req) {
//        System.err.println("=================");
//        System.err.println(req.toString());
//        System.err.println(req.getRemoteUser());
//        System.err.println(req.getContextPath());
//        System.err.println("=============");
//        Map<String, String> map = new HashMap<>();
//        map.put("code", "0");
//        map.put("msg", e.getMessage());
//        return map;
//    }
}
