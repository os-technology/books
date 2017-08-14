package org.htmltranslate.xtd;

import org.htmltranslate.util.HtmlFilterDataRequest;
import org.htmltranslate.util.HtmlUtil;
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

        String html = getHtml();
        String format = "";
        format = getTranslateLongHtmlNumbersString(getFirstStage(html, getToday()), html);

//        format = getNumList();

        String[] mats = format.trim().split("\n");
        return mats;
    }


    /**
     * 五分彩解析
     *
     * @return
     */
    public static String[] getWufenMatArray() {
        String html = getHtml();//HTML内容
        String format = getTranslateLongHtmlNumbersString(getFirstStage(html, getWuFenCaiMark()), html);
//        String format = getNumList();
        String[] mats = format.trim().split("\n");
        return mats;
    }

    //五分彩起始标识
    private static String getWuFenCaiMark() {
        return "1060";
    }

    /**
     * PK10解析
     *
     * @return
     */
    public static String[] getPKMatArray() {
        String html = getHtml();//HTML内容
        String format = getTranslateLongHtmlNumbersString(getFirstStage(html, getPKMark()), html);
//        String format = getNumList();
        String[] mats = format.trim().split("\n");
        return mats;
    }

    private static String getPKMark() {
        return "63";
    }

    /**
     * 台湾五分彩
     *
     * @return
     */
    @Deprecated
    private static String getTranslateNumbersString(int firstStage, String html) {
        HtmlFilterDataRequest request = getValueCaiPiao();

        return translateHtml2NumListString(firstStage, html, request);
    }

    /**
     * 台湾五分彩
     *
     * @return
     */
    private static String getTranslateLongHtmlNumbersString(int firstStage, String html) {
        HtmlFilterDataRequest request = getLongValueCaiPiao();

        return translateHtml2NumListString(firstStage, html, request);
    }

    private static String translateHtml2NumListString(int firstStage, String html, HtmlFilterDataRequest request) {
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

    /**
     * 100期以上的统计模式
     *
     * @return
     */
    public static HtmlFilterDataRequest getLongValueCaiPiao() {

        HtmlFilterDataRequest request = new HtmlFilterDataRequest();

        request.setUrl("http://www.fzbyy.cc/Dianshiju/146089.html")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">")
                .setHtmlEndRange("<script type=\"text/javascript\">")
                .setTranslateStart("<div class=\"ball_color3\">")
                .setTranslateEnd("</div></td>");


        return request;
    }

    public static String getNumList() {
        return "20170811-1288  91645\n" +
                "20170811-1289  49716\n" +
                "20170811-1290  31552\n" +
                "20170811-1291  75358\n" +
                "20170811-1292  41850\n" +
                "20170811-1293  22522\n" +
                "20170811-1294  75409\n" +
                "20170811-1295  35268\n" +
                "20170811-1296  99582\n" +
                "20170811-1297  57947\n" +
                "20170811-1298  46189\n" +
                "20170811-1299  38121\n" +
                "20170811-1300  39715\n" +
                "20170811-1301  68352\n" +
                "20170811-1302  91877\n" +
                "20170811-1303  08093\n" +
                "20170811-1304  89722\n" +
                "20170811-1305  48416\n" +
                "20170811-1306  32714\n" +
                "20170811-1307  36084\n" +
                "20170811-1308  24059\n" +
                "20170811-1309  68111\n" +
                "20170811-1310  36995\n" +
                "20170811-1311  01980\n" +
                "20170811-1312  43315\n" +
                "20170811-1313  55491\n" +
                "20170811-1314  43813\n" +
                "20170811-1315  33015\n" +
                "20170811-1316  42602\n" +
                "20170811-1317  47765\n" +
                "20170811-1318  01805\n" +
                "20170811-1319  64654\n" +
                "20170811-1320  83486\n" +
                "20170811-1321  13720\n" +
                "20170811-1322  55984\n" +
                "20170811-1323  60243\n" +
                "20170811-1324  15413\n" +
                "20170811-1325  63064\n" +
                "20170811-1326  77214\n" +
                "20170811-1327  89483\n" +
                "20170811-1328  20737\n" +
                "20170811-1329  43731\n" +
                "20170811-1330  51886\n" +
                "20170811-1331  11010\n" +
                "20170811-1332  99587\n" +
                "20170811-1333  06493\n" +
                "20170811-1334  73003\n" +
                "20170811-1335  40252\n" +
                "20170811-1336  42188\n" +
                "20170811-1337  70387\n" +
                "20170811-1338  51042\n" +
                "20170811-1339  85104\n" +
                "20170811-1340  21439\n" +
                "20170811-1341  52798\n" +
                "20170811-1342  62707\n" +
                "20170811-1343  12631\n" +
                "20170811-1344  33413\n" +
                "20170811-1345  27364\n" +
                "20170811-1346  95137\n" +
                "20170811-1347  49709\n" +
                "20170811-1348  63580\n" +
                "20170811-1349  74490\n" +
                "20170811-1350  89817\n" +
                "20170811-1351  62635\n" +
                "20170811-1352  27704\n" +
                "20170811-1353  20654\n" +
                "20170811-1354  71070\n" +
                "20170811-1355  62315\n" +
                "20170811-1356  04218\n" +
                "20170811-1357  73855\n" +
                "20170811-1358  66635\n" +
                "20170811-1359  72116\n" +
                "20170811-1360  03601\n" +
                "20170811-1361  50025\n" +
                "20170811-1362  05726\n" +
                "20170811-1363  68275\n" +
                "20170811-1364  96654\n" +
                "20170811-1365  78439\n" +
                "20170811-1366  01294\n" +
                "20170811-1367  48607\n" +
                "20170811-1368  67642\n" +
                "20170811-1369  40719\n" +
                "20170811-1370  74372\n" +
                "20170811-1371  92025\n" +
                "20170811-1372  69596\n" +
                "20170811-1373  17445\n" +
                "20170811-1374  30093\n" +
                "20170811-1375  30297\n" +
                "20170811-1376  07648\n" +
                "20170811-1377  52265\n" +
                "20170811-1378  17945\n" +
                "20170811-1379  22624\n" +
                "20170811-1380  96918\n" +
                "20170811-1381  78482\n" +
                "20170811-1382  80851\n" +
                "20170811-1383  43102\n" +
                "20170811-1384  41107\n" +
                "20170811-1385  83458\n" +
                "20170811-1386  41977\n" +
                "20170811-1387  34110\n";
    }


    public static String getHtml() {
        String html = HtmlUtil.getHtmlByUrl("file:///Users/yujinshui/Desktop/%E4%B8%AA%E4%BA%BA%E5%A4%84%E7%90%86/tmp.txt");//HTML内容
        return getHtml(html);

    }

    public static String getHtml(String content) {

        String start = "<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">";
        String end = "<script type=\"text/javascript\">";


        return start + content + end;

    }

    public static String getContent() {
        return "<td style=\"background:#fff;color:#333333;\"><b>20170813-1058</b></td> \n" +
                "<div class=\"ball_color3\">9</div></td>\n" +
                "<div class=\"ball_color3\">3</div></td>\n" +
                "<div class=\"ball_color3\">5</div></td>\n" +
                "<div class=\"ball_color3\">4</div></td>\n" +
                "<div class=\"ball_color3\">0</div></td>\n" +
                " 18 </div></td><td class='ylfx_ww'>\n" +
                "<td>2</td>  \n";
    }
}
