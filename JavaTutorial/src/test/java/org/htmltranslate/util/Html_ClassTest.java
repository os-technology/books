package org.htmltranslate.util;

import org.junit.Test;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程解析
 *
 * @author code
 * @Title: Html_ClassTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/2/38:57 PM
 */
public class Html_ClassTest {

    @Test
    public void getClassName() {

        HtmlFilterDataRequest request = getDataRequest();
        StringBuilder builder = txt2String("/Users/yujinshui/Desktop/ppt.txt");
        getResultDataList(builder.toString(), request, "ffmpeg -i", ".ts\r\n");
    }
    private HtmlFilterDataRequest getDataRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setHtmlStartRange("")
                .setHtmlEndRange("")
                .setTranslateStart("<span class=\"components__list-title-index--N5FUk\">")
                .setTranslateEnd("</div>");
        return request;
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
    private StringBuilder txt2String(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
//            InputStream inputStream = this.getClass().getResourceAsStream(fileName);
            InputStream inputStream = new FileInputStream(new File(fileName));
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));//构造一个BufferedReader类来读取文件
            String s;
            while ((s = br.readLine()) != null) {

                builder.append(s.replaceAll("\t\t\t\t\t\t\t</span>","-").replaceAll("\t\t\t\t\t\t",""))
//                        .append("\r\n")
                ;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder;
    }
}
