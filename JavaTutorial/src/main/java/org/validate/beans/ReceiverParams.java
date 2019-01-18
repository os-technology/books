package org.validate.beans;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author code
 * @Title: ReceiverParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/18下午12:01
 */
public class ReceiverParams {
    @NotEmpty
    private String type;
    /**
     * 必填。分账接收方帐号
     */
    @NotEmpty
    private String account;

    public String getType() {
        return type;
    }

    public ReceiverParams setType(String type) {
        this.type = type;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public ReceiverParams setAccount(String account) {
        this.account = account;
        return this;
    }
}
