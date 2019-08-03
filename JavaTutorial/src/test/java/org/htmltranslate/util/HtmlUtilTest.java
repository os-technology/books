package org.htmltranslate.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.concurrent.*;

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
    public void getDownloadUrl() throws ExecutionException, InterruptedException {//优化前：3342，1590，1357，1649，4409，1791


        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 28; i <= 35; i++) {
            long time = System.currentTimeMillis();
            String url = "http://www.meijuniao.com/dianshiju/changanshiershichen/2-" + i + ".html";
            if (i == 0) continue;
//            urlArray[i] = url;


            Callable<ArrayList<String>> playUrl = () -> {
                String html = HtmlUtil.getHtmlByUrl(url, "utf-8");
                HtmlFilterDataRequest request = getHtmlFilterDataRequest();
                //拿到播放器地址
                ArrayList<String> playUrlList = HtmlUtil.getDataListFromHTML("http://g.shumafen.cn/api/user/file_jx.php?secret=f3a81974b27a414a&id=", html, request);

                return playUrlList;
            };

            FutureTask<ArrayList<String>> playUrlTask = new FutureTask<>(playUrl);

            pool.submit(playUrlTask);


            Callable<ArrayList<String>> downloadUrl = () -> {
                ArrayList<String> result = playUrlTask.get();
                String htmlContent = HtmlUtil.getHtmlByUrl(result.get(0), "utf-8");
                HtmlFilterDataRequest request = getDownloadBillDataRequest();
                //获取下载地址
                return HtmlUtil.getDataListFromHTML("", htmlContent, request);
            };

            FutureTask<ArrayList<String>> downloadUrlTask = new FutureTask<>(downloadUrl);

            pool.submit(downloadUrlTask);


            System.out.println(URLDecoder.decode(downloadUrlTask.get().get(0)));

//            System.out.println("耗时：" + (System.currentTimeMillis() - time));
        }


    }

    private HtmlFilterDataRequest getDownloadBillDataRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setHtmlStartRange("<script type=\"text/javascript\">")
                .setHtmlEndRange("poster=\"/dplayer/loading.gif")
                .setTranslateStart("<video src=\"")
                .setTranslateEnd("\" controls=\"controls\"");
        return request;
    }

    private HtmlFilterDataRequest getHtmlFilterDataRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setHtmlStartRange("id=\"zanpiancms_player\">")
                .setHtmlEndRange("<script src=\"/player/gqyun.js\"></script></div>")
                .setTranslateStart("{\"url\":\"")
                .setTranslateEnd("\",\"copyright\":null,\"name\":\"gqyun\"");


        return request;
    }

    @Test
    public void getHtml() {
        String url = "http://www.ygdy8.net/html/gndy/dyzz/index.html";
        String html = HtmlUtil.getHtmlByUrl(url, "GB2312");
        System.out.println(html);
    }

    @Test
    public void testGetHtml() {
        HtmlFilterDataRequest request = getRequest();
        String html = HtmlUtil.getHtmlByUrl("http://www.ygdy8.net/html/gndy/dyzz/20190306/58284.html", "GB2312");
        ArrayList<String> result = HtmlUtil.getDataListFromHTML("", html, request);
        System.out.println(JSON.toJSONString(result));
    }

    private HtmlFilterDataRequest getRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        //注释部分的参数因为用不到，但是为了让读者更好的理解，所以没有删除
        request//.setUrl("")
                // .setUrlPageSuffix("")
                // .setHtmlStartRange("<div class=\"co_content8\">")
                // .setHtmlEndRange("<td height=\"25\" align=\"center\" bgcolor=\"#F4FAE2\">")
                .setTranslateStart("<td style=\"WORD-WRAP: break-word\" bgcolor=\"#fdfddf\"><a href=\"")
                .setTranslateEnd("\">ftp://ygdy8");


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
