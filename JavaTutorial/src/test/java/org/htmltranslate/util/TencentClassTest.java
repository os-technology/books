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
//                .setTranslateStart("<div class=\"task-title\">")
                //抓取时间数据
                .setTranslateStart("<div class=\"sub-title\">")
                .setTranslateEnd("</div>")

        ;


        return request;
    }

    public String getHtml() {

        StringBuilder builder = new StringBuilder();
        builder.append("<div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t<div class=\"section-title\">并发编程\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t\t\t\t</div><div class=\"task-title\">\t线程基础、线程间的共享和协作</div><div class=\"sub-title\">\t2018-05-06周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t线程基础'线程间共享和协作/线程并发工具类</div><div class=\"sub-title\">\t2018-05-08周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t线程并发工具类（2）-（3）</div><div class=\"sub-title\">\t2018-05-10周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t原子操作CAS/显示锁和AQS（1）</div><div class=\"sub-title\">\t2018-05-13周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t显示锁和AQS（2）-（3）</div><div class=\"sub-title\">\t2018-05-15周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t3</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">并发编程\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\t并发容器(1)-(2)</div><div class=\"sub-title\">\t2018-05-17周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t并发容器(3)-(4)</div><div class=\"sub-title\">\t2018-05-20周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t线程池</div><div class=\"sub-title\">\t2018-05-22周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t并发安全（1）-（2）</div><div class=\"sub-title\">\t2018-05-24周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t并发安全（3）/实战-并发任务执行框架（1）</div><div class=\"sub-title\">\t2018-05-27周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t实战-并发任务执行框架(2)/性能优化实战(1)</div><div class=\"sub-title\">\t2018-05-29周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t实战项目-性能优化实战（2）-（3）</div><div class=\"sub-title\">\t2018-05-31周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tJVM和底层实现原理</div><div class=\"sub-title\">\t2018-06-03周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring基础及组件使用（1）</div><div class=\"sub-title\">\t2018-06-05周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring基础及组件使用（2）</div><div class=\"sub-title\">\t2018-06-07周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t4</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">Spring\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tSpring基础及组件使用（3）</div><div class=\"sub-title\">\t2018-06-10周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring的BeanPostProcessor分析及组件使用</div><div class=\"sub-title\">\t2018-06-12周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring组件及aop基本使用操作</div><div class=\"sub-title\">\t2018-06-14周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t5</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">Spring\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tSpring的aop底层源码分析（1）</div><div class=\"sub-title\">\t2018-06-19周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring的aop底层源码分析（2）</div><div class=\"sub-title\">\t2018-06-21周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring的声明式事务底层源码分析</div><div class=\"sub-title\">\t2018-06-24周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t6</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">spring\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tSpring的拓展组件原理及IOC源码讲解</div><div class=\"sub-title\">\t2018-06-26周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring的IOC源码讲解</div><div class=\"sub-title\">\t2018-06-28周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpringMvc与Servlet3.0那些事</div><div class=\"sub-title\">\t2018-07-01周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t7</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">Spring/Mybatis\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tSpringMvc与Servlet3.0异步处理及总结</div><div class=\"sub-title\">\t2018-07-03周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpring大结局（总结回顾）</div><div class=\"sub-title\">\t2018-07-05周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t手写SpringMvc大结局</div><div class=\"sub-title\">\t2018-07-08周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis概述与进阶/mybatis进阶（1）</div><div class=\"sub-title\">\t2018-07-10周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis进阶（2）-（3）</div><div class=\"sub-title\">\t2018-07-12周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis进阶（4）-（5）</div><div class=\"sub-title\">\t2018-07-15周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis进阶（6）-（7）</div><div class=\"sub-title\">\t2018-07-17周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t8</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">mybatis\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tmybatis高级（1）-（2）</div><div class=\"sub-title\">\t2018-07-19周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis高级（3）-（4）</div><div class=\"sub-title\">\t2018-07-22周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis高级（5）-（6）</div><div class=\"sub-title\">\t2018-07-24周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis高级（7）-（8）</div><div class=\"sub-title\">\t2018-07-26周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t9</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">mybatis/jvm与性能调优\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tmybatis高级（9）-（10）</div><div class=\"sub-title\">\t2018-07-29周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis高级（11）-（12）</div><div class=\"sub-title\">\t2018-07-31周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMybatis插件开发及分页插件讲解</div><div class=\"sub-title\">\t2018-08-01周三20:00-20:30</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t虚拟机的前世今生和java内存区域</div><div class=\"sub-title\">\t2018-08-02周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t垃圾回收器和内存分配策略（1）-（2）</div><div class=\"sub-title\">\t2018-08-05周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t垃圾回收器和内存分配策略（3）-（4）</div><div class=\"sub-title\">\t2018-08-07周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmybatis源码概述及手写mybatis解析</div><div class=\"sub-title\">\t2018-08-08周三20:00-21:30</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t垃圾回收器和内存分配策略/JVM的执行子系统</div><div class=\"sub-title\">\t2018-08-09周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tJVM的执行子系统（2）-（3）</div><div class=\"sub-title\">\t2018-08-12周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t编写高效优雅java程序（1）-（2）</div><div class=\"sub-title\">\t2018-08-14周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t10</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">jvm与性能调优/tomcat\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\t编写高效优雅java程序(3)/深入了解性能优化</div><div class=\"sub-title\">\t2018-08-16周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t深入了解性能优化（2）-（3）</div><div class=\"sub-title\">\t2018-08-19周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tTomcat架构解析（1）</div><div class=\"sub-title\">\t2018-08-21周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t11</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">tomcat/mysql/nginx\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tTomcat架构解析（2）</div><div class=\"sub-title\">\t2018-08-23周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t嵌入式Tomcat</div><div class=\"sub-title\">\t2018-08-26周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tTomcat性能优化</div><div class=\"sub-title\">\t2018-08-28周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMySql优化概述/MySql架构与存储引擎</div><div class=\"sub-title\">\t2018-08-30周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t锁/事务</div><div class=\"sub-title\">\t2018-09-02周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t业务设计</div><div class=\"sub-title\">\t2018-09-04周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t慢查询/索引与执行计划</div><div class=\"sub-title\">\t2018-09-06周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tLinux基础补课</div><div class=\"sub-title\">\t2018-09-07周五20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMySql优化</div><div class=\"sub-title\">\t2018-09-09周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNginx进阶第一课</div><div class=\"sub-title\">\t2018-09-11周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t12</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">nginx/netty\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tNginx进阶第二课</div><div class=\"sub-title\">\t2018-09-13周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNginx进阶第三课</div><div class=\"sub-title\">\t2018-09-16周日19:30-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNginx进阶第四课</div><div class=\"sub-title\">\t2018-09-18周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNginx进阶第五课</div><div class=\"sub-title\">\t2018-09-20周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tJava网络编程基础（1）-（2）</div><div class=\"sub-title\">\t2018-09-25周二20:00-21:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tJava网络编程基础（3）</div><div class=\"sub-title\">\t2018-09-27周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tJava网络编程基础（4）</div><div class=\"sub-title\">\t2018-09-29周六20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNetty应用（1）-（2）</div><div class=\"sub-title\">\t2018-10-09周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNetty应用（3）-（4）</div><div class=\"sub-title\">\t2018-10-11周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNetty应用（5）-（6）</div><div class=\"sub-title\">\t2018-10-14周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t13</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">netty/分布式思维/zookeeper\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tNetty应用（7）/Netty进阶与实战（1）</div><div class=\"sub-title\">\t2018-10-16周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNetty进阶与实战（2）-（3）</div><div class=\"sub-title\">\t2018-10-18周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tNetty进阶与实战（4）-（5）</div><div class=\"sub-title\">\t2018-10-21周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t深入Netty</div><div class=\"sub-title\">\t2018-10-23周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t分布式思维</div><div class=\"sub-title\">\t2018-10-24周三20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tZookeeper（1）-（2）</div><div class=\"sub-title\">\t2018-10-25周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tZookeeper（3）-（4）</div><div class=\"sub-title\">\t2018-10-28周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t原生API/zkClient1/curator2</div><div class=\"sub-title\">\t2018-10-30周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t14</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">zookeeper/架构核心服务层技术基础篇\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tZookeeper高级（7）-（8）</div><div class=\"sub-title\">\t2018-11-01周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tZookeeper高级（9）-（10）</div><div class=\"sub-title\">\t2018-11-04周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t深入理解通讯协议</div><div class=\"sub-title\">\t2018-11-06周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t基于分布式思想下的rpc解决方案</div><div class=\"sub-title\">\t2018-11-08周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t15</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">dubbo\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tdubbo（1）</div><div class=\"sub-title\">\t2018-11-11周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tdubbo（2）</div><div class=\"sub-title\">\t2018-11-13周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tdubbo（3）</div><div class=\"sub-title\">\t2018-11-15周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tdubbo（4）</div><div class=\"sub-title\">\t2018-11-18周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tdubbo（5）</div><div class=\"sub-title\">\t2018-11-20周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t16</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">消息中间件\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\t消息中间件概述与activemq（1）-（2）</div><div class=\"sub-title\">\t2018-11-22周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t消息中间件概述与activemq（3）-（4）</div><div class=\"sub-title\">\t2018-11-25周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t消息中间件概述与activemq（5）-（6）</div><div class=\"sub-title\">\t2018-11-27周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t消息中间件概述与activemq（7）-（8）</div><div class=\"sub-title\">\t2018-12-01周六20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t消息中间件概述与activemq(9)/rabbitmq(1)</div><div class=\"sub-title\">\t2018-12-02周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRabbitmq（2）-（3）</div><div class=\"sub-title\">\t2018-12-04周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRabbitmq（4）-（5）</div><div class=\"sub-title\">\t2018-12-06周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRabbitmq（6）-（7）</div><div class=\"sub-title\">\t2018-12-09周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRabbitmq（8）/kafka（1）</div><div class=\"sub-title\">\t2018-12-11周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t17</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">消息中间件\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tkafka（2）</div><div class=\"sub-title\">\t2018-12-13周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tkafka（3）-（4）</div><div class=\"sub-title\">\t2018-12-16周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tkafka（5）-（6）</div><div class=\"sub-title\">\t2018-12-18周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tkafka（7）-（8）</div><div class=\"sub-title\">\t2018-12-20周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t18</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">消息中间件/redis/缓存实战方案、分布式常见问题解决方案\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tkafka（9）-（10）</div><div class=\"sub-title\">\t2018-12-23周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRedis（1）</div><div class=\"sub-title\">\t2018-12-25周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRedis（2）</div><div class=\"sub-title\">\t2018-12-27周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRedis（3）</div><div class=\"sub-title\">\t2019-01-03周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tRedis（4）</div><div class=\"sub-title\">\t2019-01-06周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t缓存实战cache</div><div class=\"sub-title\">\t2019-01-08周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t分布式事务与锁</div><div class=\"sub-title\">\t2019-01-10周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t分布式事务</div><div class=\"sub-title\">\t2019-01-13周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t单点登陆方案实战</div><div class=\"sub-title\">\t2019-01-15周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t分布式任务调度方案</div><div class=\"sub-title\">\t2019-01-17周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t19</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">memcached分布式缓存\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tmemcached分布式缓存</div><div class=\"sub-title\">\t2019-01-20周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t20</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">Mongdb\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tMongoDB概述快速入门</div><div class=\"sub-title\">\t2019-01-22周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMongoDB应用与开发</div><div class=\"sub-title\">\t2019-01-24周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMongoDB查询与JAVA客户端</div><div class=\"sub-title\">\t2019-01-27周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMongoDB更新与安全</div><div class=\"sub-title\">\t2019-02-14周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMongoDB存储引擎、索引、高可用和最佳实践</div><div class=\"sub-title\">\t2019-02-17周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMongoDB高级进阶</div><div class=\"sub-title\">\t2019-02-19周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t21</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">Mysql高性能存储实战\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tMysql高可用进阶与实战</div><div class=\"sub-title\">\t2019-02-21周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMycat配置精讲</div><div class=\"sub-title\">\t2019-02-24周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tMycat实现数据库切分实战</div><div class=\"sub-title\">\t2019-02-26周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t22</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">Docker虚拟化技术\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tdocker进阶（1）</div><div class=\"sub-title\">\t2019-02-28周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tdocker进阶（2）</div><div class=\"sub-title\">\t2019-03-03周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tdocker进阶（3）</div><div class=\"sub-title\">\t2019-03-05周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t23</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">springboot/springcloud\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tSpringBoot基础</div><div class=\"sub-title\">\t2019-03-07周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpringBoot进阶</div><div class=\"sub-title\">\t2019-03-10周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tSpringBoot高级</div><div class=\"sub-title\">\t2019-03-12周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tspringcloud概述</div><div class=\"sub-title\">\t2019-03-14周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t24</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">springcloud\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\teureka从使用到源码</div><div class=\"sub-title\">\t2019-03-17周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tribbon使用进阶</div><div class=\"sub-title\">\t2019-03-19周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tfeign面向接口的服务调用</div><div class=\"sub-title\">\t2019-03-21周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tZuul网关全面探析</div><div class=\"sub-title\">\t2019-03-24周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t25</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">springcloud/maven\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tSpringCloud组件大闯关</div><div class=\"sub-title\">\t2019-03-26周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tspringcloud第七节课</div><div class=\"sub-title\">\t2019-03-27周三20:00-21:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tmaven（1）-maven不得不知道的那些事</div><div class=\"sub-title\">\t2019-03-28周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t26</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">maven/git\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tmaven（2）-maven进阶实战</div><div class=\"sub-title\">\t2019-03-31周日20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\tgit-深入浅出git</div><div class=\"sub-title\">\t2019-04-02周二20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t27</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">jenkins\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\tjenkins-配置即代码</div><div class=\"sub-title\">\t2019-04-04周四20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t商城实战</div><div class=\"sub-title\">\t2019-05-22周三20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t</div><div class=\"task-title\">\t商城实战</div><div class=\"sub-title\">\t2019-05-25周六20:00-22:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"detail-item-ctn\">\n" +
                "\t\t<div class=\"detail-item-header\">\n" +
                "\t\t\t<div class=\"icon\"><div class=\"process\" data=\"0\">\t\t\t<ellipse cx=\"18\" cy=\"18\" rx=\"16\" ry=\"16\" style=\"stroke-width:2px;stroke:#ade1fa;\"\t\t\t\t\t\t<path d=\"M18 2 A16 16 0 0 1 18 2\" style=\"stroke-width:2px;stroke:#23b8ff;\"\t\t\t\t</path>\t</svg></div><div class=\"index\">\t28</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"section-title\">商城实战\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"detail-item-body\" style=\"height: 0px;\">\n" +
                "\t</div><div class=\"task-title\">\t商城实战</div><div class=\"sub-title\">\t2019-05-31周五20:00-21:00</div><div class=\"status-text\"></div></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>");

        return builder.toString();
    }
}
