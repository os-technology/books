package org.abstractpack;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: AbstractPersonClass
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/11/2下午7:14
 */

public abstract class AbstractPersonClass {

    public <T> T getResult(String text,Class<T> clazz){
        return JSONObject.parseObject(text,clazz);
    }

}
