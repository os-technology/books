package com.notes.boot.dict.staticproxy;

import com.notes.boot.dict.dynamic.BbFactory;
import com.notes.boot.dict.dynamic.LisonCompany;
import com.notes.boot.dict.dynamic.WomanToolsFactory;

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
//        staticproxy();
        dynamicproxy();

    }

    private static void dynamicproxy() {
        //A公司生产男性用品
        ManToolsFactory manFactory = new AaFactory();
        //B公司生产女性用品
        WomanToolsFactory womanFactory = new BbFactory();
        //lison成立了一个代购公司
        LisonCompany company = new LisonCompany();
        //张三找lison，代购男性用品
        company.setFactory(manFactory);
        //一号员工比较熟悉该业务，被委派去进行服务
        ManToolsFactory lison1 = (ManToolsFactory) company.getProxyInstance();
        //一号员工为他服务，完成代购
        lison1.saleManTools("D");
        System.out.println("--------------------");
        //张三的老婆找lison，代购女性用品
        company.setFactory(womanFactory);
        //二号员工比较熟悉该领域，被委派进行代购服务
        WomanToolsFactory lison2 = (WomanToolsFactory) company.getProxyInstance();
        //二号员工为他服务，完成代购
        lison2.saleWomanTools(1.8f);


    }

    private static void staticproxy() {
        //1. 从前有个日本公司生产娃娃，质量不错
        ManToolsFactory factory = new AaFactory();
        //2. lison老师代理这个公司的产品
        Lison lison = new Lison(factory);
        //3. 张三有需求来找我，买了一个D size的娃娃
        lison.saleManTools("D");
    }
}
