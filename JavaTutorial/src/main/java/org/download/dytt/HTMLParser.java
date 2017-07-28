package org.download.dytt;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class HTMLParser {
    /**
     * 从HTML源码中获取目标内容（核心方法2）
     *
     * @param mainUrl   网站主页地址[不需要可以为空或null]
     * @param html      目标地址的网站源码
     * @param htmlStart 需要截取内容的开始位置
     * @param htmlEnd   需要截取内容的终止位置
     * @param bStr      所需内容 之前 作为目标标记的开始位置
     * @param eStr      所需内容 之后 作为目标标记的结束位置
     * @return
     */
    public ArrayList<String> getAllUrlFromHTML(String mainUrl, String html,
                                               String htmlStart, String htmlEnd, String bStr, String eStr) {

        int hstart;
        int hend;
        if (htmlStart == null || htmlStart.equals(""))
            hstart = 0;
        else
            hstart = html.indexOf(htmlStart);
        if (htmlEnd == null || htmlEnd.equals(""))
            hend = html.length();
        else
            hend = html.indexOf(htmlEnd);
        ArrayList<String> urls = new ArrayList<String>();
        int s = hstart, end = 0;

        while (true) {
            s = html.indexOf(bStr, s);
            if (s == -1)
                break;
            if (s >= hend)
                break;

            s += bStr.length();
            end = html.indexOf(eStr, s);
            String url = html.substring(s, end);
            urls.add((mainUrl == null ? "" : mainUrl) + url);
            s = end;
        }

        return urls;
    }

    public ArrayList<String> getAllPageUrl(String html) {
        String htmlStart = "<div class=\"co_content8\">";// da
        String htmlEnd = "<td height=\"25\" align=\"center\" bgcolor=\"#F4FAE2\">";
        String bStr = "<a href=\"";// xiao
        String eStr = "\" class=\"ulink\">";
        String mainUrl = "http://www.ygdy8.net";
        return this.getAllUrlFromHTML(mainUrl, html, htmlStart, htmlEnd, bStr,
                eStr);

    }

    /**
     * 获取相关地址信息/联系方式
     *
     * @param html
     * @return
     */
    public String getAddress(String html) {
        String htmlStart = "<div class=\"co_content8\">";// da
        String htmlEnd = "<td height=\"25\" align=\"center\" bgcolor=\"#F4FAE2\">";
        String bStr = "<td style=\"WORD-WRAP: break-word\" bgcolor=\"#fdfddf\"><a href=\"";// xiao
        String eStr = "\">ftp://ygdy8";
        ArrayList<String> tels = this.getAllUrlFromHTML("", html, "", "", bStr,
                eStr);
        if (tels.size() > 0)
            return tels.get(0);
        return "";
    }

    /**
     * 获取页面名称
     *
     * @param html
     * @return
     */
    public String getName(String html,String encoding) {
        String htmlStart = "<div class=\"co_area2\">";
        String htmlEnd = "</p> <br><center></center>";
        String bStr = "<font color=#07519a>";
        String eStr = "</font></h1></div>";

        ArrayList<String> names = this.getAllUrlFromHTML("", html, htmlStart,
                htmlEnd, bStr, eStr);
        if (names.size() > 0)
            return names.get(0);
//            try {
//                return new String(names.get(0).getBytes(), encoding);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
        return "";
    }
}
