package org.download.xtd;

import org.chapter.databasic.thread.gao.Data;
import org.download.util.HtmlFilterDataRequest;
import org.download.util.HtmlUtil;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: XtdNumberUtilTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/30下午12:06
 */

public class XtdNumberUtilTest {




    @Test
    public void testGetCaiPiaoHtml() {
        HtmlFilterDataRequest request = getValueCaiPiao();
//        String html = HtmlUtil.getHtmlByUrl(request.getUrl());
        String html = getHtml();//HTML内容
        ArrayList<String> result = HtmlUtil.getDataListFromHTML("", html, request);

        Assert.assertTrue(result.size() > 0);
        int i = 0;
        int stage = getFirstStage(html);//期号
        String date = getToday()+"0";//日期格式，小于1000加0前缀
        String format = "";//结果字符串拼接，后续处理以 \n 分割为数组

        for (String output : result) {

            if (i % 5 == 0) {
                String tmp = date + (stage++) + "  ";
                format += "\n" + tmp;
            }
            format += output;
            i++;
        }

        String[] mats = format.trim().split("\n");
        System.out.println(mats[0] + "  " + "初始数据");

        int time = 0;//倍投下标
        int multiple[] = getMultiple(10);//倍投倍数值
        double maxMoney = 0;//最大投入金额
        BigDecimal initMoney = new BigDecimal(1.28);//初始投入金额
        BigDecimal winMoney = new BigDecimal(1.94);//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//净利润金额
        int maxWinTime=0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime=0;//最大连挂次数
        int tmpLoseTime=0;//每阶段连挂次数
        for (int m = 0; m < mats.length - 1; m++) {
            String init = mats[m].substring(mats[m].length()-2, mats[m].length());
            String compare = mats[m + 1].substring(mats[m].length()-2, mats[m + 1].length());

            if (compareNumberIsTrue(init, compare)) {//赢
                maxLoseTime = maxLoseTime>tmpLoseTime?maxLoseTime:tmpLoseTime;
                if (time>0){
                    double inputMoney = getCalResult(initMoney.doubleValue(), multiple[time]);
                    maxMoney = maxMoney>inputMoney?maxMoney:inputMoney;
                    System.out.println(mats[m + 1] + "  " + "赢  1   "+inputMoney+"    "
                            +getMoneyString((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time]))));
                    //盈利计算
                    incomeMoney = incomeMoney.add((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                }else{
                    System.out.println(mats[m + 1] + "  " + "赢  1   "+getMoneyString(initMoney)+"    "+getMoneyString(winMoney.subtract(initMoney)));
                    //盈利计算
                    incomeMoney =incomeMoney.add(winMoney.subtract(initMoney));
                }

                //重置操作
                time = 0;
                tmpWinTime++;
                tmpLoseTime=0;
            } else {//输
                maxWinTime = maxWinTime>tmpWinTime?maxWinTime:tmpWinTime;

                System.out.println(mats[m + 1] + "  " + "输  0   "+getCalResult(initMoney.doubleValue(),multiple[time]));
                time++;
                tmpWinTime=0;
                tmpLoseTime++;
            }

        }
        System.out.println("最大倍投金额(仅针对两个号码不同的情况得出的结果)："+maxMoney);
        System.out.println("最大连赢次数："+maxWinTime);
        System.out.println("最大连挂次数："+maxLoseTime);
        System.out.println("总收益："+getMoneyString(incomeMoney));
    }

    /**{1,2,6,18,54,162,486}
     *
     * @param t 倍投次数
     * @return
     */
    private int[] getMultiple(int t) {
        int[] multi = new int[t];
        for(int i=0;i<t;i++){
            if (i==0){
                multi[i] = 1;
            }else if(i==1){
                multi[i] = 2;
            }else{
                multi[i] = multi[i-1]*3;
            }
        }
        return multi;
    }

    /**倍投计算*/
    private double getCalResult(double init,double multiple){
        BigDecimal result = new BigDecimal(init).multiply(new BigDecimal(multiple));
        return result.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**获取内容的第一次期号*/
    private int getFirstStage(String html){
        String start = "<td style=\"background:#fff;color:#333333;\"><b>"+getToday();
        String result = html.substring(html.indexOf(start)+start.length(),html.indexOf("</b></td>"));
        return Integer.valueOf(result);
    }

    //不相同，true，相同，false
    private boolean compareNumberIsTrue(String init, String compare) {
        char[] charValue = init.toCharArray();
        boolean bool = false;
        for (char ch : charValue) {
            if (compare.contains(ch + "")) {
                bool = false;
                break;
            } else {
                bool = true;
            }
        }
        return bool;
    }

    private double getMoneyString(BigDecimal inputMoney){
        return inputMoney.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    private String getToday(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date())+"-";
    }

    public HtmlFilterDataRequest getValueCaiPiao() {

        HtmlFilterDataRequest request = new HtmlFilterDataRequest();

        request.setUrl("http://www.fzbyy.cc/Dianshiju/146089.html")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">")
                .setHtmlEndRange("<script type=\"text/javascript\">")
                .setTranslateStart("<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">")
                .setTranslateEnd("</div></td>");


        return request;
    }


    private String getHtml() {
        return "<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">\n" +
                "<tbody>\n" +
                "<th rowspan=\"2\">序号</th>\n" +
                "<th rowspan=\"2\">期号</th>\n" +
                "<th rowspan=\"2\" colspan=\"5\">开奖号码</th>\n" +
                "<th colspan=\"10\"><div class=\"line\">万位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">千位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">百位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">十位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">个位</div></th>\n" +
                "</tr>\n" +
                "<tr style=\"background:#ffd200;color:#222222;height:25px;font-size:13px;\">\n" +
                "    <th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "    <th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "    <th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "    <th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "    <th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "</tr>\n" +
                "<tr class=\"ylfx_content\">\n" +
                "<td>1</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1146</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>2</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1147</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>3</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1148</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>4</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1149</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>5</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1150</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>6</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1151</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>7</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1152</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>8</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1153</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>9</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1154</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>10</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1155</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>11</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1156</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>12</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1157</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>13</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1158</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>14</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1159</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>15</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1160</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>16</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1161</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>17</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1162</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>18</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1163</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>19</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1164</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>20</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1165</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>21</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1166</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>22</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1167</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>23</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1168</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>24</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1169</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>25</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1170</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>26</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1171</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>27</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1172</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>28</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1173</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>29</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1174</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>30</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1175</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>31</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1176</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>32</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1177</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>33</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1178</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>34</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1179</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>35</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1180</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>36</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1181</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>37</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1182</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>38</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1183</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>39</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1184</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>40</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1185</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>41</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1186</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>42</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1187</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>43</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1188</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>44</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1189</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>45</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1190</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>46</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1191</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>47</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1192</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>48</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1193</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>49</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1194</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>50</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1195</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>51</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1196</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>52</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1197</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>53</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1198</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>54</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1199</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>55</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1200</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>56</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1201</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>57</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1202</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>58</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1203</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>59</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1204</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>60</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1205</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>61</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1206</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>62</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1207</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>63</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1208</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>64</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1209</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>65</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1210</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>66</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1211</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>67</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1212</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>68</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1213</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>69</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1214</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>70</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1215</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>71</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1216</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>72</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1217</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>73</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1218</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>74</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1219</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>75</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1220</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>76</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1221</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>77</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1222</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>78</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1223</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>79</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1224</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>80</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1225</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>81</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1226</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>82</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1227</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>83</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1228</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>84</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1229</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>85</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1230</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>86</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1231</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>87</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1232</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>88</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1233</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>89</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1234</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>90</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1235</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>91</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1236</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>92</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1237</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>93</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1238</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>94</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1239</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>95</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1240</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>96</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1241</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>97</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1242</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>98</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1243</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>99</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1244</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>100</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1245</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "\n" +
                "<script type=\"text/javascript\">";
    }


}
