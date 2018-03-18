package com.create.beans.lakala.mts.params;

/**
 * 查询用户开户信息-请求参数
 * {URL}/fund/fundAccountQry.do
 * POST
 *
 * @author yuijnshui@lxfintech.com
 * @Title: FundAccountQry
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/14上午11:59
 */

public class FundAccountQry {
    /**产品代码*/private String     ProductId;
    /**用户id*/private String       OrgUserId ;
    /**用户手机号*/private String       Mobile    ;
    /**商户代码*/private String       ChMerCode ;

}
