package com.create.beans.lakala.mts.response.fundtotal;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Validinsuprod
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午4:27
 */

public class Validinsuprod {
    /**产品编号      */private String  ProductId    ;
    /**产品名称      */private String  ProdName     ;
    /**产品类型
     * 0-基金产品；1-拉卡拉自有理财产品*/private String  ProdType     ;
    /**发行期数      */private String  Period       ;
    /**是否可变现/赎回方式
     * 0-不可变现，其他可变现*/private String  RedeemType   ;
    /**是否在犹豫期内
     * 内0-否，1-是*/private String  IsWaverDate  ;
    /**到期时间      */private String  EndDate      ;
    /**产品期限      */private String  IntrsPeriod  ;
    /**年化收益      */private String  YearProfit   ;
    /**预期收益      */private String  YQProfit     ;
    /**实际收益      */private String  Income       ;
    /**保单号       */private String  PolicyNo     ;
    /**订单号       */private String  Sid          ;
    /**总保费       */private String  TotalPremium ;
    /**保单价值      */private String  PolicyValue  ;
    /**发行状态
     * 0-待发售,1-发售中,2-停止发售,11-成立,12-成立失败,13-已到期,14-已结束*/private String  ProdState    ;
    /**期数名称      */private String  PeriodName   ;
    /**清算时间      */private String  ClearTime    ;
    /**保单状态
     * 1-已受理，2-保单生效，3-退保已受理，4-退保成功*/private String  PolicyState  ;
    /**起息日       */private String  StartInterest;
    /**持有时间      */private String  HoldDays     ;
    /**备注        */private String  Remark       ;

}
