package com.create.beans.lakala.mts.params;

/**
 * 理财用户签约-请求参数
 * {URL}/fund/fund2SignUp.do
 *
 * @author yuijnshui@lxfintech.com
 * @Title: FundSignUp
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午12:06
 */

public class FundSignUp {
    /**银行预留手机号*/private String MobileInBank  ;
    /**手机号    */private String Mobile        ;
    /**状态     */private Integer State         ;
    /**证件类型   */private String IdentifierType;
    /**证件号码   */private String Identifier    ;
    /**客户名    */private String CustomerName  ;
    /**银行名称   */private String BankName      ;
    /**签约卡卡号  */private String AccountNo     ;
    /**产品代码   */private String ProductId     ;
    /**用户Id   */private String OrgUserId     ;
    /**商户代码   */private String ChMerCode     ;

}
