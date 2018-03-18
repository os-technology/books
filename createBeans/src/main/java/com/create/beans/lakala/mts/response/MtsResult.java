package com.create.beans.lakala.mts.response;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: MtsResult
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/10上午11:01
 */

public class MtsResult<T> {
    /**
     * 返回码
     * 交易成功返回TS0000
     */
    private String _ReturnCode;
    /**
     * 返回信息
     */
    private String _ReturnMsg;
    /**
     * 业务数据
     */
    private T _ReturnData;

    public String get_ReturnCode() {
        return _ReturnCode;
    }

    public MtsResult set_ReturnCode(String _ReturnCode) {
        this._ReturnCode = _ReturnCode;
        return this;
    }

    public String get_ReturnMsg() {
        return _ReturnMsg;
    }

    public MtsResult set_ReturnMsg(String _ReturnMsg) {
        this._ReturnMsg = _ReturnMsg;
        return this;
    }

    public T get_ReturnData() {
        return _ReturnData;
    }

    public MtsResult set_ReturnData(T _ReturnData) {
        this._ReturnData = _ReturnData;
        return this;
    }
}
