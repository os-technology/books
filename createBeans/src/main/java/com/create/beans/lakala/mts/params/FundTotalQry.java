package com.create.beans.lakala.mts.params;

/**
 * 资产查询-请求参数
 * @author yuijnshui@lxfintech.com
 * @Title: FundTotalQry
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14下午12:10
 */

public class FundTotalQry {
    /**是否只查定期资产
     * 0-查定期和活期资产，1-只查定期资产。默认为0*/private String  IsRegular;
    /**用户Id    */private String OrgUserId ;
    /**手机号     */private String Mobile    ;
    /**商户代码    */private String ChMerCode ;

}
