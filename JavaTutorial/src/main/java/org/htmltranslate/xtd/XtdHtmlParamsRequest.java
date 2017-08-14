package org.htmltranslate.xtd;

/**
 * 新天地参数配置
 *
 * @author yuijnshui@lxfintech.com
 * @Title: XtdHtmlParamsRequest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/30上午10:24
 */

public class XtdHtmlParamsRequest {
    /**
     * 网站地址
     */
    private String url;
    /**
     * 网址页码和后缀名
     */
    private String urlPageSuffix;

    /**
     * HTML抓取开始位置
     */
    private String htmlStartRange;
    /**
     * HTML抓取结束位置
     */
    private String htmlEndRange;
    /**
     * 解析期号开始位置
     */
    private String translateStart_stage;
    /**
     * 解析期号结束位置
     */
    private String translateEnd_stage;


    /**
     * 解析万位开始位置
     */
    private String translateStart_myriabit;
    /**
     * 解析万位结束位置
     */
    private String translateEnd_myriabit;

    /**
     * 解析千位开始位置
     */
    private String translateStart_kilobit;
    /**
     * 解析千位结束位置
     */
    private String translateEnd_kilobit;

    /**
     * 解析百位开始位置
     */
    private String translateStart_hundreds;
    /**
     * 解析百位结束位置
     */
    private String translateEnd_hundreds;

    /**
     * 解析十位开始位置
     */
    private String translateStart_decade;
    /**
     * 解析十位结束位置
     */
    private String translateEnd_decade;

    /**
     * 解析个位开始位置
     */
    private String translateStart_unit;
    /**
     * 解析个位结束位置
     */
    private String translateEnd_unit;

    private String tmpHtmlStartRange;
    private String tmpHtmlEndRange;


    public String getTmpHtmlStartRange() {
        return tmpHtmlStartRange;
    }

    public XtdHtmlParamsRequest setTmpHtmlStartRange(String tmpHtmlStartRange) {
        this.tmpHtmlStartRange = tmpHtmlStartRange;
        return this;
    }

    public String getTmpHtmlEndRange() {
        return tmpHtmlEndRange;
    }

    public XtdHtmlParamsRequest setTmpHtmlEndRange(String tmpHtmlEndRange) {
        this.tmpHtmlEndRange = tmpHtmlEndRange;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public XtdHtmlParamsRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrlPageSuffix() {
        return urlPageSuffix;
    }

    public XtdHtmlParamsRequest setUrlPageSuffix(String urlPageSuffix) {
        this.urlPageSuffix = urlPageSuffix;
        return this;
    }

    public String getHtmlStartRange() {
        return htmlStartRange;
    }

    public XtdHtmlParamsRequest setHtmlStartRange(String htmlStartRange) {
        this.htmlStartRange = htmlStartRange;
        return this;
    }

    public String getHtmlEndRange() {
        return htmlEndRange;
    }

    public XtdHtmlParamsRequest setHtmlEndRange(String htmlEndRange) {
        this.htmlEndRange = htmlEndRange;
        return this;
    }

    public String getTranslateStart_stage() {
        return translateStart_stage;
    }

    public XtdHtmlParamsRequest setTranslateStart_stage(String translateStart_stage) {
        this.translateStart_stage = translateStart_stage;
        return this;
    }

    public String getTranslateEnd_stage() {
        return translateEnd_stage;
    }

    public XtdHtmlParamsRequest setTranslateEnd_stage(String translateEnd_stage) {
        this.translateEnd_stage = translateEnd_stage;
        return this;
    }

    public String getTranslateStart_myriabit() {
        return translateStart_myriabit;
    }

    public XtdHtmlParamsRequest setTranslateStart_myriabit(String translateStart_myriabit) {
        this.translateStart_myriabit = translateStart_myriabit;
        return this;
    }

    public String getTranslateEnd_myriabit() {
        return translateEnd_myriabit;
    }

    public XtdHtmlParamsRequest setTranslateEnd_myriabit(String translateEnd_myriabit) {
        this.translateEnd_myriabit = translateEnd_myriabit;
        return this;
    }

    public String getTranslateStart_kilobit() {
        return translateStart_kilobit;
    }

    public XtdHtmlParamsRequest setTranslateStart_kilobit(String translateStart_kilobit) {
        this.translateStart_kilobit = translateStart_kilobit;
        return this;
    }

    public String getTranslateEnd_kilobit() {
        return translateEnd_kilobit;
    }

    public XtdHtmlParamsRequest setTranslateEnd_kilobit(String translateEnd_kilobit) {
        this.translateEnd_kilobit = translateEnd_kilobit;
        return this;
    }

    public String getTranslateStart_hundreds() {
        return translateStart_hundreds;
    }

    public XtdHtmlParamsRequest setTranslateStart_hundreds(String translateStart_hundreds) {
        this.translateStart_hundreds = translateStart_hundreds;
        return this;
    }

    public String getTranslateEnd_hundreds() {
        return translateEnd_hundreds;
    }

    public XtdHtmlParamsRequest setTranslateEnd_hundreds(String translateEnd_hundreds) {
        this.translateEnd_hundreds = translateEnd_hundreds;
        return this;
    }

    public String getTranslateStart_decade() {
        return translateStart_decade;
    }

    public XtdHtmlParamsRequest setTranslateStart_decade(String translateStart_decade) {
        this.translateStart_decade = translateStart_decade;
        return this;
    }

    public String getTranslateEnd_decade() {
        return translateEnd_decade;
    }

    public XtdHtmlParamsRequest setTranslateEnd_decade(String translateEnd_decade) {
        this.translateEnd_decade = translateEnd_decade;
        return this;
    }

    public String getTranslateStart_unit() {
        return translateStart_unit;
    }

    public XtdHtmlParamsRequest setTranslateStart_unit(String translateStart_unit) {
        this.translateStart_unit = translateStart_unit;
        return this;
    }

    public String getTranslateEnd_unit() {
        return translateEnd_unit;
    }

    public XtdHtmlParamsRequest setTranslateEnd_unit(String translateEnd_unit) {
        this.translateEnd_unit = translateEnd_unit;
        return this;
    }
}
