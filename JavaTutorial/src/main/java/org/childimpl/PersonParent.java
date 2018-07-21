package org.childimpl;

/**
 * @author yuijnshui
 * @Title: PersonParent
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/20下午4:33
 */
public abstract class PersonParent {


    public String action(String info){
        return amusement(info);
    }

    /**
     *娱乐
     * @author code
     * @date 2018/7/20 下午4:36
     * @param
     * @return void
     */
    protected abstract String amusement(String in);
}
