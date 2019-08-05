package com.notes.boot.dict.xml;

/**
 * @author code
 * @Title: BaseResponseBeans
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/11下午12:00
 */
public class BaseResponseBeans extends BaseRequestBeans {
    //协议层
    private String return_code;
    private String return_msg;

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    /**
     * 业务结果
     */
    private String result_code;
    /**
     * 错误代码
     */
    private String err_code;
    /**
     * 错误代码描述
     */
    private String err_code_des;

    public String getReturn_code() {
        return return_code;
    }

    public BaseResponseBeans setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public BaseResponseBeans setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public BaseResponseBeans setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public BaseResponseBeans setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public BaseResponseBeans setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }
}
