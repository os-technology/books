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
    public void getClassName(){

        HtmlFilterDataRequest request = getHtmlFilterDataRequest();
        ArrayList<String> list = HtmlUtil.getDataListFromHTML("", getHtml(), request);
        list.stream().forEach(str->{
            if (StringUtils.isNotEmpty(str)){
                System.out.println(str.trim());
            }

        });



    }
    private HtmlFilterDataRequest getHtmlFilterDataRequest() {
        HtmlFilterDataRequest request = new HtmlFilterDataRequest();
        request.setHtmlStartRange("<div class=\"detail-item-body\" style=\"height: 420px;\">")
                .setHtmlEndRange("endHtml")

                //抓取名称数据
//                .setTranslateStart("<div class=\"task-title\">")
        //抓取时间数据
                .setTranslateStart("<div class=\"sub-title\">")
                .setTranslateEnd("</div>")

        ;


        return request;
    }
    public String getHtml(){
        String html = "<div class=\"detail-item-body\" style=\"height: 480px;\">\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\tZookeeper基础概念\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-11 周日 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\tZookeeper安装与特性\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-13 周二 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\t命令行与三大JAVA客户端\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-15 周四 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\t协议与集群搭建\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-18 周日 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\t分布式锁&amp;注册中心&amp;服务注册与发现\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-20 周二 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\tMyBatis配置详解与开发进阶\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-22 周四 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\t动态SQL与逆向工程\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-25 周日 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"task-item-ctn\">\n" +
                "\t\t<div class=\"icon\">\n" +
                "\t\t\t<div class=\"process\" data=\"0\">\n" +
                "\t\t\t\t<svg vesion=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" style=\"width:100%;height:100%;\">\n" +
                "\t\t\t\t\t<ellipse cx=\"15\" cy=\"15\" rx=\"13\" ry=\"13\" style=\"stroke-width:2px;stroke:#ade1fa;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</ellipse>\n" +
                "\t\t\t\t\t<path d=\"M15 2 A13 13 0 0 1 15 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\n" +
                "\t\t\t\t\tstroke=\"#000\" fill=\"none\">\n" +
                "\t\t\t\t\t</path>\n" +
                "\t\t\t\t</svg>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<i>\n" +
                "\t\t\t\t<span class=\"im-icon icon-font i-replay-border\">\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</i>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-title\">\n" +
                "\t\t\t缓存、复杂SQL与Spring的集成\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"sub-title\">\n" +
                "\t\t\t2019-08-27 周二 20:00-22:00\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"status-text\">\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"task-button-ctn\">\n" +
                "\t\t\t<div class=\"js-report-link task-btn info border\">\n" +
                "\t\t\t\t<span>\n" +
                "\t\t\t\t\t看回放\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>";

        return html+"endHtml";
    }
}
