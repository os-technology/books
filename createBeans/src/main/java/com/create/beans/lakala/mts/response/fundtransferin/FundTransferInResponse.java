package com.create.beans.lakala.mts.response.fundtransferin;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: FundTransferInResponse
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午12:14
 */

public class FundTransferInResponse {
    /**拉卡拉用户Id */private String  UserId      ;
    /**交易金额    */private String  Amount      ;
    /**外部商户唯一编号*/private String  ChSid       ;
    /**拉卡拉订单号  */private String  Lkl_OrderNo ;
    /**理财系统订单号 */private String  Merc_OrderNo;
    /**理财系统合同ID*/private String  ContractId  ;
    /**交易确认时间  */private String  ConfirmTime ;
    /**附加信息    */private String  Attach      ;
    /**请求Id    */private String  RequestId   ;

}
