package org.convertutil.fastjson;

import com.alibaba.fastjson.JSON;
import org.convertutil.fastjson.bean.comparebean.ParentCls;
import org.convertutil.fastjson.bean.comparebean.SonCls;
import org.junit.Test;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ClsTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/11/15下午6:54
 */

public class ClsTest {

    //完整匹配
    private String json1 = "{\"age\":\"12\",\"height\":\"180\",\"mobile\":\"1380000\",\"name\":\"John\",\"remark\":\"备注1\",\"sex\":\"男\"}";

    //匹配一部分，有遗漏且包含其他内容
    private String json2 = "{\"age\":\"12\",\"height\":\"180\",\"code\":\"1380000\",\"name\":\"John\",\"remark\":\"备注1\",\"sex\":\"男\"}";

    //匹配一部分，有遗漏
    private String json3 = "{\"age\":\"12\",\"height\":\"180\",\"name\":\"John\",\"remark\":\"备注1\",\"sex\":\"男\"}";

    //完全匹配，且多出一部分内容
    private String json4 = "{\"code\":\"8859\",\"age\":\"12\",\"height\":\"180\",\"mobile\":\"1380000\",\"name\":\"John\",\"remark\":\"备注1\",\"sex\":\"男\"}";
    @Test
    public void testParentClsConvertResult(){
        SonCls result = JSON.parseObject(json1, SonCls.class);
        System.out.println(JSON.toJSONString(result));
          result = JSON.parseObject(json2, SonCls.class);
        System.out.println(JSON.toJSONString(result));
          result = JSON.parseObject(json3, SonCls.class);
        System.out.println(JSON.toJSONString(result));
          result = JSON.parseObject(json4, SonCls.class);
        ParentCls parentCls = JSON.parseObject(json4, ParentCls.class);
        System.out.println(JSON.toJSONString(parentCls));
    }

    @Test
    public void testParentClsConvert(){
        SonCls cls = getValue();
        String sonCls = JSON.toJSONString(cls);
        System.out.println(sonCls);
    }

    private SonCls getValue(){
        SonCls cls =new SonCls();
        cls.setAge("12")
                .setHeight("180")
                .setMobile("1380000")
                .setRemark("备注1")
                .setName("John")
                .setSex("男");

        return cls;
    }

}
