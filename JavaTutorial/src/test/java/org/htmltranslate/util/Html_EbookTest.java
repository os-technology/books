package org.htmltranslate.util;

import org.junit.Test;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 电子书下载
 *
 * @author code
 * @Title: Html_EbookTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/1/298:59 AM
 */
public class Html_EbookTest {

    private String ShaGuaShiTouZi = "<div data-v-e10e8554=\"\" class=\"iframe-wrap\"><div data-v-e10e8554=\"\" class=\"iframe-cover\"></div><iframe name=\"epubCon_0\" id=\"epubCon_0\" src=\"/api/epub/ebook/chapter/39071/zxsy_20171011918044580794990592/OEBPS/Text/cover.xhtml\" width=\"100%\" height=\"1311\" style=\"display: block;\"></iframe><iframe name=\"epubCon_1\" id=\"epubCon_1\" src=\"/api/epub/ebook/chapter/39072/zxsy_20171011918044580794990592/OEBPS/Text/copyright.xhtml\" width=\"100%\" height=\"264\" style=\"display: block;\"></iframe><iframe name=\"epubCon_2\" id=\"epubCon_2\" src=\"/api/epub/ebook/chapter/39073/zxsy_20171011918044580794990592/OEBPS/Text/chapter1.xhtml\" width=\"100%\" height=\"1105\" style=\"display: block;\"></iframe><iframe name=\"epubCon_3\" id=\"epubCon_3\" src=\"/api/epub/ebook/chapter/39074/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0001.xhtml\" width=\"100%\" height=\"1921\" style=\"display: block;\"></iframe><iframe name=\"epubCon_4\" id=\"epubCon_4\" src=\"/api/epub/ebook/chapter/39075/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0002.xhtml\" width=\"100%\" height=\"1040\" style=\"display: block;\"></iframe><iframe name=\"epubCon_5\" id=\"epubCon_5\" src=\"/api/epub/ebook/chapter/39076/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0003.xhtml\" width=\"100%\" height=\"1360\" style=\"display: block;\"></iframe><iframe name=\"epubCon_6\" id=\"epubCon_6\" src=\"/api/epub/ebook/chapter/39077/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0004.xhtml\" width=\"100%\" height=\"95\" style=\"display: block;\"></iframe><iframe name=\"epubCon_7\" id=\"epubCon_7\" src=\"/api/epub/ebook/chapter/39078/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0004_0001.xhtml\" width=\"100%\" height=\"2949\" style=\"display: block;\"></iframe><iframe name=\"epubCon_8\" id=\"epubCon_8\" src=\"/api/epub/ebook/chapter/39079/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0005.xhtml\" width=\"100%\" height=\"15119\" style=\"display: block;\"></iframe><iframe name=\"epubCon_9\" id=\"epubCon_9\" src=\"/api/epub/ebook/chapter/39080/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0006.xhtml\" width=\"100%\" height=\"5957\" style=\"display: block;\"></iframe><iframe name=\"epubCon_10\" id=\"epubCon_10\" src=\"/api/epub/ebook/chapter/39081/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0007.xhtml\" width=\"100%\" height=\"95\" style=\"display: block;\"></iframe><iframe name=\"epubCon_11\" id=\"epubCon_11\" src=\"/api/epub/ebook/chapter/39082/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0007_0001.xhtml\" width=\"100%\" height=\"11963\" style=\"display: block;\"></iframe><iframe name=\"epubCon_12\" id=\"epubCon_12\" src=\"/api/epub/ebook/chapter/39083/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0008.xhtml\" width=\"100%\" height=\"95\" style=\"display: block;\"></iframe><iframe name=\"epubCon_13\" id=\"epubCon_13\" src=\"/api/epub/ebook/chapter/39084/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0008_0001.xhtml\" width=\"100%\" height=\"8625\" style=\"display: block;\"></iframe><iframe name=\"epubCon_14\" id=\"epubCon_14\" src=\"/api/epub/ebook/chapter/39085/zxsy_20171011918044580794990592/OEBPS/Text/chapter1_0009.xhtml\" width=\"100%\" height=\"1721\" style=\"display: block;\"></iframe><p data-v-e10e8554=\"\" class=\"epub-loading\" style=\"color: rgb(19, 19, 19); font-size: 1.1rem; display: none;\"><span data-v-e10e8554=\"\" class=\"nextLoading loadBlack\"></span>正在加载下一章\n" +
            "        </p><div data-v-e10e8554=\"\" class=\"epub-buy\" style=\"display: none;\">\n" +
            "          立即购买\n" +
            "        </div></div>";

    private String QianShengQian = "<div data-v-e10e8554=\"\" class=\"iframe-wrap\"><div data-v-e10e8554=\"\" class=\"iframe-cover\"></div><iframe name=\"epubCon_0\" id=\"epubCon_0\" src=\"/api/epub/ebook/chapter/39216/zxsy_20171011918044603599421440/OEBPS/Text/cover.xhtml\" width=\"100%\" height=\"1311\" style=\"display: block;\"></iframe><iframe name=\"epubCon_1\" id=\"epubCon_1\" src=\"/api/epub/ebook/chapter/39217/zxsy_20171011918044603599421440/OEBPS/Text/copyright.xhtml\" width=\"100%\" height=\"264\" style=\"display: block;\"></iframe><iframe name=\"epubCon_2\" id=\"epubCon_2\" src=\"/api/epub/ebook/chapter/39218/zxsy_20171011918044603599421440/OEBPS/Text/aboutxq.xhtml\" width=\"100%\" height=\"168\" style=\"display: block;\"></iframe><iframe name=\"epubCon_3\" id=\"epubCon_3\" src=\"/api/epub/ebook/chapter/39219/zxsy_20171011918044603599421440/OEBPS/Text/author.xhtml\" width=\"100%\" height=\"144\" style=\"display: block;\"></iframe><iframe name=\"epubCon_4\" id=\"epubCon_4\" src=\"/api/epub/ebook/chapter/39220/zxsy_20171011918044603599421440/OEBPS/Text/preface.xhtml\" width=\"100%\" height=\"544\" style=\"display: block;\"></iframe><iframe name=\"epubCon_5\" id=\"epubCon_5\" src=\"/api/epub/ebook/chapter/39221/zxsy_20171011918044603599421440/OEBPS/Text/foreword.xhtml\" width=\"100%\" height=\"475\" style=\"display: block;\"></iframe><iframe name=\"epubCon_6\" id=\"epubCon_6\" src=\"/api/epub/ebook/chapter/39222/zxsy_20171011918044603599421440/OEBPS/Text/chapter01.xhtml\" width=\"100%\" height=\"506\" style=\"display: block;\"></iframe><iframe name=\"epubCon_7\" id=\"epubCon_7\" src=\"/api/epub/ebook/chapter/39223/zxsy_20171011918044603599421440/OEBPS/Text/c01.xhtml\" width=\"100%\" height=\"604\" style=\"display: block;\"></iframe><iframe name=\"epubCon_8\" id=\"epubCon_8\" src=\"/api/epub/ebook/chapter/39224/zxsy_20171011918044603599421440/OEBPS/Text/c02.xhtml\" width=\"100%\" height=\"3090\" style=\"display: block;\"></iframe><iframe name=\"epubCon_9\" id=\"epubCon_9\" src=\"/api/epub/ebook/chapter/39225/zxsy_20171011918044603599421440/OEBPS/Text/c03.xhtml\" width=\"100%\" height=\"8208\" style=\"display: block;\"></iframe><iframe name=\"epubCon_10\" id=\"epubCon_10\" src=\"/api/epub/ebook/chapter/39226/zxsy_20171011918044603599421440/OEBPS/Text/c04.xhtml\" width=\"100%\" height=\"1672\" style=\"display: block;\"></iframe><iframe name=\"epubCon_11\" id=\"epubCon_11\" src=\"/api/epub/ebook/chapter/39227/zxsy_20171011918044603599421440/OEBPS/Text/c05.xhtml\" width=\"100%\" height=\"2137\" style=\"display: block;\"></iframe><iframe name=\"epubCon_12\" id=\"epubCon_12\" src=\"/api/epub/ebook/chapter/39228/zxsy_20171011918044603599421440/OEBPS/Text/c06.xhtml\" width=\"100%\" height=\"2072\" style=\"display: block;\"></iframe><iframe name=\"epubCon_13\" id=\"epubCon_13\" src=\"/api/epub/ebook/chapter/39229/zxsy_20171011918044603599421440/OEBPS/Text/chapter02.xhtml\" width=\"100%\" height=\"506\" style=\"display: block;\"></iframe><iframe name=\"epubCon_14\" id=\"epubCon_14\" src=\"/api/epub/ebook/chapter/39230/zxsy_20171011918044603599421440/OEBPS/Text/c07.xhtml\" width=\"100%\" height=\"1634\" style=\"display: block;\"></iframe><iframe name=\"epubCon_15\" id=\"epubCon_15\" src=\"/api/epub/ebook/chapter/39231/zxsy_20171011918044603599421440/OEBPS/Text/c08.xhtml\" width=\"100%\" height=\"1305\" style=\"display: block;\"></iframe><iframe name=\"epubCon_16\" id=\"epubCon_16\" src=\"/api/epub/ebook/chapter/39232/zxsy_20171011918044603599421440/OEBPS/Text/c09.xhtml\" width=\"100%\" height=\"764\" style=\"display: block;\"></iframe><iframe name=\"epubCon_17\" id=\"epubCon_17\" src=\"/api/epub/ebook/chapter/39233/zxsy_20171011918044603599421440/OEBPS/Text/c10.xhtml\" width=\"100%\" height=\"2878\" style=\"display: block;\"></iframe><iframe name=\"epubCon_18\" id=\"epubCon_18\" src=\"/api/epub/ebook/chapter/39234/zxsy_20171011918044603599421440/OEBPS/Text/c11.xhtml\" width=\"100%\" height=\"1098\" style=\"display: block;\"></iframe><iframe name=\"epubCon_19\" id=\"epubCon_19\" src=\"/api/epub/ebook/chapter/39235/zxsy_20171011918044603599421440/OEBPS/Text/c12.xhtml\" width=\"100%\" height=\"1551\" style=\"display: block;\"></iframe><iframe name=\"epubCon_20\" id=\"epubCon_20\" src=\"/api/epub/ebook/chapter/39236/zxsy_20171011918044603599421440/OEBPS/Text/c13.xhtml\" width=\"100%\" height=\"444\" style=\"display: block;\"></iframe><iframe name=\"epubCon_21\" id=\"epubCon_21\" src=\"/api/epub/ebook/chapter/39237/zxsy_20171011918044603599421440/OEBPS/Text/c14.xhtml\" width=\"100%\" height=\"2702\" style=\"display: block;\"></iframe><iframe name=\"epubCon_22\" id=\"epubCon_22\" src=\"/api/epub/ebook/chapter/39238/zxsy_20171011918044603599421440/OEBPS/Text/chapter03.xhtml\" width=\"100%\" height=\"506\" style=\"display: block;\"></iframe><iframe name=\"epubCon_23\" id=\"epubCon_23\" src=\"/api/epub/ebook/chapter/39239/zxsy_20171011918044603599421440/OEBPS/Text/c15.xhtml\" width=\"100%\" height=\"2121\" style=\"display: block;\"></iframe><iframe name=\"epubCon_24\" id=\"epubCon_24\" src=\"/api/epub/ebook/chapter/39240/zxsy_20171011918044603599421440/OEBPS/Text/c16.xhtml\" width=\"100%\" height=\"3996\" style=\"display: block;\"></iframe><iframe name=\"epubCon_25\" id=\"epubCon_25\" src=\"/api/epub/ebook/chapter/39241/zxsy_20171011918044603599421440/OEBPS/Text/chapter04.xhtml\" width=\"100%\" height=\"506\" style=\"display: block;\"></iframe><iframe name=\"epubCon_26\" id=\"epubCon_26\" src=\"/api/epub/ebook/chapter/39242/zxsy_20171011918044603599421440/OEBPS/Text/c17.xhtml\" width=\"100%\" height=\"6340\" style=\"display: block;\"></iframe><iframe name=\"epubCon_27\" id=\"epubCon_27\" src=\"/api/epub/ebook/chapter/39243/zxsy_20171011918044603599421440/OEBPS/Text/c18.xhtml\" width=\"100%\" height=\"3967\" style=\"display: block;\"></iframe><iframe name=\"epubCon_28\" id=\"epubCon_28\" src=\"/api/epub/ebook/chapter/39244/zxsy_20171011918044603599421440/OEBPS/Text/copyright2.xhtml\" width=\"100%\" height=\"530\" style=\"display: block;\"></iframe><p data-v-e10e8554=\"\" class=\"epub-loading\" style=\"color: rgb(19, 19, 19); font-size: 1.1rem; display: none;\"><span data-v-e10e8554=\"\" class=\"nextLoading loadBlack\"></span>正在加载下一章\n" +
            "        </p><div data-v-e10e8554=\"\" class=\"epub-buy\" style=\"display: none;\">\n" +
            "          立即购买\n" +
            "        </div></div>";

    @Test// 手把手教你钱生钱（雪球岛系列） https://v.yunpub.cn/reader/ebook/1615028780781639
    public void getQianShengQian() {

        HtmlFilterDataRequest request = getShaGuaShiTouZiRequest();
        getResultDataList(QianShengQian, request, "https://v.yunpub.cn", null);
    }


    @Test// 傻瓜式投资（雪球岛系列） https://v.yunpub.cn/reader/ebook/1615028780781639
    public void getShaGuaShiTouZi() {

        HtmlFilterDataRequest request = getShaGuaShiTouZiRequest();
        getResultDataList(ShaGuaShiTouZi, request, "https://v.yunpub.cn", null);
    }

    private HtmlFilterDataRequest getShaGuaShiTouZiRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setHtmlStartRange("")
                .setHtmlEndRange("")
                .setTranslateStart("src=\"")
                .setTranslateEnd("\" width=\"100%\"");
        return request;
    }

    private List<String> getResultDataList(int startIndex, int count, String url, HtmlFilterDataRequest request, String prefixString, String subfixString) {
        for (int i = startIndex; i < count; i++) {
            String html = HtmlUtil.getHtmlByUrl(url + i + ".html", "utf-8");
            ArrayList<String> dataList = HtmlUtil.getDataListFromHTML("", html, request);
            final int val = i;
            dataList.stream().forEach(data -> {
                System.out.println(prefixString + URLDecoder.decode(data).replaceAll("\\\\", "") + subfixString + (val) + ".ts");

            });
        }
        return null;
    }

    /**
     * @param html         HTML字符串
     * @param request      数据截取对象
     * @param prefixString 前缀
     * @param subfixString 后缀
     * @return
     */
    private List<String> getResultDataList(String html, HtmlFilterDataRequest request, String prefixString, String subfixString) {

        ArrayList<String> dataList = HtmlUtil.getDataListFromHTML("", html, request);

        dataList.stream().forEach(data -> {
            System.out.println((prefixString == null ? "" : prefixString) + URLDecoder.decode(data) + (subfixString == null ? "" : subfixString));

        });

        return null;
    }
}
