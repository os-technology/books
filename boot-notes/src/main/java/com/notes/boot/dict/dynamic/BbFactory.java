package com.notes.boot.dict.dynamic;

/**
 * @author code
 * @Title: BbFactory
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/410:07 PM
 */
public class BbFactory implements WomanToolsFactory {
    @Override
    public void saleWomanTools(float length) {
        System.out.println("根据您的需求，定制了一个高度为 "+length+" 的男模特");
    }
}
