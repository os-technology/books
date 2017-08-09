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
//        String format = getNumList();
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
        return  "20170809-44704  13777\n" +
                "20170809-44705  01875\n" +
                "20170809-44706  23596\n" +
                "20170809-44707  06965\n" +
                "20170809-44708  48587\n" +
                "20170809-44709  47554\n" +
                "20170809-44710  21083\n" +
                "20170809-44711  62596\n" +
                "20170809-44712  90686\n" +
                "20170809-44713  02211\n" +
                "20170809-44714  79408\n" +
                "20170809-44715  35615\n" +
                "20170809-44716  44261\n" +
                "20170809-44717  78290\n" +
                "20170809-44718  25751\n" +
                "20170809-44719  58347\n" +
                "20170809-44720  46835\n" +
                "20170809-44721  58296\n" +
                "20170809-44722  91196\n" +
                "20170809-44723  72349\n" +
                "20170809-44724  05553\n" +
                "20170809-44725  24909\n" +
                "20170809-44726  56521\n" +
                "20170809-44727  25149\n" +
                "20170809-44728  28097\n" +
                "20170809-44729  24671\n" +
                "20170809-44730  56161\n" +
                "20170809-44731  13267\n" +
                "20170809-44732  14697\n" +
                "20170809-44733  02050\n" +
                "20170809-44734  77243\n" +
                "20170809-44735  90344\n" +
                "20170809-44736  82813\n" +
                "20170809-44737  02030\n" +
                "20170809-44738  06333\n" +
                "20170809-44739  49983\n" +
                "20170809-44740  32532\n" +
                "20170809-44741  30129\n" +
                "20170809-44742  41487\n" +
                "20170809-44743  18755\n" +
                "20170809-44744  47646\n" +
                "20170809-44745  41581\n" +
                "20170809-44746  49192\n" +
                "20170809-44747  65106\n" +
                "20170809-44748  20821\n" +
                "20170809-44749  28219\n" +
                "20170809-44750  96107\n" +
                "20170809-44751  99757\n" +
                "20170809-44752  60740\n" +
                "20170809-44753  02159\n" +
                "20170809-44754  68888\n" +
                "20170809-44755  60157\n" +
                "20170809-44756  13956\n" +
                "20170809-44757  77419\n" +
                "20170809-44758  25749\n" +
                "20170809-44759  52897\n" +
                "20170809-44760  55764\n" +
                "20170809-44761  21053\n" +
                "20170809-44762  95527\n" +
                "20170809-44763  16328\n" +
                "20170809-44764  73055\n" +
                "20170809-44765  24418\n" +
                "20170809-44766  98363\n" +
                "20170809-44767  34100\n" +
                "20170809-44768  86923\n" +
                "20170809-44769  81672\n" +
                "20170809-44770  55127\n" +
                "20170809-44771  35135\n" +
                "20170809-44772  63101\n" +
                "20170809-44773  73047\n" +
                "20170809-44774  10987\n" +
                "20170809-44775  03104\n" +
                "20170809-44776  24070\n" +
                "20170809-44777  11938\n" +
                "20170809-44778  80465\n" +
                "20170809-44779  85258\n" +
                "20170809-44780  38421\n" +
                "20170809-44781  14009\n" +
                "20170809-44782  84019\n" +
                "20170809-44783  56413\n" +
                "20170809-44784  08457\n" +
                "20170809-44785  40957\n" +
                "20170809-44786  61530\n" +
                "20170809-44787  90769\n" +
                "20170809-44788  86579\n" +
                "20170809-44789  05639\n" +
                "20170809-44790  35412\n" +
                "20170809-44791  05874\n" +
                "20170809-44792  90488\n" +
                "20170809-44793  27413\n" +
                "20170809-44794  60637\n" +
                "20170809-44795  59951\n" +
                "20170809-44796  99181\n" +
                "20170809-44797  81614\n" +
                "20170809-44798  93629\n" +
                "20170809-44799  50402\n" +
                "20170809-44800  62857\n" +
                "20170809-44801  78411\n" +
                "20170809-44802  16052\n" +
                "20170809-44803  15006\n" +
                "20170809-44804  53368\n" +
                "20170809-44805  33724\n" +
                "20170809-44806  06602\n" +
                "20170809-44807  97338\n" +
                "20170809-44808  88588\n" +
                "20170809-44809  08912\n" +
                "20170809-44810  87104\n" +
                "20170809-44811  48506\n" +
                "20170809-44812  87317\n" +
                "20170809-44813  94162\n" +
                "20170809-44814  63181\n" +
                "20170809-44815  36200\n" +
                "20170809-44816  28364\n" +
                "20170809-44817  62901\n" +
                "20170809-44818  80076\n" +
                "20170809-44819  42304\n" +
                "20170809-44820  70412\n" +
                "20170809-44821  99081\n" +
                "20170809-44822  23946\n" +
                "20170809-44823  02476\n" +
                "20170809-44824  54210\n";
    }


    public static String getHtml() {

        String start = "<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">";
        String end = "<script type=\"text/javascript\">";
        String content = getContent();

        return start + content + end;

    }

    public static String getContent() {
        return "<td style=\"background:#fff;color:#333333;\"><b>20170809-011</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>2</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-012</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>3</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-013</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>4</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-014</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>5</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-015</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>6</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-016</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>7</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-017</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>8</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-018</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>9</td>  \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-019</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>10</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-020</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>11</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-021</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>12</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-022</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>13</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-023</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>14</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-024</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>15</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-025</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>16</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-026</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>17</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-027</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>18</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-028</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>19</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-029</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'>\n" +
                "<td>20</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-030</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'>\n" +
                "<td>21</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-031</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 14 </div></td><td class='ylfx_ww'>\n" +
                "<td>22</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-032</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_ww'>\n" +
                "<td>23</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-033</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>24</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-034</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>25</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-035</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>26</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-036</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>27</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-037</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>28</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-038</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>29</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-039</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>30</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-040</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>31</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-041</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>32</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-042</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>33</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-043</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>34</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-044</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>35</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-045</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>36</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-046</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>37</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-047</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>38</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-048</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>39</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-049</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>40</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-050</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'>\n" +
                "<td>41</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-051</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'>\n" +
                "<td>42</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-052</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 14 </div></td><td class='ylfx_ww'>\n" +
                "<td>43</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-053</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_ww'>\n" +
                "<td>44</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-054</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_ww'>\n" +
                "<td>45</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-055</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 17 </div></td><td class='ylfx_ww'>\n" +
                "<td>46</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-056</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 18 </div></td><td class='ylfx_ww'>\n" +
                "<td>47</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-057</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 19 </div></td><td class='ylfx_ww'>\n" +
                "<td>48</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-058</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 20 </div></td><td class='ylfx_ww'>\n" +
                "<td>49</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-059</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 21 </div></td><td class='ylfx_ww'>\n" +
                "<td>50</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-060</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>51</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-061</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>52</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-062</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>53</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-063</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>54</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-064</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>55</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-065</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>56</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-066</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>57</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-067</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>58</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-068</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>59</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-069</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>60</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-070</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>61</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-071</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>62</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-072</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>63</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-073</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>64</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-074</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>65</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-075</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>66</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-076</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>67</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-077</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>68</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-078</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>69</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-079</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>70</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-080</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>71</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-081</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>72</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-082</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>73</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-083</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>74</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-084</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>75</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-085</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>76</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-086</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>77</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-087</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'>\n" +
                "<td>78</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-088</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'>\n" +
                "<td>79</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-089</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>80</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-090</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>81</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-091</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>82</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-092</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>83</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-093</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>84</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-094</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>85</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-095</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>86</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-096</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class=\n" +
                "<td>87</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-097</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><\n" +
                "<td>88</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-098</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><\n" +
                "<td>89</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-099</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><\n" +
                "<td>90</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-100</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><\n" +
                "<td>91</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-101</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><\n" +
                "<td>92</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-102</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><\n" +
                "<td>93</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-103</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><\n" +
                "<td>94</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-104</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><\n" +
                "<td>95</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-105</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><\n" +
                "<td>96</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-106</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'>\n" +
                "<td>97</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-107</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'>\n" +
                "<td>98</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-108</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'>\n" +
                "<td>99</td> \n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-109</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'>\n" +
                "<td>100</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170809-110</b></td>  \n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n";
    }
}
