package com.create.beans.lakala.mts.response.fundtotal;

import java.math.BigDecimal;

/**
 * 资产查询-返回参数
 * @author yuijnshui@lxfintech.com
 * @Title: FundTotalResponse
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午1:52
 */

public class FundTotalResponse {
    /**用户总资产*/private BigDecimal TotalAsset    ;
    /**昨日收益 */private BigDecimal  DayIncome     ;
    /**累计收益 */private BigDecimal  TotalIncome  ;
    /**预计收益 */private BigDecimal  EstimateIncome;

}
