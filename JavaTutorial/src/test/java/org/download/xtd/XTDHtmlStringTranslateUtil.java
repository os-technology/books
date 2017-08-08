package org.download.xtd;

import org.download.util.HtmlFilterDataRequest;
import org.download.util.HtmlUtil;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 解析HTML字符串，得到期号数据
 *
 * @author yuijnshui@lxfintech.com
 * @Title: XTDHtmlStringTranslateUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/3上午10:03
 */

public class XTDHtmlStringTranslateUtil {


    /**
     * 得到彩票 期 号 数据
     *
     * @return
     */
    public static String[] getMatArray() {
        String html = getHtml();//HTML内容
        String format = getFenFenCaiTranslateNumbersString(getFirstStage(html,getToday()),html);
//        String format = getNumList();

        String[] mats = format.trim().split("\n");
        return mats;
    }


    public static String[] getWufenMatArray(){
        String html = getHtml();//HTML内容
        String format = getWuFenCaiTranslateNumbersString(getFirstStage(html,getWuFenCaiMark()),html);
        String[] mats = format.trim().split("\n");
        return mats;
    }

    private static String getWuFenCaiMark(){
        return "1060";
    }
    /**
     * 台湾五分彩
     * @return
     */
    private static String getWuFenCaiTranslateNumbersString(int firstStage,String html) {
        HtmlFilterDataRequest request = getValueCaiPiao();

        ArrayList<String> result = HtmlUtil.getDataListFromHTML("", html, request);

        Assert.assertTrue(result.size() > 0);
        int i = 0;
        int stage = firstStage;//期号
        String date = getToday();//日期格式，小于1000加0前缀
        String format = "";//结果字符串拼接，后续处理以 \n 分割为数组

        for (String output : result) {

            if (i % 5 == 0) {
                String tmp = date + (stage++) + "  ";
                format += "\n" + tmp;
            }
            format += output;
            i++;
        }
        return format;
    }



    private static String getFenFenCaiTranslateNumbersString(int firstStage,String html) {
        HtmlFilterDataRequest request = getValueCaiPiao();

        ArrayList<String> result = HtmlUtil.getDataListFromHTML("", html, request);

        Assert.assertTrue(result.size() > 0);
        int i = 0;
        int stage = firstStage;//期号
        String date = getToday();//日期格式，小于1000加0前缀
        String format = "";//结果字符串拼接，后续处理以 \n 分割为数组

        for (String output : result) {

            if (i % 5 == 0) {
                String tmp = date + (stage++) + "  ";
                format += "\n" + tmp;
            }
            format += output;
            i++;
        }
        return format;
    }

    /**
     * 获取内容的第一次期号
     */
    private static int getFirstStage(String html,String dateMark) {
        String start = "<td style=\"background:#fff;color:#333333;\"><b>" + dateMark;
        String result = html.substring(html.indexOf(start) + start.length(), html.indexOf("</b></td>"));
        return Integer.valueOf(result);
    }

    private static String getToday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date()) + "-";
    }


    public static HtmlFilterDataRequest getValueCaiPiao() {

        HtmlFilterDataRequest request = new HtmlFilterDataRequest();

        request.setUrl("http://www.fzbyy.cc/Dianshiju/146089.html")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">")
                .setHtmlEndRange("<script type=\"text/javascript\">")
                .setTranslateStart("<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">")
                .setTranslateEnd("</div></td>");


        return request;
    }



    public static String getNumList(){
        return "20170808-06  10206\n" +
                "20170808-07  28826\n" +
                "20170808-08  48551\n" +
                "20170808-09  60960\n" +
                "20170808-10  91783\n" +
                "20170808-11  78692\n" +
                "20170808-12  02251\n" +
                "20170808-13  74065\n" +
                "20170808-14  23164\n" +
                "20170808-15  13858\n" +
                "20170808-16  80943\n" +
                "20170808-17  75333\n" +
                "20170808-18  90019\n" +
                "20170808-19  22069\n" +
                "20170808-20  73365\n" +
                "20170808-21  73929\n" +
                "20170808-22  94057\n" +
                "20170808-23  07235\n" +
                "20170808-24  44163\n" +
                "20170808-25  74674\n" +
                "20170808-26  43659\n" +
                "20170808-27  99406\n" +
                "20170808-28  60477\n" +
                "20170808-29  60747\n" +
                "20170808-30  06738\n" +
                "20170808-31  17191\n" +
                "20170808-32  70342\n" +
                "20170808-33  86189\n" +
                "20170808-34  71804\n";
    }



    public static String getHtml() {

        String start = "<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">";
        String end = "<script type=\"text/javascript\">";
        String content = getContent();

        return start+content+end;

    }

    public static String getContent() {
        return "<td style=\"background:#fff;color:#333333;\"><b>20170808-069</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>4</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-070</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>5</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-071</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>6</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-072</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>7</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-073</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>8</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-074</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>9</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-075</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>10</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-076</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>11</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-077</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'>\n" +
                "<td>12</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-078</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'>\n" +
                "<td>13</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-079</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>14</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-080</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>15</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-081</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>16</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-082</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>17</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-083</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>18</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-084</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>19</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-085</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>20</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-086</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>21</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-087</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>22</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-088</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>23</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-089</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>24</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-090</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>25</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-091</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>26</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-092</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>27</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-093</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>28</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-094</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>29</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-095</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>30</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-096</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>31</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-097</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>32</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-098</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>33</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-099</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>34</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-100</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>35</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-101</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>36</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-102</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>37</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-103</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>38</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-104</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>39</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-105</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>40</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-106</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>41</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-107</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>42</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-108</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>43</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-109</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>44</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-110</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>45</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-111</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>46</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-112</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>47</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-113</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>48</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-114</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>49</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-115</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>50</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170808-116</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n";
    }
}
