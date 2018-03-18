package org.fastjson.bean.comparebean;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SonCls
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/11/15下午6:52
 */

public class SonCls extends ParentCls{


    private String age;

    private  String height;

    private String mobile;

    private String remark;

    public String getAge() {
        return age;
    }

    public SonCls setAge(String age) {
        this.age = age;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public SonCls setHeight(String height) {
        this.height = height;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public SonCls setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public SonCls setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
