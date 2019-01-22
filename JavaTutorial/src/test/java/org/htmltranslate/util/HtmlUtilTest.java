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
    public void getHtml(){
        String url = "http://kdjghb.p9ydy.cn/pf/sx/tiantian.php?from=groupmessage&isappinstalled=0";
        String html = HtmlUtil.getHtmlByUrl(url);
        System.out.println(html);
    }

    @Test
    public void testGetHtml() {
        String url = "https://www.juzimi.com/tags/%E5%88%9B%E4%B8%9A";
        HtmlFilterDataRequest request = getRequest();
        String site="";
        for (int i = 0; i < 30; i++) {//分页
            System.out.println("########第" + i + "页#########");
            if (i > 0) {
                site = url + "?page=" + i;
            }else {
                site=url;
            }
            String html = HtmlUtil.getHtmlByUrl(site);
            ArrayList<String> result = HtmlUtil.getDataListFromHTML("", html, request);

            for (String output : result) {
                System.out.println(output.trim());
                System.out.println();
            }
        }
    }


    private HtmlFilterDataRequest getRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setUrl("https://www.juzimi.com/tags/%E5%88%9B%E4%B8%9A")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<div class=\"xqfamwritercount\">")
                .setHtmlEndRange("<div class=\"item-list\">")
                .setTranslateStart("data=\"{'text':'")
                .setTranslateEnd("','url':'https://www.juzimi.com/ju/");


        return request;
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
