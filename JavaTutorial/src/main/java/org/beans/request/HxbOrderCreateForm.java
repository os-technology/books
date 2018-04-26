package org.beans.request;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HxbOrderCreateForm
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/8下午4:04
 */

public class HxbOrderCreateForm {
    //必填性说明：未说明或者M,代表必填；O,可以不填；C，如果商户填写了，则对应的参数返回需要添加。允许为空
    /**
     * 版本号
     * 1.0.0.0
     */
    private String version;
    /**
     * 商户号
     */
    private String mchtNo;
    /**
     * 二级商户号-暂不使用 -
     */
    @Deprecated
    private String subMchtNo;
    /**
     * 交易类型，不通接口通过此字段进行判断
     * 01 - 预下单接口，快捷发短信
     * 02 - 代扣
     * 03 - 交易确认接口
     * 04 - 交易状态查询
     */
    private String tradeType;
    /**
     * 加密数据类型 = xml
     */
    private String dataType;
    /**
     * 加密数据
     */
    private HxbDataContent dataContent;

}
