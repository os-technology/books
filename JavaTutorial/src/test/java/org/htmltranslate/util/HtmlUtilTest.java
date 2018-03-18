package org.htmltranslate.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HtmlUtilTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/22上午11:02
 */

public class HtmlUtilTest {

    @Test
    public void testGetHtml() {
        HtmlFilterDataRequest request = getWeChatValue();
        String html = HtmlUtil.getHtmlByUrl(request.getUrl());
        ArrayList<String> result = HtmlUtil.getDataListFromHTML("", html, request);
        Assert.assertTrue(result.size() > 0);

        for (String output : result) {
            System.out.println(output.trim());
        }
    }




    public HtmlFilterDataRequest getValue() {

        HtmlFilterDataRequest request = new HtmlFilterDataRequest();

        request.setUrl("http://y5.wda333.com/trend/chart/49")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<div id=\"yjishu2\">\n")
                .setHtmlEndRange("<script>echoDown(1);</script>")
                .setTranslateStart("\"><a href=\"")
                .setTranslateEnd("\" title=\"第");


        return request;
    }

    public HtmlFilterDataRequest getWeChatValue() {

        HtmlFilterDataRequest request = new HtmlFilterDataRequest();

        request.setUrl("https://mp.weixin.qq.com/s?__biz=MzI0MTIxNTkwNg==&mid=2649454919&idx=2&sn=26c5c3ee9a2539ef368b520ebb790b81&chksm=f111298ac666a09ce14a9baa4f2ac93d34870da93d80011668ad951903123941274622237aa9&mpshare=1&scene=23&srcid=0811Q33ITvqz3iVBd4a7e8qh#rd")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<div id=\"page-content\" class=\"rich_media_area_primary\">\n")
                .setHtmlEndRange("<em id=\"post-date\" class=\"rich_media_meta rich_media_meta_text\">")
                .setTranslateStart("<h2 class=\"rich_media_title\" id=\"activity-name\">\n")
                .setTranslateEnd("</h2>\n");


        return request;
    }



}
