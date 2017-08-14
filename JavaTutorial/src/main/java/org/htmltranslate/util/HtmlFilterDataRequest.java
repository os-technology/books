package org.htmltranslate.util;

/**
 * html过滤参数请求
 *
 * @author yuijnshui@lxfintech.com
 * @Title: HtmlFilterDataRequest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/22上午10:33
 */

public class HtmlFilterDataRequest {
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
     * 解析开始位置
     */
    private String translateStart;
    /**
     * 解析结束位置
     */
    private String translateEnd;


    public String getUrl() {
        return url;
    }

    public HtmlFilterDataRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrlPageSuffix() {
        return urlPageSuffix;
    }

    public HtmlFilterDataRequest setUrlPageSuffix(String urlPageSuffix) {
        this.urlPageSuffix = urlPageSuffix;
        return this;
    }

    public String getHtmlStartRange() {
        return htmlStartRange;
    }

    public HtmlFilterDataRequest setHtmlStartRange(String htmlStartRange) {
        this.htmlStartRange = htmlStartRange;
        return this;
    }

    public String getHtmlEndRange() {
        return htmlEndRange;
    }

    public HtmlFilterDataRequest setHtmlEndRange(String htmlEndRange) {
        this.htmlEndRange = htmlEndRange;
        return this;
    }

    public String getTranslateStart() {
        return translateStart;
    }

    public HtmlFilterDataRequest setTranslateStart(String translateStart) {
        this.translateStart = translateStart;
        return this;
    }

    public String getTranslateEnd() {
        return translateEnd;
    }

    public HtmlFilterDataRequest setTranslateEnd(String translateEnd) {
        this.translateEnd = translateEnd;
        return this;
    }
}
