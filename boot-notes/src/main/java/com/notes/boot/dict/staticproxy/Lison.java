package com.notes.boot.dict.staticproxy;

/**
 * @author code
 * @Title: Lison
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/38:53 AM
 */
public class Lison implements ManToolsFactory {
    ManToolsFactory factory;

    public Lison(ManToolsFactory factory) {
        this.factory = factory;
    }

    @Override
    public void saleManTools(String size) {
        doSthBefore();//前置增强
        factory.saleManTools(size);
        doSthEnd();//后置增强
    }

    private void doSthEnd() {
        System.out.println("根据您的需求，进行相应的市场调研和需求确认");
    }

    private void doSthBefore() {
        System.out.println("精美包装一条龙服务");
    }
}
