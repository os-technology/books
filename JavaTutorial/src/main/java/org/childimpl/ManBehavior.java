package org.childimpl;

/**
 * @author yuijnshui
 * @Title: ManBehavior
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/20下午4:37
 */
public class ManBehavior extends PersonParent{


    @Override
    protected String amusement(String in){
        return in+":喜欢玩游戏";
    }
}
