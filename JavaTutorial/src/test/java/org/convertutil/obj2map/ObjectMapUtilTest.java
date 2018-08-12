package org.convertutil.obj2map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author code
 * @Title: ObjectMapUtilTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/12上午10:48
 */
public class ObjectMapUtilTest {
    
    
    @Test
    public void testObject2Map(){
        ObjectMapBean bean = getBean();
        Map map = ObjectMapUtil.object2Map(bean);
        Assert.assertEquals(map.get("name"),"zhangsan");

        ObjectMapBean mapBean = ObjectMapUtil.map2Object(map, ObjectMapBean.class);
        Assert.assertEquals(mapBean.getAttr(),"属性");
    }

    private ObjectMapBean getBean() {
        ObjectMapBean bean = new ObjectMapBean();
        bean.setName("zhangsan");
        bean.setAttr("属性").setData("数据信息");

        return bean;
    }
}
