package com.create.beans.lakala.mts.params;

/**
 * 理财产品清单请求
 *
 * @author yuijnshui@lxfintech.com
 * @Title: ProdListQry
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/8下午4:33
 */

public class ProdListQry {

    /**
     * 查询类型<br>
     * 可空，如果为空则表示0；
     * 0：一个列表返回所有产品
     * 1：按产品类型分类列表返回产品
     */
    private int SearchType;
    /**
     * 商户代码
     */
    private String ChMerCode;

    public int getSearchType() {
        return SearchType;
    }

    public ProdListQry setSearchType(int searchType) {
        SearchType = searchType;
        return this;
    }

    public String getChMerCode() {
        return ChMerCode;
    }

    public ProdListQry setChMerCode(String chMerCode) {
        ChMerCode = chMerCode;
        return this;
    }
}
