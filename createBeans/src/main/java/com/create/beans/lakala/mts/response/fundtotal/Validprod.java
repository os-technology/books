package com.create.beans.lakala.mts.response.fundtotal;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Validprod
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午3:36
 */

public class Validprod extends BasicProd {
    /**收益率     */private String GrowthRate   ;
    /**期限      */private String LimitTime    ;
    /**用户总资产   */private String TotalAsset   ;
    /**昨日收益    */private String DayIncome    ;
    /**累计收益    */private String TotalIncome  ;
    /**万份收益    */private String IncomeW      ;
    /**清算时间    */private String ClearTime    ;
    /**到期赎回类型
     * 1转到钱包,2传到卡,3转到赚点钱(考拉2号)，4自动续期  */private String BackType     ;
    /**是否可续期
     * 0-不可续期，1-可续期 */private String IsRenewal    ;
    /**保底收益率
     * （保险理财、考拉8号使用）保底收益率(百分之一) */private String MinProfit    ;
    /**保底收益    */private String BdProfit     ;
    /**产品加息    */private String RaiseRates   ;
    /**合同到期处理状态
     * 0-待处理 1-处理中 2-处理完成*/private String DealState    ;
    /**变现描述    */private String RedeemDesc   ;

}
