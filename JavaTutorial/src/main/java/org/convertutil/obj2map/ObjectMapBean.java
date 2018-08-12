package org.convertutil.obj2map;

/**
 * @author code
 * @Title: ObjectMapBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/12上午10:42
 */
public class ObjectMapBean extends ObjectMapParBean {


    private String attr;
    private String data;


    public String getAttr() {

        return attr;
    }

    public ObjectMapBean setAttr(String attr) {
        this.attr = attr;
        return this;
    }

    public String getData() {
        return data;
    }

    public ObjectMapBean setData(String data) {
        this.data = data;
        return this;
    }
}
