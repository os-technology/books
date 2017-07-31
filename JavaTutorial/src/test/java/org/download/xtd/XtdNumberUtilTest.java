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
    public void testSub() {
        String data = "20170731-0987";
        int a = data.indexOf("-");
        String result = data.substring(data.length()-2, data.length());
        System.out.println(result);

    }


    @Test
    public void testGetCaiPiaoHtml() {
        HtmlFilterDataRequest request = getValueCaiPiao();
//        String html = HtmlUtil.getHtmlByUrl(request.getUrl());
        ArrayList<String> result = HtmlUtil.getDataListFromHTML("", getHtml(), request);

        Assert.assertTrue(result.size() > 0);
        int i = 0;
        int stage = getFirstStage();//期号
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
        double initMoney = 12.8;
        int winTime=0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        for (int m = 0; m < mats.length - 1; m++) {
            String init = mats[m].substring(mats[m].length()-2, mats[m].length());
            String compare = mats[m + 1].substring(mats[m].length()-2, mats[m + 1].length());

            if (compareNumberIsTrue(init, compare)) {//赢
                if (time>0){
                    double inputMoney = getCalResult(initMoney, multiple[time]);
                    maxMoney = maxMoney>inputMoney?maxMoney:inputMoney;
                    System.out.println(mats[m + 1] + "  " + "赢  1   "+inputMoney);
                }else{
                    System.out.println(mats[m + 1] + "  " + "赢  1");
                }
                time = 0;
                tmpWinTime++;
            } else {//输
                winTime = winTime>tmpWinTime?winTime:tmpWinTime;
                System.out.println(mats[m + 1] + "  " + "输  0   "+getCalResult(initMoney,multiple[time]));
                time++;
                tmpWinTime=0;
            }

        }
        System.out.println("最大投入金额(仅针对两个号码不同的情况得出的结果)："+maxMoney);
        System.out.println("最大连赢次数："+winTime);
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
        return result.setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
    }
    /**获取内容的第一次期号*/
    private int getFirstStage(){
        String html = getHtml();
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
                "\n" +
                "<td>1</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0974</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>2</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0975</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>3</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0976</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>4</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0977</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>5</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0978</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>6</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0979</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>7</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0980</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>8</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0981</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>9</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0982</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>10</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0983</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>11</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0984</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>12</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0985</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>13</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0986</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>14</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0987</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>15</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0988</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>16</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0989</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class='ball_color1'> 3 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 29 </div></td><td class='ylfx_qw'><div class='ball_color2'> 0 </div></td><td class='ylfx_qw'><div class=''> 35 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 13 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 19 </div></td><td class='ylfx_qw'><div class=''> 21 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 10 </div></td><td class='ylfx_bw'><div class=''> 24 </div></td><td class='ylfx_bw'><div class='ball_color3'> 5 </div></td><td class='ylfx_bw'><div class=''> 20 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 19 </div></td><td class='ylfx_bw'><div class=''> 11 </div></td><td class='ylfx_sw'><div class=''> 43 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class='ball_color4'> 2 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class=''> 9 </div></td><td class='ylfx_sw'><div class=''> 22 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 16 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class='ball_color5'> 3 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 30 </div></td><td class='ylfx_gw'><div class=''> 15 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>17</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0990</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 17 </div></td><td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'><div class='ball_color1'> 3 </div></td><td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 30 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class='ball_color2'> 1 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 14 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 20 </div></td><td class='ylfx_qw'><div class=''> 22 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 11 </div></td><td class='ylfx_bw'><div class='ball_color3'> 4 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 21 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 20 </div></td><td class='ylfx_bw'><div class=''> 12 </div></td><td class='ylfx_sw'><div class=''> 44 </div></td><td class='ylfx_sw'><div class=''> 6 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 4 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class='ball_color4'> 5 </div></td><td class='ylfx_sw'><div class=''> 11 </div></td><td class='ylfx_sw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class=''> 23 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 17 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class='ball_color5'> 6 </div></td><td class='ylfx_gw'><div class=''> 16 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>18</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0991</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>19</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0992</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>20</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0993</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>21</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0994</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>22</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0995</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>23</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0996</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td>24</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0997</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>25</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0998</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>26</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-0999</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>27</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1000</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>28</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1001</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>29</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1002</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td>30</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1003</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>31</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1004</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td>32</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1005</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>33</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1006</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>34</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1007</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>35</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1008</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>36</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1009</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>37</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1010</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>38</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1011</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td>39</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1012</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>40</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1013</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td>41</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1014</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>42</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1015</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>43</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1016</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>44</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1017</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td>45</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1018</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td>46</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1019</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td>47</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1020</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>48</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1021</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td>49</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1022</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td>50</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170731-1023</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<script type=\"text/javascript\">";
    }


    @Test
    public void testXDTGetHtml() {
        XtdHtmlParamsRequest request = getRequestValue();
        ArrayList<String> result = XtdNumberUtil.getDataListFromHTML(getHtml().toString(), request);
        Assert.assertTrue(result.size() > 0);
        int i = 0;
        for (String output : result) {
            if (i % 5 == 0)
                System.out.print(output);
            else
                System.out.println();
            i++;
        }
    }


    private XtdHtmlParamsRequest getRequestValue() {

        XtdHtmlParamsRequest request = new XtdHtmlParamsRequest();
        request.setUrl("https://xtd909.com/Lottery/loylv/111/100")
                .setUrlPageSuffix("")
                //整体HTML范围
                .setHtmlStartRange("<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">")
                .setHtmlEndRange("<script type=\"text/javascript\">")
                //外层HTML数据
                .setTranslateStart_stage("<td style=\"background:#fff;color:#333333;\"><b>")
                .setTranslateEnd_stage("</b></td>")
                //内部HTML范围
                .setTmpHtmlStartRange("<td style=\"background:#fff;color:#333333;\"><b>")
                .setTmpHtmlEndRange("<tr class=\"ylfx_content\">")

                //内部HTML数据
                .setTranslateStart_myriabit("<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">")
                .setTranslateEnd_myriabit("</div></td>");

        return request;

    }

    String getTmpHtml() {
        return "<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">\n" +
                "<tbody>\n" +

                "<tr class=\"ylfx_content\">\n" +
                "<td>1</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0695</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class=''> 23 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><div class='ball_color1'> 5 </div></td><td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 13 </div></td><td class='ylfx_qw'><div class=''> 10 </div></td><td class='ylfx_qw'><div class='ball_color2'> 6 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 51 </div></td><td class='ylfx_bw'><div class=''> 18 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 12 </div></td><td class='ylfx_bw'><div class=''> 33 </div></td><td class='ylfx_bw'><div class=''> 16 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class='ball_color3'> 8 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_sw'><div class=''> 25 </div></td><td class='ylfx_sw'><div class=''> 12 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 15 </div></td><td class='ylfx_sw'><div class=''> 17 </div></td><td class='ylfx_sw'><div class='ball_color4'> 7 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 29 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 26 </div></td><td class='ylfx_gw'><div class=''> 14 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class='ball_color5'> 8 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>2</td>\n" +
                "<script type=\"text/javascript\">";
    }


    StringBuilder getHtml_1() {
        StringBuilder builder = new StringBuilder();
        builder.append("<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">\n" +
                "<tbody>\n" +
                "<tr style=\"background:#ffd200;color:#222222;height:25px;font-size:13px;\">\n" +
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
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0695</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class=''> 23 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><div class='ball_color1'> 5 </div></td><td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 13 </div></td><td class='ylfx_qw'><div class=''> 10 </div></td><td class='ylfx_qw'><div class='ball_color2'> 6 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 51 </div></td><td class='ylfx_bw'><div class=''> 18 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 12 </div></td><td class='ylfx_bw'><div class=''> 33 </div></td><td class='ylfx_bw'><div class=''> 16 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class='ball_color3'> 8 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_sw'><div class=''> 25 </div></td><td class='ylfx_sw'><div class=''> 12 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 15 </div></td><td class='ylfx_sw'><div class=''> 17 </div></td><td class='ylfx_sw'><div class='ball_color4'> 7 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 29 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 26 </div></td><td class='ylfx_gw'><div class=''> 14 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class='ball_color5'> 8 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>2</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0696</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'><div class=''> 24 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 14 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 10 </div></td><td class='ylfx_qw'><div class=''> 8 </div></td><td class='ylfx_qw'><div class=''> 14 </div></td><td class='ylfx_qw'><div class=''> 11 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class='ball_color2'> 9 </div></td><td class='ylfx_bw'><div class='ball_color3'> 0 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 13 </div></td><td class='ylfx_bw'><div class=''> 34 </div></td><td class='ylfx_bw'><div class=''> 17 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 26 </div></td><td class='ylfx_sw'><div class=''> 13 </div></td><td class='ylfx_sw'><div class=''> 6 </div></td><td class='ylfx_sw'><div class=''> 9 </div></td><td class='ylfx_sw'><div class=''> 16 </div></td><td class='ylfx_sw'><div class=''> 18 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class='ball_color4'> 8 </div></td><td class='ylfx_sw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 30 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 27 </div></td><td class='ylfx_gw'><div class=''> 15 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 9 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class='ball_color5'> 9 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>3</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0697</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">2</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'><div class=''> 25 </div></td><td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><div class='ball_color1'> 9 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 11 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 15 </div></td><td class='ylfx_qw'><div class='ball_color2'> 5 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class='ball_color3'> 2 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 14 </div></td><td class='ylfx_bw'><div class=''> 35 </div></td><td class='ylfx_bw'><div class=''> 18 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_sw'><div class=''> 9 </div></td><td class='ylfx_sw'><div class=''> 27 </div></td><td class='ylfx_sw'><div class=''> 14 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_sw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class=''> 17 </div></td><td class='ylfx_sw'><div class=''> 19 </div></td><td class='ylfx_sw'><div class='ball_color4'> 7 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 31 </div></td><td class='ylfx_gw'><div class='ball_color5'> 1 </div></td><td class='ylfx_gw'><div class=''> 28 </div></td><td class='ylfx_gw'><div class=''> 16 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 10 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>4</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0698</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class='ball_color1'> 1 </div></td><td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'><div class=''> 26 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 8 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 12 </div></td><td class='ylfx_qw'><div class=''> 10 </div></td><td class='ylfx_qw'><div class='ball_color2'> 4 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 15 </div></td><td class='ylfx_bw'><div class=''> 36 </div></td><td class='ylfx_bw'><div class=''> 19 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class='ball_color3'> 8 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class=''> 28 </div></td><td class='ylfx_sw'><div class=''> 15 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 11 </div></td><td class='ylfx_sw'><div class=''> 18 </div></td><td class='ylfx_sw'><div class=''> 20 </div></td><td class='ylfx_sw'><div class='ball_color4'> 7 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class='ball_color5'> 0 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 29 </div></td><td class='ylfx_gw'><div class=''> 17 </div></td><td class='ylfx_gw'><div class=''> 9 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 11 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>5</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0699</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'><div class=''> 27 </div></td><td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'><div class='ball_color1'> 5 </div></td><td class='ylfx_ww'><div class=''> 17 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 13 </div></td><td class='ylfx_qw'><div class=''> 11 </div></td><td class='ylfx_qw'><div class='ball_color2'> 4 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class='ball_color3'> 1 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 16 </div></td><td class='ylfx_bw'><div class=''> 37 </div></td><td class='ylfx_bw'><div class=''> 20 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 9 </div></td><td class='ylfx_sw'><div class=''> 11 </div></td><td class='ylfx_sw'><div class=''> 29 </div></td><td class='ylfx_sw'><div class=''> 16 </div></td><td class='ylfx_sw'><div class='ball_color4'> 3 </div></td><td class='ylfx_sw'><div class=''> 12 </div></td><td class='ylfx_sw'><div class=''> 19 </div></td><td class='ylfx_sw'><div class=''> 21 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 30 </div></td><td class='ylfx_gw'><div class=''> 18 </div></td><td class='ylfx_gw'><div class=''> 10 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 12 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class='ball_color5'> 8 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>6</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0700</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 14 </div></td><td class='ylfx_ww'><div class=''> 28 </div></td><td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'><div class='ball_color1'> 5 </div></td><td class='ylfx_ww'><div class=''> 18 </div></td><td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 10 </div></td><td class='ylfx_qw'><div class=''> 8 </div></td><td class='ylfx_qw'><div class=''> 14 </div></td><td class='ylfx_qw'><div class=''> 12 </div></td><td class='ylfx_qw'><div class='ball_color2'> 4 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 17 </div></td><td class='ylfx_bw'><div class=''> 38 </div></td><td class='ylfx_bw'><div class='ball_color3'> 6 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class='ball_color4'> 0 </div></td><td class='ylfx_sw'><div class=''> 30 </div></td><td class='ylfx_sw'><div class=''> 17 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 13 </div></td><td class='ylfx_sw'><div class=''> 20 </div></td><td class='ylfx_sw'><div class=''> 22 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 4 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class='ball_color5'> 0 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 31 </div></td><td class='ylfx_gw'><div class=''> 19 </div></td><td class='ylfx_gw'><div class=''> 11 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class=''> 13 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>7</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0701</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_ww'><div class=''> 29 </div></td><td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 19 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 11 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 15 </div></td><td class='ylfx_qw'><div class=''> 13 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class='ball_color2'> 7 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class='ball_color3'> 0 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 18 </div></td><td class='ylfx_bw'><div class=''> 39 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 11 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 31 </div></td><td class='ylfx_sw'><div class=''> 18 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 14 </div></td><td class='ylfx_sw'><div class=''> 21 </div></td><td class='ylfx_sw'><div class=''> 23 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class='ball_color4'> 9 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 32 </div></td><td class='ylfx_gw'><div class=''> 20 </div></td><td class='ylfx_gw'><div class=''> 12 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 14 </div></td><td class='ylfx_gw'><div class=''> 9 </div></td><td class='ylfx_gw'><div class='ball_color5'> 8 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>8</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0702</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_ww'><div class=''> 30 </div></td><td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 20 </div></td><td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'><div class='ball_color1'> 8 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 12 </div></td><td class='ylfx_qw'><div class='ball_color2'> 1 </div></td><td class='ylfx_qw'><div class=''> 16 </div></td><td class='ylfx_qw'><div class=''> 14 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 8 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 19 </div></td><td class='ylfx_bw'><div class=''> 40 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 9 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class='ball_color3'> 9 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class='ball_color4'> 1 </div></td><td class='ylfx_sw'><div class=''> 19 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class=''> 15 </div></td><td class='ylfx_sw'><div class=''> 22 </div></td><td class='ylfx_sw'><div class=''> 24 </div></td><td class='ylfx_sw'><div class=''> 4 </div></td><td class='ylfx_sw'><div class=''> 6 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class='ball_color5'> 0 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 33 </div></td><td class='ylfx_gw'><div class=''> 21 </div></td><td class='ylfx_gw'><div class=''> 13 </div></td><td class='ylfx_gw'><div class=''> 9 </div></td><td class='ylfx_gw'><div class=''> 15 </div></td><td class='ylfx_gw'><div class=''> 10 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>9</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0703</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><div class=''> 17 </div></td><td class='ylfx_ww'><div class=''> 31 </div></td><td class='ylfx_ww'><div class='ball_color1'> 4 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 21 </div></td><td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 13 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 17 </div></td><td class='ylfx_qw'><div class='ball_color2'> 3 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 8 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 9 </div></td><td class='ylfx_bw'><div class=''> 20 </div></td><td class='ylfx_bw'><div class=''> 41 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 10 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class='ball_color3'> 9 </div></td><td class='ylfx_sw'><div class='ball_color4'> 0 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 20 </div></td><td class='ylfx_sw'><div class=''> 4 </div></td><td class='ylfx_sw'><div class=''> 16 </div></td><td class='ylfx_sw'><div class=''> 23 </div></td><td class='ylfx_sw'><div class=''> 25 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 34 </div></td><td class='ylfx_gw'><div class=''> 22 </div></td><td class='ylfx_gw'><div class=''> 14 </div></td><td class='ylfx_gw'><div class='ball_color5'> 5 </div></td><td class='ylfx_gw'><div class=''> 16 </div></td><td class='ylfx_gw'><div class=''> 11 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>10</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0704</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><div class=''> 18 </div></td><td class='ylfx_ww'><div class=''> 32 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class='ball_color1'> 6 </div></td><td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 14 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 18 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class='ball_color2'> 5 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 10 </div></td><td class='ylfx_qw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class='ball_color3'> 3 </div></td><td class='ylfx_bw'><div class=''> 21 </div></td><td class='ylfx_bw'><div class=''> 42 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 11 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class='ball_color4'> 0 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 21 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 17 </div></td><td class='ylfx_sw'><div class=''> 24 </div></td><td class='ylfx_sw'><div class=''> 26 </div></td><td class='ylfx_sw'><div class=''> 6 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class=''> 35 </div></td><td class='ylfx_gw'><div class=''> 23 </div></td><td class='ylfx_gw'><div class=''> 15 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 17 </div></td><td class='ylfx_gw'><div class=''> 12 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class='ball_color5'> 9 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>11</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0705</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><div class=''> 19 </div></td><td class='ylfx_ww'><div class=''> 33 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 13 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_qw'><div class=''> 15 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 19 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class='ball_color2'> 6 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 11 </div></td><td class='ylfx_qw'><div class=''> 9 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 22 </div></td><td class='ylfx_bw'><div class='ball_color3'> 5 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 12 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class='ball_color4'> 1 </div></td><td class='ylfx_sw'><div class=''> 22 </div></td><td class='ylfx_sw'><div class=''> 6 </div></td><td class='ylfx_sw'><div class=''> 18 </div></td><td class='ylfx_sw'><div class=''> 25 </div></td><td class='ylfx_sw'><div class=''> 27 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_sw'><div class=''> 9 </div></td><td class='ylfx_sw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 36 </div></td><td class='ylfx_gw'><div class=''> 24 </div></td><td class='ylfx_gw'><div class=''> 16 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 18 </div></td><td class='ylfx_gw'><div class=''> 13 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class='ball_color5'> 9 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>12</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0706</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><div class=''> 20 </div></td><td class='ylfx_ww'><div class=''> 34 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 14 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_qw'><div class=''> 16 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 20 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class='ball_color2'> 8 </div></td><td class='ylfx_qw'><div class=''> 10 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 9 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 23 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class='ball_color3'> 6 </div></td><td class='ylfx_bw'><div class=''> 13 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 23 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_sw'><div class=''> 19 </div></td><td class='ylfx_sw'><div class=''> 26 </div></td><td class='ylfx_sw'><div class='ball_color4'> 6 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class='ball_color5'> 1 </div></td><td class='ylfx_gw'><div class=''> 37 </div></td><td class='ylfx_gw'><div class=''> 25 </div></td><td class='ylfx_gw'><div class=''> 17 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td><td class='ylfx_gw'><div class=''> 19 </div></td><td class='ylfx_gw'><div class=''> 14 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>13</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0707</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class=''> 21 </div></td><td class='ylfx_ww'><div class=''> 35 </div></td><td class='ylfx_ww'><div class='ball_color1'> 4 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><div class=''> 3 </div></td><td class='ylfx_ww'><div class=''> 15 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_qw'><div class=''> 17 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 21 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 7 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class='ball_color2'> 7 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 11 </div></td><td class='ylfx_bw'><div class=''> 6 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 10 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class='ball_color3'> 4 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 14 </div></td><td class='ylfx_bw'><div class=''> 9 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class='ball_color4'> 1 </div></td><td class='ylfx_sw'><div class=''> 24 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_sw'><div class=''> 20 </div></td><td class='ylfx_sw'><div class=''> 27 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 9 </div></td><td class='ylfx_sw'><div class=''> 11 </div></td><td class='ylfx_sw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 38 </div></td><td class='ylfx_gw'><div class=''> 26 </div></td><td class='ylfx_gw'><div class='ball_color5'> 4 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td><td class='ylfx_gw'><div class=''> 20 </div></td><td class='ylfx_gw'><div class=''> 15 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>14</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0708</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">3</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">4</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">6</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">5</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 10 </div></td><td class='ylfx_ww'><div class=''> 22 </div></td><td class='ylfx_ww'><div class='ball_color1'> 3 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 8 </div></td><td class='ylfx_ww'><div class=''> 4 </div></td><td class='ylfx_ww'><div class=''> 16 </div></td><td class='ylfx_ww'><div class=''> 6 </div></td><td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_qw'><div class=''> 18 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 22 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class='ball_color2'> 4 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 12 </div></td><td class='ylfx_bw'><div class=''> 7 </div></td><td class='ylfx_bw'><div class=''> 9 </div></td><td class='ylfx_bw'><div class=''> 11 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 3 </div></td><td class='ylfx_bw'><div class='ball_color3'> 6 </div></td><td class='ylfx_bw'><div class=''> 15 </div></td><td class='ylfx_bw'><div class=''> 10 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 4 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 25 </div></td><td class='ylfx_sw'><div class=''> 9 </div></td><td class='ylfx_sw'><div class=''> 21 </div></td><td class='ylfx_sw'><div class='ball_color4'> 5 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class=''> 12 </div></td><td class='ylfx_sw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class='ball_color5'> 1 </div></td><td class='ylfx_gw'><div class=''> 39 </div></td><td class='ylfx_gw'><div class=''> 27 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 5 </div></td><td class='ylfx_gw'><div class=''> 21 </div></td><td class='ylfx_gw'><div class=''> 16 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class=''> 3 </div></td></tr><tr class=\"ylfx_content\">\n" +
                "<td>15</td>\n" +
                "<td style=\"background:#fff;color:#333333;\"><b>20170730-0709</b></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">0</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">1</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">9</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">8</div></td>\n" +
                "<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">7</div></td>\n" +
                "<td class='ylfx_ww'><div class='ball_color1'> 0 </div></td><td class='ylfx_ww'><div class=''> 11 </div></td><td class='ylfx_ww'><div class=''> 23 </div></td><td class='ylfx_ww'><div class=''> 1 </div></td><td class='ylfx_ww'><div class=''> 2 </div></td><td class='ylfx_ww'><div class=''> 9 </div></td><td class='ylfx_ww'><div class=''> 5 </div></td><td class='ylfx_ww'><div class=''> 17 </div></td><td class='ylfx_ww'><div class=''> 7 </div></td><td class='ylfx_ww'><div class=''> 12 </div></td><td class='ylfx_qw'><div class=''> 19 </div></td><td class='ylfx_qw'><div class='ball_color2'> 1 </div></td><td class='ylfx_qw'><div class=''> 23 </div></td><td class='ylfx_qw'><div class=''> 6 </div></td><td class='ylfx_qw'><div class=''> 1 </div></td><td class='ylfx_qw'><div class=''> 5 </div></td><td class='ylfx_qw'><div class=''> 4 </div></td><td class='ylfx_qw'><div class=''> 2 </div></td><td class='ylfx_qw'><div class=''> 3 </div></td><td class='ylfx_qw'><div class=''> 13 </div></td><td class='ylfx_bw'><div class=''> 8 </div></td><td class='ylfx_bw'><div class=''> 10 </div></td><td class='ylfx_bw'><div class=''> 12 </div></td><td class='ylfx_bw'><div class=''> 5 </div></td><td class='ylfx_bw'><div class=''> 2 </div></td><td class='ylfx_bw'><div class=''> 4 </div></td><td class='ylfx_bw'><div class=''> 1 </div></td><td class='ylfx_bw'><div class=''> 16 </div></td><td class='ylfx_bw'><div class=''> 11 </div></td><td class='ylfx_bw'><div class='ball_color3'> 9 </div></td><td class='ylfx_sw'><div class=''> 5 </div></td><td class='ylfx_sw'><div class=''> 2 </div></td><td class='ylfx_sw'><div class=''> 26 </div></td><td class='ylfx_sw'><div class=''> 10 </div></td><td class='ylfx_sw'><div class=''> 22 </div></td><td class='ylfx_sw'><div class=''> 1 </div></td><td class='ylfx_sw'><div class=''> 3 </div></td><td class='ylfx_sw'><div class=''> 11 </div></td><td class='ylfx_sw'><div class='ball_color4'> 8 </div></td><td class='ylfx_sw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 7 </div></td><td class='ylfx_gw'><div class=''> 1 </div></td><td class='ylfx_gw'><div class=''> 40 </div></td><td class='ylfx_gw'><div class=''> 28 </div></td><td class='ylfx_gw'><div class=''> 2 </div></td><td class='ylfx_gw'><div class=''> 6 </div></td><td class='ylfx_gw'><div class=''> 22 </div></td><td class='ylfx_gw'><div class='ball_color5'> 7 </div></td><td class='ylfx_gw'><div class=''> 8 </div></td><td class='ylfx_gw'><div class=''> 4 </div></td></tr><tr style=\"text-align:center;background:#ffd7a3;color:#222222\">\n" +
                "<td colspan=\"2\"><b>出现次数</b></td>\n" +
                "<td colspan=\"5\"></td>\n" +
                "<td>5</td><td>1</td><td>0</td><td>1</td><td>2</td><td>3</td><td>1</td><td>0</td><td>1</td><td>1</td><td>0</td><td>2</td><td>0</td><td>1</td><td>4</td><td>2</td><td>2</td><td>2</td><td>1</td><td>1</td><td>2</td><td>1</td><td>1</td><td>1</td><td>1</td><td>1</td><td>3</td><td>0</td><td>2</td><td>3</td><td>3</td><td>3</td><td>0</td><td>1</td><td>0</td><td>1</td><td>1</td><td>3</td><td>2</td><td>1</td><td>3</td><td>3</td><td>0</td><td>0</td><td>1</td><td>1</td><td>0</td><td>1</td><td>3</td><td>3</td></tr>\n" +
                "<tr style=\"text-align:center;background:#eaff8a;color:#222222\">\n" +
                "<td colspan=\"2\"><b>最大遗漏</b></td>\n" +
                "<td colspan=\"5\"></td>\n" +
                "<td>12</td><td>11</td><td>23</td><td>35</td><td>13</td><td>9</td><td>21</td><td>17</td><td>10</td><td>16</td><td>19</td><td>9</td><td>23</td><td>14</td><td>15</td><td>11</td><td>9</td><td>7</td><td>11</td><td>51</td><td>18</td><td>10</td><td>12</td><td>9</td><td>23</td><td>42</td><td>20</td><td>16</td><td>11</td><td>11</td><td>11</td><td>31</td><td>26</td><td>10</td><td>22</td><td>27</td><td>27</td><td>11</td><td>12</td><td>8</td><td>31</td><td>8</td><td>40</td><td>28</td><td>17</td><td>9</td><td>22</td><td>16</td><td>8</td><td>7</td></tr>\n" +
                "<tr style=\"background:#ffd200;color:#222222;height:25px;font-size:13px;\">\n" +
                "<th rowspan=\"2\">序号</th>\n" +
                "<th rowspan=\"2\">期号</th>\n" +
                "<th rowspan=\"2\" colspan=\"5\">开奖号码</th>\n" +
                "<th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "<th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "<th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "<th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "<th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th>\n" +
                "</tr>\n" +
                "<tr style=\"background:#ffd200;color:#222222;height:25px;font-size:13px;\">\n" +
                "<th colspan=\"10\"><div class=\"line\">万位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">千位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">百位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">十位</div></th>\n" +
                "<th colspan=\"10\"><div class=\"line\">个位</div></th>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "<script type=\"text/javascript\">");
        return builder;

    }
}
