package org.chapter.databasic.mail;

import org.apache.velocity.app.VelocityEngine;

import java.util.Map;

/**
 * @Title:VelocityEmail.java
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017年2月27日下午5:39:58
 * @Author yujinshui@lxfintech.com
 */
public class EmailConfig {

    private String emailHost = "smtp.qq.com";
    private String userName = "notice@qq.com";
    private String password = "Hello1234";
    /**
     * 邮件发送者，包括发送者姓名和地址，用于设置在邮件的from栏目中
     */
    private String from = "notice@qq.com";
    private String[] to;
    private Map<String, Object> model;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容模板地址/名称
     */
    private String templateName;

    /**
     * velocity引擎
     */
    private VelocityEngine velocityEngine;

    public String getFrom() {
        return this.from;
    }

    /**
     * 设置邮件发送者，包括发送者姓名和地址，用于设置在邮件的from栏目中
     *
     * @param from
     */
    public EmailConfig setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailConfig setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置邮件内容模板地址/名称
     *
     * @param templateName
     */
    public EmailConfig setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public EmailConfig setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
        return this;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public EmailConfig setEmailHost(String emailHost) {
        this.emailHost = emailHost;
        return this;
    }

    public String[] getTo() {
        return to;
    }

    /**
     * 设置收件人，用数组发送多个邮件
     *
     * @param to
     * @return
     */
    public EmailConfig setTo(String[] to) {
        this.to = to;
        return this;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    /**
     * 内容参数配置
     *
     * @param model
     * @return
     */
    public EmailConfig setModel(Map<String, Object> model) {
        this.model = model;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * 发件箱用户名
     *
     * @param userName
     * @return
     */
    public EmailConfig setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    /**
     * 发件箱密码
     *
     * @param password
     * @return
     */
    public EmailConfig setPassword(String password) {
        this.password = password;
        return this;
    }

}
