package com.create.beans.lakala.mts.response.fundprodlist;

/***
 * 产品数据返回
 * 如果SearchType=0，这里返回所有产品;如果SearchType=1，返回首购专享产品
 *
 * @author yuijnshui@lxfintech.com
 * @Title: Prod
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/10上午11:12
 */

public class Prod {
    /**产品编号       **/private String ProductId;
    /**产品名称       **/private String ProdName;
    /**产品类型       **/private String ProdType;
    /**发行期数       **/private String Period;
    /**期数名称       **/private String PeriodName;
    /**中途可变现      **/private String ToCash;
    /**产品状态       **/private String ProdState;
    /**是否推荐产品     **/private String IsRecom;
    /**债权包url     **/private String Url;
    /**单笔上限       **/private String UnitMax;
    /**单笔下限       **/private String UnitMin;
    /**可变现日期(开始)  **/private String LiquiStart;
    /**可变现日期(结束)  **/private String LiquiEnd;
    /**变现年化利率     **/private String RyRate;
    /**产品标识       **/private String Ident;
    /**是否指定手机购买   **/private String IsDesign;
    /**APP上使用的显示模版**/private String AppModel;
    /**期限         **/private String LimitTime;
    /**起购金额       **/private String StartAmout;
    /**递增金额       **/private String IncAmount;
    /**收益率        **/private String GrowthRate;
    /**开放时间       **/private String OpenTime;
    /**倒计时标识      **/private String CountDownFlag;
    /**开放时间       **/private String CountDownTime;
    /**备注         **/private String Remark;
    /**到息日        **/private String EndTime;
    /**起息日        **/private String StartTime;
    /**收益方式       **/private String IncomeType;
    /**剩余可投资金额    **/private String SurplusAmount;
    /**万份收益       **/private String IncomeW;
    /**产品归属       **/private String ProductOwner;
    /**产品类型名称     **/private String ProdTypeName;
    /**是否定期       **/private String IsRegular;
    /**风险等级       **/private String RiskLevel;
    /**是否随存随取     **/private String IsAnytime;
    /**计息周期       **/private String IntrsPeriod;
    /**收益率        **/private String YearProfit;
    /**犹豫期        **/private String WaverDate;
    /**保底收益       **/private String MinProfit;
    /**是否单笔下限整数倍  **/private String IsIntegral;
    /**是否可续期      **/private String IsRenewal;
    /**产品分类       **/private String CateGoryType;
    /**产品加息       **/private String RaiseRates;


}
