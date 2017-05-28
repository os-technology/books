package com.create.beans.lakala.mts.response.fundaccount;

/**
 * 查询用户开户信息-返回参数
 * @author yuijnshui@lxfintech.com
 * @Title: FundAccountResponse
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午12:03
 */

public class FundAccountResponse {
    /**是否开户
     * 0:未开户
     1:已开户 */private Integer FoundFlag   ;
    /**银行名称    */private String BankName     ;
    /**产品代码    */private String ProductId    ;
    /**签约卡卡号   */private String AccountNo    ;
    /**账户系统理财账号*/private String FinAcctId    ;
    /**理财平台交易账号*/private String TransAcctId  ;
    /**签约手机号   */private String MobileInBank ;

}
