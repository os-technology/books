package com.notes.boot.dict.staticproxy;

/**
 * @author code
 * @Title: ClientTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/39:16 AM
 */
public class ClientTest {

    public static void main(String[] args) {
        //1. 从前有个日本公司生产娃娃，质量不错
        ManToolsFactory factory = new RealFactory();
        //2. lison老师代理这个公司的产品
        Lison lison = new Lison(factory);
        //3. 张三有需求来找我，买了一个D size的娃娃
        lison.saleManTools("D");
    }
}
