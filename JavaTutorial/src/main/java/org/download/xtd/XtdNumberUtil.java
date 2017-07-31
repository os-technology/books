package org.download.xtd;

import org.apache.commons.lang.StringUtils;
import org.download.util.HtmlFilterDataRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * 新天地彩票数据获取
 *
 * @author yuijnshui@lxfintech.com
 * @Title: XtdNumberUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/30上午10:21
 */

public class XtdNumberUtil {
    public static String getHtmlByUrl(String webSiteUrl) {
        return getHtmlByUrl(webSiteUrl, "UTF-8");
    }

    /**
     * 获取网站源码[核心方法1]
     *
     * @param webSiteUrl 网站地址
     * @return
     */
    public static String getHtmlByUrl(String webSiteUrl, String encoding) {
        StringBuffer buf = new StringBuffer();

        try {

            URL url = new URL(webSiteUrl);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is, encoding);
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
     * @param html 目标地址的网站源码
     * @return
     */
    public static ArrayList<String> getDataListFromHTML(String html,
                                                        XtdHtmlParamsRequest request) {
        HtmlTranslateCoordinate coordinate = new HtmlTranslateCoordinate();
        if (StringUtils.isEmpty(request.getHtmlStartRange())) {
            coordinate.setHtmlStart(0);
        } else {
            coordinate.setHtmlStart(html.indexOf(request.getHtmlStartRange()));
        }
        if (StringUtils.isEmpty(request.getHtmlEndRange())) {
            coordinate.setHtmlEnd(html.length());
        } else {
            coordinate.setHtmlEnd(html.indexOf(request.getHtmlEndRange()));
        }
        ArrayList<String> dataList = new ArrayList<String>();
//        int start = htmlStart, end = 0;
        coordinate.setStart(coordinate.getHtmlStart());

        while (true) {
            String data = getSingleDataFromTranslateHtml(coordinate,html,request.getTranslateStart_myriabit(),request.getTranslateEnd_myriabit());
            if (data == null) {
                break;
            }
            dataList.add(data);
            coordinate.setStart(coordinate.getEnd());

        }

        return dataList;
    }


    /**
     * 获取所需数据
     *
     * @param coordinate
     * @param html
     * @param request
     * @return
     */
    private static String getMultiDataFromHtml(HtmlTranslateCoordinate coordinate, String html,
                                               XtdHtmlParamsRequest request) {

//        String stage = getSingleDataFromTranslateHtml(coordinate, html, request.getTranslateStart_stage(), request.getTranslateEnd_stage());

        String numHtml = getSingleDataFromTranslateHtml(coordinate,html,request.getTmpHtmlStartRange(),request.getTmpHtmlEndRange());

        XtdHtmlParamsRequest tmpRequest = new XtdHtmlParamsRequest();

        tmpRequest.setHtmlStartRange(request.getTmpHtmlStartRange())
                .setHtmlEndRange(request.getTmpHtmlEndRange());
        tmpRequest.setTranslateStart_myriabit(request.getTranslateStart_myriabit())
                .setTranslateEnd_myriabit(request.getTranslateEnd_myriabit());
//        ArrayList<String> numList = getDataListFromNumHTML(request.getTmpHtmlStartRange()+numHtml+request.getTmpHtmlEndRange(), tmpRequest);



        String myriabit = getSingleDataFromTranslateHtml(coordinate,html,request.getTranslateStart_myriabit(),request.getTranslateEnd_myriabit());
        if (myriabit == null) {
            return null;
        }
        return myriabit;
    }




    public static ArrayList<String> getDataListFromNumHTML(String html,
                                                        XtdHtmlParamsRequest request) {
        HtmlTranslateCoordinate coordinate = new HtmlTranslateCoordinate();
        if (StringUtils.isEmpty(request.getHtmlStartRange())) {
            coordinate.setHtmlStart(0);
        } else {
            coordinate.setHtmlStart(html.indexOf(request.getHtmlStartRange()));
        }
        if (StringUtils.isEmpty(request.getHtmlEndRange())) {
            coordinate.setHtmlEnd(html.length());
        } else {
            coordinate.setHtmlEnd(html.indexOf(request.getHtmlEndRange()));
        }
        ArrayList<String> dataList = new ArrayList<String>();
        coordinate.setStart(coordinate.getHtmlStart());

        while (true) {
            String data = getSingleDataFromTranslateHtml(coordinate, html, request.getTranslateStart_myriabit(),request.getTranslateEnd_myriabit());
            if (data == null) {
                break;
            }
            dataList.add(data);
            coordinate.setStart(coordinate.getEnd());

        }

        return dataList;
    }







    /**
     * 获取单条数据
     *
     * @param coordinate
     * @param html
     * @param startHtml
     * @param endHtml
     * @return
     */
    private static String getSingleDataFromTranslateHtml(HtmlTranslateCoordinate coordinate, String html, String startHtml, String endHtml) {

        coordinate.setStart(html.indexOf(startHtml, coordinate.getStart()));
        if (coordinate.getStart() == -1)
            return null;
        if (coordinate.getStart() >= coordinate.getHtmlEnd())
            return null;

        int start = coordinate.getStart();
        int end = coordinate.getEnd();

        int tmpStart = coordinate.getStart();
        int tmpEnd = coordinate.getEnd();

        coordinate.setStart(start += startHtml.length());
        coordinate.setEnd(html.indexOf(endHtml, coordinate.getStart()));
        //期号
        String stage = html.substring(start, coordinate.getEnd());


        return stage;
    }

    @Deprecated
    private static String getDataFromTranslateHtml_one(HtmlTranslateCoordinate coordinate, String html, XtdHtmlParamsRequest request) {
        String data = null;

        coordinate.setStart(html.indexOf(request.getTranslateStart_stage(), coordinate.getStart()));
        if (coordinate.getStart() == -1)
            return null;
        if (coordinate.getStart() >= coordinate.getHtmlEnd())
            return null;

        int start = coordinate.getStart();

        coordinate.setStart(start += request.getTranslateStart_stage().length());
        coordinate.setEnd(html.indexOf(request.getTranslateEnd_stage(), coordinate.getStart()));
        //期号
        String stage = html.substring(start, coordinate.getEnd());


        return stage;
    }


    private static String getString(String input) {
        return input == null ? "" : input;
    }

}
