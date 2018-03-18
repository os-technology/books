package org.abstractpack;

import com.alibaba.fastjson.JSON;
import org.abstractpack.bean.Man;
import org.abstractpack.bean.Woman;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: PersonHandler
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/11/2下午7:16
 */

public class PersonHandler extends AbstractPersonClass {

    private Man getInstance(){
        Man man = new Man();

        return man.setAge(23).setHeight("1.83").setSex("boy");
    }

    public static void main(String[] args) {
        PersonHandler handler = new PersonHandler();

        Woman result =  handler.getResult(JSON.toJSONString(handler.getInstance()), Woman.class);
        System.out.println(result);
    }

}
