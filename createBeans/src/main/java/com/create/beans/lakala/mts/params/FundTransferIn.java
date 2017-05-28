package com.create.beans.lakala.mts.params;

import java.math.BigDecimal;

/**
 * 理财申购
 * {URL}/fundTransferIn.do
 *
 * @author yuijnshui@lxfintech.com
 * @Title: FundTransferIn
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午12:08
 */

public class FundTransferIn {
    /**联想用户Id    */private String  OrgUserid     ;
    /**商户代码      */private String  ChMerCode     ;
    /**产品代码      */private String  ProductId     ;
    /**期数        */private String  Period        ;
    /**联想金融商户唯一编号*/private String  ChSid         ;
    /**订单申请时间，14位。
     格式：yyyyMMddHHmmss      */private String  ApplyTime     ;
    /**申购卡号      */private String  CardNo        ;
    /**申购金额      */private BigDecimal Amount        ;
    /**附加信息      */private String  Attach        ;
    /**银行预留手机号   */private String  MoBileInBank  ;
    /**手机号       */private String  Mobile        ;
    /**状态        */private Integer  State         ;
    /**证件类型      */private String  IdentifierType;
    /**证件号码      */private String  Identifier    ;
    /**客户名       */private String  CustomerName  ;
    /**银行名称      */private String  BankName      ;
    /**签约卡卡号     */private String  AccountNo     ;


}
