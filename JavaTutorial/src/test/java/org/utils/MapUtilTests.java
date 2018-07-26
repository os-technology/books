package org.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author yuijnshui
 * @Title: MapUtilTests
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/26下午2:01
 */
public class MapUtilTests {

    @Test
    public void testToMap(){
        BeanToMap bm = new BeanToMap();
        bm.setAttr("attrData").setName("beanToMap");
        Map<String, Object> result = MapUtil.toMap(bm);
        Assert.assertEquals("attrData",result.get("attr"));
    }
}

class BeanToMap{
    private String name;

    private String attr;

    public String getName() {
        return name;
    }

    public BeanToMap setName(String name) {
        this.name = name;
        return this;
    }

    public String getAttr() {
        return attr;
    }

    public BeanToMap setAttr(String attr) {
        this.attr = attr;
        return this;
    }
}