package org.download.util;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HtmlUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/22上午10:26
 */

public class HtmlUtil {

    /**
     * @param url           网站地址
     * @param urlPageSuffix 网址页码和后缀名
     * @return
     */
    public static StringBuffer getStringFromUrl(String url, String urlPageSuffix) {


        return null;

    }


    /**
     * 获取网站源码[核心方法1]
     *
     * @param webSiteUrl 网站地址
     * @return
     */
    public static String getHtmlByUrl(String webSiteUrl) {
        StringBuffer buf = new StringBuffer();

        try {

            URL url = new URL(webSiteUrl);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                buf.append(line).append("\n");
            }
            br.close();
            isr.close();
            is.close();

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }


    /**
     * 从HTML源码中获取目标内容（核心方法2）
     *
     * @param mainUrl 网站主页地址[不需要可以为空或null]
     * @param html    目标地址的网站源码
     * @return
     */
    public static ArrayList<String> getDataListFromHTML(String mainUrl, String html,
                                                        HtmlFilterDataRequest htmlFilterDataRequest) {

        int htmlStart;
        int htmlEnd;
        if (StringUtils.isEmpty(htmlFilterDataRequest.getHtmlStartRange())) {
            htmlStart = 0;
        } else {
            htmlStart = html.indexOf(htmlFilterDataRequest.getHtmlStartRange());
        }
        if (StringUtils.isEmpty(htmlFilterDataRequest.getHtmlEndRange())) {
            htmlEnd = html.length();
        } else {
            htmlEnd = html.indexOf(htmlFilterDataRequest.getHtmlEndRange());
        }
        ArrayList<String> dataList = new ArrayList<String>();
        int start = htmlStart, end = 0;

        while (true) {
            start = html.indexOf(htmlFilterDataRequest.getTranslateStart(), start);
            if (start == -1)
                break;
            if (start >= htmlEnd)
                break;

            start += htmlFilterDataRequest.getTranslateStart().length();
            end = html.indexOf(htmlFilterDataRequest.getTranslateEnd(), start);
            String url = html.substring(start, end);
            dataList.add((mainUrl == null ? "" : mainUrl) + url);
            start = end;
        }

        return dataList;
    }
}
