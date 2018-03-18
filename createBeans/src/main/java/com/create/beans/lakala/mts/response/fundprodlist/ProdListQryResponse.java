package com.create.beans.lakala.mts.response.fundprodlist;

import java.util.List;

/**
 * 理财产品清单返回
 *
 * @author yuijnshui@lxfintech.com
 * @Title: ProdListQryResponse
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/8下午4:35
 */

public class ProdListQryResponse {
    /**
     * 是否开户
     * 0:未开户
     * 1:已开户
     */
    private Integer foundFlag;
    /**
     * 签约卡卡号
     */
    private String accountNo;
    /**
     * 账户系统理财账号
     */
    private String finAcctId;
    /**
     * 理财平台交易账号
     */
    private String transAcctId;
    /**
     * 产品数据返回<br>
     * 如果SearchType=0，这里返回所有产品;如果SearchType=1，按产品类型分类列表返回产品<br>
     * 产品类型：<br>
     * 1 首购专享<br>
     * 2 灵活变现<br>
     * 3 浮动收益<br>
     * 4 固定收益<br>
     */
    private List<Prod> prodList;


}
