package org.thiss;

/**
 * @author yuijnshui
 * @Title: RegistrySupport
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/15下午5:03
 */
public class RegistrySupport implements Registry {


    public RegistrySupport(String var1){

    }
    private ThisImplement thisImplement = new ThisImplement(this);
    @Override
    public String reg(String var1) {
        return "hello,this";
    }

    @Override
    public String outThis() {
        return "outThis data";
    }

    public static void main(String[] args) {
        RegistrySupport support = new RegistrySupport("");
        support.thisImplement.outputThisResult();
    }
}
