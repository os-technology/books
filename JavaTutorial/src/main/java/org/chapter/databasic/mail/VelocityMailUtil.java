package org.chapter.databasic.mail;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: EmailSenderService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/2/24下午5:21
 */

public class VelocityMailUtil {
	private static String encoding = "UTF-8";

	/**
	 * 发送HTML格式邮件
	 * 
	 * @param config
	 * @return
	 * @throws MessagingException
	 * @Author yujinshui
	 * @createTime 2017年2月27日 下午8:28:52
	 */
	public static void sendHtmlMail(EmailConfig config) throws MessagingException {
		JavaMailSenderImpl senderImpl = getMailSender(config);
		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = getMimeMessage(config, senderImpl);
		// 发送邮件
		senderImpl.send(mailMessage);
		System.out.println("邮件发送成功.");
	}

	/**
	 * 发送HTML邮件内容获取配置
	 * 
	 * @param config
	 * @param senderImpl
	 * @return
	 * @throws MessagingException
	 * @Author yujinshui
	 * @createTime 2017年2月27日 下午8:35:39
	 */
	private static MimeMessage getMimeMessage(EmailConfig config, JavaMailSenderImpl senderImpl)
			throws MessagingException {
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, encoding);
		// 设置收件人，寄件人
		messageHelper.setTo(config.getTo());
		messageHelper.setFrom(config.getFrom());
		messageHelper.setSubject(config.getSubject());
		// true 表示启动HTML格式的邮件
		messageHelper.setText(getContent(config), true);
		return mailMessage;
	}

	/**
	 * 
	 * @param config
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年2月27日 下午8:31:02
	 */
	private static JavaMailSenderImpl getMailSender(EmailConfig config) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		// 设定mail server
		senderImpl.setHost(config.getEmailHost());
		senderImpl.setUsername(config.getUserName()); // 根据自己的情况,设置username
		senderImpl.setPassword(config.getPassword()); // 根据自己的情况, 设置password
		senderImpl.setJavaMailProperties(getProp());
		return senderImpl;
	}

	private static Properties getProp() {

		Properties pro = new Properties();
		pro.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		pro.put("mail.smtp.timeout", "25000");
		return pro;
	}

	private static String getContent(EmailConfig config) {
		if (config.getTemplateName() == null) {
			config.setTemplateName("mail.vm");
			return VelocityEngineUtils.mergeTemplateIntoString(getEngine(), config.getTemplateName(), encoding,
					getModelContent(config.getModel()));
		}
		return VelocityEngineUtils.mergeTemplateIntoString(getEngine(), config.getTemplateName(), encoding,
				config.getModel());
	}

	private static Map<String, Object> getModelContent(Map<String, Object> map) {
		StringBuilder builder = new StringBuilder();
		for (Entry<String, Object> m : map.entrySet()) {
			builder.append(m.getValue()).append("<br>");
		}

		map.put("content", builder.toString());
		return map;
	}

	/**
	 *
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年2月27日 下午5:06:14
	 */
	private static VelocityEngine getEngine() {

		VelocityEngine engine = new VelocityEngine();
		engine.setProperty("resource.loader", "file");
		engine.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		engine.setProperty("file.resource.loader.cache", "false");
		engine.setProperty("file.resource.loader.modificationCheckInterval", "3");
		engine.setProperty("input.encoding", encoding);
		engine.setProperty("output.encoding", encoding);
		return engine;
	}

	/**
	 * 简单邮件发送
	 *
	 * @param config
	 * @Author yujinshui
	 * @createTime 2017年2月27日 下午8:33:15
	 */
	public static void sendTextMail(EmailConfig config) {
		JavaMailSenderImpl senderImpl = getMailSender(config);

		// 建立邮件消息
		SimpleMailMessage mailMessage = getSimpleMailMessage(config);

		// 发送邮件
		senderImpl.send(mailMessage);
	}

	/**
	 * 建立简单邮件消息
	 *
	 * @param config
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年2月27日 下午8:32:44
	 */
	private static SimpleMailMessage getSimpleMailMessage(EmailConfig config) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// 设置收件人，用数组发送多个邮件
		mailMessage.setTo(config.getTo());
		mailMessage.setFrom(config.getFrom());
		mailMessage.setSubject(config.getSubject());
		mailMessage.setText(getContent(config));
		return mailMessage;
	}

	// public static boolean sendEmailWithFile() throws MessagingException {
	// JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();// TODO
	//
	// // 设定mail server
	// senderImpl.setHost("smtp.mxhichina.com");
	// // 建立邮件消息,发送简单邮件和html邮件的区别
	// MimeMessage mailMessage = senderImpl.createMimeMessage();
	// // 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
	// // multipart模式 为true时发送附件 可以设置html格式
	// MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,
	// true, "utf-8");
	//
	// // 设置收件人，寄件人
	// messageHelper.setTo("yujinshui@lxfintech.com");
	// messageHelper.setFrom("notice@lxfintech.com");
	// messageHelper.setSubject("测试邮件中上传附件!！");
	// // true 表示启动HTML格式的邮件
	// messageHelper.setText("<html><head></head><body><h1>你好：附件中有学习资料！</h1></body></html>",
	// true);
	//
	// FileSystemResource file = new FileSystemResource(new
	// File("g:/test.rar"));
	// // 这里的方法调用和插入图片是不同的。
	// messageHelper.addAttachment("test.rar", file);
	//
	// senderImpl.setUsername("username"); // 根据自己的情况,设置username
	// senderImpl.setPassword("password"); // 根据自己的情况, 设置password
	// Properties prop = new Properties();
	// prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
	// prop.put("mail.smtp.timeout", "25000");
	// senderImpl.setJavaMailProperties(prop);
	// // 发送邮件
	// senderImpl.send(mailMessage);
	//
	// System.out.println("邮件发送成功..");
	//
	// return true;
	// }

}
