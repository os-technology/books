package org.thiss;

/**
 * @author yuijnshui
 * @Title: ThisImplement
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/15下午5:03
 */
public class ThisImplement {
    private Registry registry;
    public ThisImplement(Registry registry){
        this.registry = registry;
    }

    public void outputThisResult(){
        System.out.println(registry.outThis());
    }
}
