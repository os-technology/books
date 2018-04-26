package org.beans.response;

/**
 * 预下单返回对象
 * @author yuijnshui@lxfintech.com
 * @Title: HxbOrderResponse
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/8下午4:28
 */

public class HxbOrderResponse  extends HxbResponse{

    /**
     * 扩展字段
     * 支付机构返回（例如token等），在支付确认时再回传回去
     */
    private String extra;
}
