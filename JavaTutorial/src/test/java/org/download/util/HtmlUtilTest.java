package org.download.util;

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
        HtmlFilterDataRequest request = getValue();
        String html = HtmlUtil.getHtmlByUrl(request.getUrl());
        ArrayList<String> result = HtmlUtil.getDataListFromHTML("", html, request);
        Assert.assertTrue(result.size() > 0);

        for (String output : result) {
            System.out.println(output);
        }
    }

    public HtmlFilterDataRequest getValue() {

        HtmlFilterDataRequest request = new HtmlFilterDataRequest();

        request.setUrl("http://www.fzbyy.cc/Dianshiju/146089.html")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<div id=\"yjishu2\">\n")
                .setHtmlEndRange("<script>echoDown(1);</script>")
                .setTranslateStart("\"><a href=\"")
                .setTranslateEnd("\" title=\"第");


        return request;
    }
}
