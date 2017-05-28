package com.create.beans.lakala.mts.response.fundtotal;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: BasicProd
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午3:28
 */

public class BasicProd {
    /**产品编号       */private String  ProductId    ;
    /**产品名称       */private String  ProdName     ;
    /**产品类型
     * 0-基金产品；1-拉卡拉自有理财产品 */private String  ProdType     ;
    /**产品状态
     * 0-待发售,1-发售中,2-停止发售,11-成立,12-成立失败,13-已到期,14-已结束  */private String  ProdState    ;
    /**发行期数       */private String  Period       ;
    /**期数名称       */private String  PeriodName   ;
    /**合同号        */private String  ContractId   ;
    /**是否可变现/赎回方式
     * 0-不可变现，其他可变现*/private String  RedeemType   ;
    /**债权包url     */private String  Url          ;
    /**单笔上限       */private String  UnitMax      ;
    /**单笔下限       */private String  UnitMin      ;
    /**可变现日期(开始)
     * (YYYY-MM-DD)*/private String  LiquiStart   ;
    /**可变现日期(结束)
     * (YYYY-MM-DD)*/private String  LiquiEnd     ;
    /**备注         */private String  Remark       ;
    /**是否在赎回期内
     * 0-否，1-是 */private String  IsRedeemDate ;
    /**到期时间       */private String  EndDate      ;
    /**到账时间
     * YYYY-MM-DD */private String  TransferDate ;
    /**产品期限
     * 建议持有期(单位天) */private String  IntrsPeriod  ;
    /**年化收益       */private String  YearProfit   ;
    /**APP上使用的显示模版*/private String  AppModel     ;
    /**本金         */private String  Principal    ;
    /**预计收益       */private String  PredictIncome;
    /**实际收益       */private String  Income       ;

}
