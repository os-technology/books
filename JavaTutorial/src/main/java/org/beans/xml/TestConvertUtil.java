package org.beans.xml;

import com.alibaba.fastjson.JSON;
import org.beans.response.HxbResponse;

import java.util.Map;

/**
 * https://blog.csdn.net/aqsunkai/article/details/52196645
 * @author yuijnshui@lxfintech.com
 * @Title: TestConvertUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/9下午1:42
 */

public class TestConvertUtil {

    public static void main(String[] args) {
        HxbResponse response = new HxbResponse();
        response.setMchtNo("mchNO")
                .setDealResult("success")
                .setRemark("备注");
        Map<String, Object> map = JXMConvertUtil.JsonConvertHashMap(JSON.toJSON(response));
        System.out.println(map);
    }

}
