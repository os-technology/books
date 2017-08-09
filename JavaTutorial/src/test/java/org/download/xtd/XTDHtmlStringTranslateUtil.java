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
        String format = getTranslateNumbersString(getFirstStage(html, getToday()), html);
//        String format = getNumList();

        String[] mats = format.trim().split("\n");
        return mats;
    }


    public static String[] getWufenMatArray() {
        String html = getHtml();//HTML内容
        String format = getTranslateNumbersString(getFirstStage(html, getWuFenCaiMark()), html);
        String[] mats = format.trim().split("\n");
        return mats;
    }

    private static String getWuFenCaiMark() {
        return "1060";
    }

    /**
     * 台湾五分彩
     *
     * @return
     */
    private static String getTranslateNumbersString(int firstStage, String html) {
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
    private static int getFirstStage(String html, String dateMark) {
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


    public static String getNumList() {
        return "20170809-396  93949\n" +
                "20170809-397  59028\n" +
                "20170809-398  33703\n" +
                "20170809-399  80169\n" +
                "20170809-400  16860\n" +
                "20170809-401  93099\n" +
                "20170809-402  12509\n" +
                "20170809-403  77244\n" +
                "20170809-404  53700\n" +
                "20170809-405  74914\n" +
                "20170809-406  03269\n" +
                "20170809-407  18884\n" +
                "20170809-408  26326\n" +
                "20170809-409  70794\n" +
                "20170809-410  45336\n" +
                "20170809-411  35504\n" +
                "20170809-412  29843\n" +
                "20170809-413  83168\n" +
                "20170809-414  55169\n" +
                "20170809-415  76889\n" +
                "20170809-416  77276\n" +
                "20170809-417  90036\n" +
                "20170809-418  47624\n" +
                "20170809-419  60995\n" +
                "20170809-420  80677\n" +
                "20170809-421  74033\n" +
                "20170809-422  81639\n" +
                "20170809-423  91723\n" +
                "20170809-424  12068\n" +
                "20170809-425  12324\n" +
                "20170809-426  39873\n" +
                "20170809-427  85384\n" +
                "20170809-428  23710\n" +
                "20170809-429  74301\n" +
                "20170809-430  46613\n" +
                "20170809-431  85694\n" +
                "20170809-432  71576\n" +
                "20170809-433  77037\n" +
                "20170809-434  48188\n" +
                "20170809-435  91457\n" +
                "20170809-436  03411\n" +
                "20170809-437  12611\n" +
                "20170809-438  99479\n" +
                "20170809-439  25655\n" +
                "20170809-440  94639\n" +
                "20170809-441  21503\n" +
                "20170809-442  96828\n" +
                "20170809-443  51294\n" +
                "20170809-444  29936\n" +
                "20170809-445  15742\n" +
                "20170809-446  38258\n" +
                "20170809-447  32629\n" +
                "20170809-448  45290\n" +
                "20170809-449  54682\n" +
                "20170809-450  51021\n" +
                "20170809-451  81845\n" +
                "20170809-452  02589\n" +
                "20170809-453  24160\n" +
                "20170809-454  18968\n" +
                "20170809-455  58029\n" +
                "20170809-456  71988\n" +
                "20170809-457  89171\n" +
                "20170809-458  64364\n" +
                "20170809-459  68083\n" +
                "20170809-460  33259\n" +
                "20170809-461  14570\n" +
                "20170809-462  42962\n" +
                "20170809-463  62026\n" +
                "20170809-464  93563\n" +
                "20170809-465  74575\n" +
                "20170809-466  20139\n" +
                "20170809-467  78405\n" +
                "20170809-468  75100\n" +
                "20170809-469  57389\n" +
                "20170809-470  56270\n" +
                "20170809-471  64262\n" +
                "20170809-472  28709\n" +
                "20170809-473  79183\n" +
                "20170809-474  81750\n" +
                "20170809-475  84821\n" +
                "20170809-476  64807\n" +
                "20170809-477  50858\n" +
                "20170809-478  32898\n" +
                "20170809-479  55409\n" +
                "20170809-480  71681\n" +
                "20170809-481  10348\n" +
                "20170809-482  45111\n" +
                "20170809-483  61570\n" +
                "20170809-484  11585\n" +
                "20170809-485  49012\n" +
                "20170809-486  56416\n" +
                "20170809-487  81943\n" +
                "20170809-488  65038\n" +
                "20170809-489  17950\n" +
                "20170809-490  51121\n" +
                "20170809-491  84227\n" +
                "20170809-492  14470\n" +
                "20170809-493  00515\n" +
                "20170809-494  98507\n" +
                "20170809-495  58722\n" +
                "20170809-496  65712\n" +
                "20170809-497  30424\n" +
                "20170809-498  56170\n" +
                "20170809-499  61737\n" +
                "20170809-500  62034\n" +
                "20170809-501  17467\n" +
                "20170809-502  54780\n" +
                "20170809-503  58756\n" +
                "20170809-504  50088\n" +
                "20170809-505  26176\n" +
                "20170809-506  56498\n" +
                "20170809-507  58263\n" +
                "20170809-508  82268\n" +
                "20170809-509  78698\n" +
                "20170809-510  11446\n" +
                "20170809-511  62441\n" +
                "20170809-512  86348\n" +
                "20170809-513  20953\n" +
                "20170809-514  63680\n" +
                "20170809-515  26051\n" +
                "20170809-516  42460\n" +
                "20170809-517  67692\n" +
                "20170809-518  61135\n" +
                "20170809-519  18020\n" +
                "20170809-520  54839\n" +
                "20170809-521  31876\n" +
                "20170809-522  25190\n" +
                "20170809-523  45295\n" +
                "20170809-524  73345\n" +
                "20170809-525  59892\n" +
                "20170809-526  00971\n" +
                "20170809-527  67657\n" +
                "20170809-528  00251\n" +
                "20170809-529  20916\n" +
                "20170809-530  45551\n" +
                "20170809-531  02112\n" +
                "20170809-532  95968\n" +
                "20170809-533  60677\n" +
                "20170809-534  71937\n" +
                "20170809-535  16409\n" +
                "20170809-536  03460\n" +
                "20170809-537  92415\n" +
                "20170809-538  98295\n" +
                "20170809-539  36858\n" +
                "20170809-540  78210\n" +
                "20170809-541  73275\n" +
                "20170809-542  18494\n" +
                "20170809-543  66438\n" +
                "20170809-544  89529\n" +
                "20170809-545  58633\n" +
                "20170809-546  58358\n" +
                "20170809-547  20270\n" +
                "20170809-548  01606\n" +
                "20170809-549  35469\n" +
                "20170809-550  64255\n" +
                "20170809-551  57279\n" +
                "20170809-552  51780\n" +
                "20170809-553  13636\n" +
                "20170809-554  71106\n" +
                "20170809-555  60485\n" +
                "20170809-556  03122\n" +
                "20170809-557  70540\n" +
                "20170809-558  51846\n" +
                "20170809-559  00400\n" +
                "20170809-560  10572\n" +
                "20170809-561  71185\n" +
                "20170809-562  34251\n" +
                "20170809-563  60446\n" +
                "20170809-564  12376\n" +
                "20170809-565  00838\n" +
                "20170809-566  51497\n" +
                "20170809-567  47882\n" +
                "20170809-568  95510\n" +
                "20170809-569  66562\n" +
                "20170809-570  25341\n" +
                "20170809-571  73263\n" +
                "20170809-572  18832\n" +
                "20170809-573  11859\n" +
                "20170809-574  71208\n" +
                "20170809-575  92428\n" +
                "20170809-576  22340\n" +
                "20170809-577  97419\n" +
                "20170809-578  58453\n" +
                "20170809-579  62035\n" +
                "20170809-580  92986\n" +
                "20170809-581  61729\n" +
                "20170809-582  75562\n" +
                "20170809-583  12409\n" +
                "20170809-584  40139\n" +
                "20170809-585  01356\n" +
                "20170809-586  70973\n" +
                "20170809-587  35251\n" +
                "20170809-588  84042\n" +
                "20170809-589  95451\n" +
                "20170809-590  38128\n" +
                "20170809-591  46426\n" +
                "20170809-592  86760\n" +
                "20170809-593  62009\n";
    }


    public static String getHtml() {

        String start = "<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">";
        String end = "<script type=\"text/javascript\">";
        String content = getContent();

        return start + content + end;

    }

    public static String getContent() {
        return "<td style=\"background:#fff;color:#333333;\"><b>20170809-0494</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>2</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0495</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>3</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0496</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>4</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0497</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>5</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0498</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>6</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0499</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>7</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0500</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>8</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0501</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>9</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0502</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>10</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0503</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>11</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0504</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>12</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0505</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'>\n" +
                "<td>13</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0506</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'>\n" +
                "<td>14</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0507</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 14 </div></td><td class='ylfx_ww'>\n" +
                "<td>15</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0508</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_ww'>\n" +
                "<td>16</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0509</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_ww'>\n" +
                "<td>17</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0510</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 17 </div></td><td class='ylfx_ww'>\n" +
                "<td>18</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0511</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 18 </div></td><td class='ylfx_ww'>\n" +
                "<td>19</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0512</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 19 </div></td><td class='ylfx_ww'>\n" +
                "<td>20</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0513</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 20 </div></td><td class='ylfx_ww'>\n" +
                "<td>21</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0514</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 21 </div></td><td class='ylfx_ww'>\n" +
                "<td>22</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0515</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 22 </div></td><td class='ylfx_ww'>\n" +
                "<td>23</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0516</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 23 </div></td><td class='ylfx_ww'>\n" +
                "<td>24</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0517</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 24 </div></td><td class='ylfx_ww'>\n" +
                "<td>25</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0518</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 25 </div></td><td class='ylfx_ww'>\n" +
                "<td>26</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0519</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 26 </div></td><td class='ylfx_ww'>\n" +
                "<td>27</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0520</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 27 </div></td><td class='ylfx_ww'>\n" +
                "<td>28</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0521</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 28 </div></td><td class='ylfx_ww'>\n" +
                "<td>29</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0522</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 29 </div></td><td class='ylfx_ww'>\n" +
                "<td>30</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0523</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 30 </div></td><td class='ylfx_ww'>\n" +
                "<td>31</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0524</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 31 </div></td><td class='ylfx_ww'>\n" +
                "<td>32</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0525</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 32 </div></td><td class='ylfx_ww'>\n" +
                "<td>33</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0526</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>34</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0527</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>35</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0528</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>36</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0529</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>37</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0530</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>38</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0531</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>39</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0532</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>40</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0533</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>41</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0534</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>42</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0535</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>43</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0536</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>44</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0537</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>45</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0538</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>46</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0539</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>47</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0540</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>48</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0541</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>49</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0542</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>50</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0543</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>51</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0544</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>52</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0545</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>53</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0546</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>54</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0547</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>55</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0548</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>56</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0549</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>57</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0550</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>58</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0551</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>59</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0552</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>60</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0553</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>61</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0554</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>62</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0555</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>63</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0556</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>64</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0557</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>65</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0558</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>66</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0559</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>67</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0560</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>68</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0561</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>69</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0562</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>70</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0563</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>71</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0564</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>72</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0565</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>73</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0566</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>74</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0567</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>75</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0568</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>76</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0569</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>77</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0570</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>78</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0571</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>79</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0572</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>80</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0573</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>81</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0574</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>82</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0575</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>83</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0576</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>84</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0577</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'>\n" +
                "<td>85</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0578</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'>\n" +
                "<td>86</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0579</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 14 </div></td><td class='ylfx_ww'>\n" +
                "<td>87</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0580</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_ww'>\n" +
                "<td>88</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0581</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_ww'>\n" +
                "<td>89</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0582</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 17 </div></td><td class='ylfx_ww'>\n" +
                "<td>90</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0583</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 18 </div></td><td class='ylfx_ww'>\n" +
                "<td>91</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0584</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 19 </div></td><td class='ylfx_ww'>\n" +
                "<td>92</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0585</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>93</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0586</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>94</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0587</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>95</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0588</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>96</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0589</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>97</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0590</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>98</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0591</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>99</td>        \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0592</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>100</td>       \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-0593</b></td> \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n";
    }
}
