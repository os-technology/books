package com.notes.boot.dict.staticproxy;

/**
 * 真正提供服务的类
 *
 * @author code
 * @Title: AaFactory
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/38:54 AM
 */
public class AaFactory implements ManToolsFactory {
    @Override
    public void saleManTools(String size) {
        System.out.println("您购买了一个尺寸为 " + size + " 的女模特");
    }
}
