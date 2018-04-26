package org.beans.request;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HxbOrderConfirm
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/8下午5:46
 */

public class HxbOrderConfirm extends HxbDataContent{
    /**
     * 用户Id
     */
    private String UID;
    /**
     * 支付机构流水号 - C
     */
    private String pmcNo;
    /**
     * 短信验证码
     */
    private String msgCode;
    /**
     * 扩展字段-C
     */
    private String extra;
}
