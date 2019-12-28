package org.htmltranslate.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * TODO 是否过滤指定数据，拿到数据的基础上，同时过滤掉一部分额外的数据。
 * TODO 取数据通过数组方式拿到指定范围内的多组数据，而不仅仅是一组
 *
 * @author yuijnshui@lxfintech.com
 * @Title: HtmlUtilTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/22上午11:02
 */

public class HtmlUtilTest {


    @Test//https://www.kankanwu.com/play/index.php?id
    public void get庆余年() {
        String url = "https://www.25ys.com/vod/play/id/42070/sid/1/nid/";

        HtmlFilterDataRequest request = getQingYuNianRequest();
        String prefix = "ffmpeg -i ";
        String subfix = " -c copy 庆余年";
        int count = 44;
        getResultDataList(count, url, request, prefix, subfix);
    }

    private HtmlFilterDataRequest getQingYuNianRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
request.setHtmlStartRange("<div class=\"col-lg-wide-8 col-xs-1 padding-0\">")
        .setHtmlEndRange("src=\"/static/js/player.js\"></script>")
        .setTranslateStart("\"url\":\"")
        .setTranslateEnd("\",\"url_next\"");
        return request;
    }

    private List<String> getResultDataList(int count, String url, HtmlFilterDataRequest request, String prefixString, String subfixString) {
        for (int i = 41; i < count; i++) {
            String html = HtmlUtil.getHtmlByUrl(url + i + ".html", "utf-8");
            ArrayList<String> dataList = HtmlUtil.getDataListFromHTML("", html, request);
            final int val = i;
            dataList.stream().forEach(data -> {
                System.out.println(prefixString + data + subfixString + (val ) + ".ts");

            });
        }
        return null;
    }

    @Test
    public void getYanxiGonglve() {
        for (int i = 0; i < 70; i++) {
            String url = "https://www.kankanwu.com/Domestic/yanxigonglue/player-0-" + i + ".html";
            String html = HtmlUtil.getHtmlByUrl(url, "utf-8");
            HtmlFilterDataRequest request = getyanxiRequest();
            ArrayList<String> dataList = HtmlUtil.getDataListFromHTML("", html, request);
            final int val = i;
            dataList.stream().forEach(data -> {
//                data = data.substring(data.lastIndexOf("/"))
                System.out.println("ffmpeg -i " + data + " -c copy 延禧攻略" + (val + 1) + ".ts");

            });
        }
    }

    private HtmlFilterDataRequest getyanxiRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setHtmlStartRange("</tr></table></td></tr></table><iframe")
                .setHtmlEndRange("border=\"0\" marginwidth=\"0\"")
                .setTranslateStart("https://www.kankanwu.com/play/index.php?id=")
                .setTranslateEnd("\" frameborder=");

        return request;
    }


    @Test//https://www.kankanwu.com/Domestic/yanxigonglue/player-0-50.html
    public void getBurnNoticeDownloadUrl() {
        String url = "https://www.ed2000.com/ShowFile/430673.html";
        String html = HtmlUtil.getHtmlByUrl(url, "utf-8");
        //
        HtmlFilterDataRequest request = getBurnNoticeRequest();
        ArrayList<String> dataList = HtmlUtil.getDataListFromHTML("", html, request);

        dataList.stream().forEach(data -> {
            if (filter(data)) {
                System.out.println(data);
            }
        });

    }

    public boolean filter(String input) {
        boolean flag1 = ((input.contains("720X400") || input.contains("624X352")) && (input.contains("mp4") || input.contains("rmvb")));
        boolean flag2 = ((input.contains("720X396") || input.contains("512X384")) && input.contains("rmvb"));
        return flag1 || flag2;
    }

    private HtmlFilterDataRequest getBurnNoticeRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setHtmlStartRange("<td colspan=\"3\">eD2k链接</td>")
                .setHtmlEndRange("<input type=\"button\" value=\"下载选中的文件\"")
                .setTranslateStart("<td width=\"800\"><a href=\"")
                .setTranslateEnd("\">");
        return request;
    }

    /**
     * 长安十二时辰，下载地址获取
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void getDownloadUrl() throws ExecutionException, InterruptedException {//优化前：3342，1590，1357，1649，4409，1791


        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 41; i <= 42; i++) {
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
