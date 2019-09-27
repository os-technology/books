package org.htmltranslate.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author code
 * @Title: TencentClassTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/119:30 PM
 */
public class TencentClassTest {

    @Test
    public void getClassName() {

        HtmlFilterDataRequest request = getHtmlFilterDataRequest();
        ArrayList<String> list = HtmlUtil.getDataListFromHTML("", getHtml(), request);
        list.stream().forEach(str -> {
            if (StringUtils.isNotEmpty(str)) {
                System.out.println(str.trim());
            }

        });


    }

    private HtmlFilterDataRequest getHtmlFilterDataRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request//.setHtmlStartRange("<div class=\"detail-item-body\" style=\"height: 420px;\">")
                //.setHtmlEndRange("endHtml")

                //抓取名称数据
                .setTranslateStart("<div class=\"task-title\">")
                //抓取时间数据
//                .setTranslateStart("<div class=\"sub-title\">")
                .setTranslateEnd("</div>")

        ;


        return request;
    }

    public String getHtml() {
        String html = "<div class=\"detail-item-body\" style=\"height: 480px;\"><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"1\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 28 A13 13 0 0 1 14.999999999999996 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">Zookeeper精华知识快速搞定</div><div class=\"sub-title\">2019-08-11 周日 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"0\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">Zookeeper精华知识快速搞定</div><div class=\"sub-title\">2019-08-13 周二 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"0\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">进击源码，从客户端开始</div><div class=\"sub-title\">2019-08-15 周四 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"1\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 28 A13 13 0 0 1 14.999999999999996 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">ZK服务端原理深入解析</div><div class=\"sub-title\">2019-08-18 周日 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"1\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 28 A13 13 0 0 1 14.999999999999996 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">ZK源码成仙之路，就差这一节课</div><div class=\"sub-title\">2019-08-20 周二 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"1\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 28 A13 13 0 0 1 14.999999999999996 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">工作必会的ZK技能，一定要来听</div><div class=\"sub-title\">2019-08-22 周四 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"0\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">MyBatis开发你必须知道的那些事</div><div class=\"sub-title\">2019-08-25 周日 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div><div class=\"task-item-ctn\"><div class=\"icon\"><div class=\"process\" data=\"1\"><svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\"><ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\" stroke=\"#000\" fill=\"none\"></ellipse><path d=\"M15 2 A13 13 0 0 1 15 28 A13 13 0 0 1 14.999999999999996 2\" style=\"stroke-width:2px;stroke:#23b8ff;\" stroke=\"#000\" fill=\"none\"></path></svg></div><i><span class=\"im-icon icon-font i-replay-border\"></span></i></div><div class=\"task-title\">摸了MyBtis的骨架，我才知道什么是骨骼惊奇</div><div class=\"sub-title\">2019-08-27 周二 20:00-22:00</div><div class=\"status-text\"></div><div class=\"task-button-ctn\"><div class=\"js-report-link task-btn info border\"><span>看回放</span></div></div></div></div>";

        return html + "endHtml";
    }
}
