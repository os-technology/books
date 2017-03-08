package org.chapter.databasic.mail;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * java mail 邮箱发送类
 * 
 * @author zpf
 * 
 */
public class MailTool {

	/**
	 * ��
	 */
	public static final int EMERGENCY = 1;
	/**
	 * ��ͨ
	 */
	public static final int CUSTOM = 3;
	/**
	 * ����
	 */
	public static final int SLOWLY = 5;

	private MailTool() {
		super();
		//
	}

	/**
	 * 
	 * 内容最全的一个
	 * 
	 * @param from
	 * @param to
	 * @param user
	 * @param password
	 * @param subject
	 * @param content
	 * @param filePath
	 *            多个附件上传
	 * @param newName
	 * @param smtpHost
	 * @param classProper
	 * @param useValidate
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2014年12月24日 下午8:35:40
	 */
	public static boolean sendEmail(String from, String[] to, String user, String password, String subject,
			String content, String filePath[], String newName[], String smtpHost, int classProper,
			boolean useValidate) {
		return MailTool.createSendInfo(from, to, user, password, subject, content, filePath, newName, smtpHost,
				classProper, useValidate);
	}

	public static boolean sendEmail(String from, String[] to, String user, String password, String subject,
			String content, String filePath, String newName, String smtpHost, int classProper, boolean useValidate) {
		String pathArray[] = new String[1];
		pathArray[0] = filePath;
		String newNameArray[] = new String[1];
		newNameArray[0] = newName;
		if (filePath == null) {
			return MailTool.createSendInfo(from, to, user, password, subject, content, null, newNameArray, smtpHost,
					classProper, useValidate);
		}
		return MailTool.createSendInfo(from, to, user, password, subject, content, pathArray, newNameArray, smtpHost,
				classProper, useValidate);
	}

	public static boolean sendEmail(String from, String[] to, String user, String password, String subject,
			String content, String smtpHost, int classProper, boolean useValidate) {
		// System.out.println("222222+subject:" + subject);
		return MailTool.createSendInfo(from, to, user, password, subject, content, null, null, smtpHost, classProper,
				useValidate);
	}

	/**
	 * 
	 * 包含附件的邮件发送
	 * 
	 * @param from
	 *            原始邮箱
	 * @param to
	 *            目标邮箱
	 * @param user
	 *            用户名
	 * @param password
	 *            密码
	 * @param subject
	 *            主题
	 * @param content
	 *            内容
	 * @param filePath
	 *            附件路径
	 * @param smtpHost
	 *            原始邮箱smtp名称
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2014年12月24日 下午8:28:46
	 */
	public static boolean sendEmail(String from, String[] to, String user, String password, String subject,
			String content, String[] filePath, String smtpHost) {
		return MailTool.sendEmail(from, to, user, password, subject, content, filePath, smtpHost, MailTool.CUSTOM,
				true);
	}

	/**
	 * 
	 * 多附件上传1
	 * 
	 * @param from
	 *            原始邮箱
	 * @param to
	 *            目标邮箱
	 * @param user
	 *            用户名
	 * @param password
	 *            密码
	 * @param subject
	 *            主题
	 * @param content
	 *            内容
	 * @param filePath
	 *            多个附件上传【附件路径】
	 * @param smtpHost
	 *            原始邮箱smtp名称
	 * @param classProper
	 * @param useValidate
	 *            是否进行邮箱验证
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2014年12月24日 下午8:31:39
	 */
	public static boolean sendEmail(String from, String[] to, String user, String password, String subject,
			String content, String filePath[], String smtpHost, int classProper, boolean useValidate) {
		return MailTool.createSendInfo(from, to, user, password, subject, content, filePath, null, smtpHost,
				classProper, useValidate);
	}

	/**
	 * 
	 * {方法功能描述}
	 * 
	 * @return_type boolean {@param:传递参数,需注明参数用途}
	 * @param from
	 * @param to
	 * @param user
	 * @param password
	 * @param subject
	 * @param content
	 * @param smtpHost
	 * @param classProper
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2014年12月24日 下午8:32:08
	 * @since 0.3.0.0 {初始版本号}
	 */
	public static boolean sendEmail(String from, String[] to, String user, String password, String subject,
			String content, String smtpHost, int classProper) {
		return MailTool.createSendInfo(from, to, user, password, subject, content, null, null, smtpHost, classProper,
				true);
	}

	/**
	 * 
	 * 单个附件上传
	 * 
	 * @param from
	 *            原始邮箱
	 * 
	 * @param to
	 *            目标邮箱
	 * @param user
	 *            用户名
	 * @param password
	 *            密码
	 * @param subject
	 *            主题
	 * @param content
	 *            内容
	 * @param filePath
	 *            单个附件上传【附件路径】
	 * @param newName
	 *            附件文件名[应与filepath文件扩展名一致，否则上传后无法正常打开]
	 * @param smtpHost
	 *            原始邮箱smtp名称
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2014年12月24日 下午8:32:19
	 */
	public static boolean sendEmail(String from, String[] to, String user, String password, String subject,
			String content, String filePath, String newName, String smtpHost) {
		return sendEmail(from, to, user, password, subject, content, filePath, newName, smtpHost, MailTool.CUSTOM,
				true);
	}

	private static boolean checkInput(String from, String[] to, String user, String password, String subject,
			String smtpHost, boolean useValidate) {
		if (from == null || from.trim().equals(""))
			return false;
		if (to == null)
			return false;
		if (useValidate) {
			if (user == null || user.trim().equals(""))
				return false;
			if (password == null || password.trim().equals(""))
				return false;
		}
		if (subject == null || subject.trim().equals(""))
			return false;
		if (smtpHost == null || smtpHost.trim().equals(""))
			return false;
		return true;
	}

	private static boolean createSendInfo(String from, String[] to, String user, String password, String subject,
			String content, String filePath[], String newName[], String smtpHost, int classProper,
			boolean useValidate) {
		if (!checkInput(from, to, user, password, subject, smtpHost, useValidate))
			return false;

		if (smtpHost == null) {
			String errMsg = "stmp未填写";
			throw new RuntimeException(errMsg);
		}

		String senderAddress = from;

		System.out.println(senderAddress);
		System.out.println(smtpHost);

		// /////////////////////////////////////////////////////

		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.auth", String.valueOf(useValidate));
		props.put("mail.debug", "true");

		Session mailSession = null;
		if (useValidate) {
			SmtpAuth auth = new SmtpAuth();
			auth.setAccount(user, password);
			mailSession = Session.getInstance(props, auth);
		} else {
			mailSession = Session.getInstance(props, null);
		}

		Message message = new MimeMessage(mailSession);
		try {
			message.setFrom(new InternetAddress(from));
			int toLenth = to.length;
			InternetAddress toAddressArray[] = new InternetAddress[toLenth];
			for (int i = 0; i < toLenth; i++)
				toAddressArray[i] = new InternetAddress(to[i]);
			message.addRecipients(Message.RecipientType.TO, toAddressArray);

			message.setSubject(subject);
			Multipart multipart = new MimeMultipart(); // ��4��װ��ϸ�����ݡ�
			multipart.addBodyPart(MailTool.getContentObject(content));// ��ͨ������
			if (filePath != null) {
				String newNames[] = getNewNames(filePath, newName);
				int argLenth = filePath.length;
				int nameLenth = newNames.length;
				if (argLenth <= nameLenth) {
					for (int i = 0; i < argLenth; i++) {
						if (filePath[i].indexOf("http") >= 0) // ��Զ���ļ�
						{
							multipart.addBodyPart(MailTool.getRemotAddtionalObject(filePath[i], newNames[i]));
						} else // �Ǳ����ļ�
						{
							multipart.addBodyPart(MailTool.getLocalAddtionalObject(filePath[i], newNames[i]));
						}
					}
				} else
					return false;
			}
			message.setContent(multipart);
			message.setSentDate(new Date());
			message.setHeader("X-Priority", classProper + "");

			message.saveChanges();

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(smtpHost, user, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			// Transport.send(message, message.getAllRecipients());

			return true;

		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String[] getNewNames(String filePath[], String newName[]) {
		if (filePath == null)
			return null;
		else {
			if (newName == null) {
				ArrayList<String> fileName = new ArrayList<String>();
				int len = filePath.length;
				for (int i = 0; i < len; i++) {
					if (filePath[i].indexOf("http") >= 0) // ��Զ���ļ�
						fileName.add(filePath[i].substring(filePath[i].lastIndexOf("/") + 1));
					else
						// �Ǳ����ļ�
						fileName.add(filePath[i].substring(filePath[i].lastIndexOf("\\") + 1));

				}
				String returnArray[] = new String[fileName.size()];
				return fileName.toArray(returnArray);
			} else {
				ArrayList<String> fileName = new ArrayList<String>();
				int len = filePath.length;
				int nameLen = newName.length;
				String temp = null;
				for (int i = 0; i < len; i++) {
					if (i == nameLen) {
						if (filePath[i].indexOf("http") >= 0) // ��Զ���ļ�
							fileName.add(filePath[i].substring(filePath[i].lastIndexOf("/") + 1));
						else
							// �Ǳ����ļ�
							fileName.add(filePath[i].substring(filePath[i].lastIndexOf("\\") + 1));
					} else {
						temp = newName[i];
						if (temp == null || temp.trim().equals("")) {
							if (filePath[i].indexOf("http") >= 0) // ��Զ���ļ�
								fileName.add(filePath[i].substring(filePath[i].lastIndexOf("/") + 1));
							else
								// �Ǳ����ļ�
								fileName.add(filePath[i].substring(filePath[i].lastIndexOf("\\") + 1));
						} else
							fileName.add(newName[i]);
					}

				}
				String returnArray[] = new String[fileName.size()];
				System.out.println("finale:" + fileName);
				return fileName.toArray(returnArray);
			}
		}
	}

	/**
	 * ����Զ�̵��ļ�����һ���
	 * 
	 * @param remotAddtionalObjectUrl
	 *            ��ʾԶ���ļ���һ��url
	 *            �磺http://localhost:8080/jspstudy/email/xx.gif
	 * @param newName
	 *            �ļ�����ʾ���֣����Ժ�ԭ4�����ֲ�ͬ��Ĭ��Ϊ�ļ���ԭ��
	 * @return
	 */
	private static MimeBodyPart getRemotAddtionalObject(String remotAddtionalObjectUrl, String newName) {
		MimeBodyPart mdp = new MimeBodyPart();
		URLDataSource ur = null;
		try {
			ur = new URLDataSource(new URL(remotAddtionalObjectUrl));
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		// ע:�����õĲ���ֻ��ΪURL����,����ΪURL�ִ�,
		DataHandler dataHandle = new DataHandler(ur);
		try {
			mdp.setFileName(MimeUtility.encodeText(newName, "GBK", "B"));
		} catch (MessagingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		try {
			mdp.setDataHandler(dataHandle);
		} catch (MessagingException e) {

			e.printStackTrace();
		}
		return mdp;

	}

	/**
	 * ��ͨ�ı�
	 * 
	 * @param tcontent
	 * @return
	 */
	private static BodyPart getContentObject(String tcontent) {
		// �����ż��ı�����
		BodyPart mbp = new MimeBodyPart();// �½�һ�����ż����ݵ�BodyPart����
		try {
			mbp.setContent("<meta http-equiv=Content-Type content=text/html;charset=gb2312>" + tcontent,
					"text/html;charset=GB2312");
		} catch (MessagingException e) {

			e.printStackTrace();
		} // ��BodyPart�����������ݺ͸�ʽ/���뷽ʽ

		return mbp;

	}

	/**
	 * ��ͨ�ı���Ϊ��Ϊ����
	 * 
	 * @param content
	 * @param newName
	 * @return
	 */
	private static MimeBodyPart getLocalAddtionalObjectUseContent(String content, String newName) {
		MimeBodyPart mdp = new MimeBodyPart();
		DataHandler ur = null;
		ur = new DataHandler(content, "text/plain;charset=gb2312");
		try {
			mdp.setFileName(MimeUtility.encodeText(newName, "GBK", "B"));
		} catch (MessagingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		try {
			mdp.setDataHandler(ur);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return mdp;

	}

	/**
	 * �����ļ���Ϊ���� �������������US-ASCII�ַ�,
	 * �����ڷ������ı���ĸ���ʱ��Ҫ�����US-ASCII�ַ�, ��}�ֱ��뷽ʽ: B (BASE64), Q
	 * (Quoted-Printable), ��Щ������MimeUtility�ﶼ�Ѿ����˷�װ, �����ڷ��͸���ʱʹ�÷���:
	 * setFileName(MimeUtility.encodeText(fileName, "GBK"));
	 * ���������ʼ�ϵͳ�Դ˴�ʵ�ֵĲ��Ǻ�һ��, ���Կ����и���ʼ�ϵͳ�յ���������,
	 * �ɸ������Լ�ѡ����Ӧ�ı��뷽ʽ. ����ǰ����ֱ��ȡISO8859-1���ֽ�:setFileName(new
	 * String(file.getName().getBytes(), "ISO8859-1"));
	 * 
	 * @param LocalAddtionalObjectUrl
	 * @param newName
	 * @return
	 */
	private static MimeBodyPart getLocalAddtionalObject(String LocalAddtionalObjectUrl, String newName) {
		MimeBodyPart mdp = new MimeBodyPart();
		FileDataSource ur = null;
		ur = new FileDataSource(LocalAddtionalObjectUrl);
		// ע:�����õĲ���ֻ��ΪURL����,����ΪURL�ִ�.
		DataHandler dataHandle = new DataHandler(ur);
		try {
			mdp.setFileName(MimeUtility.encodeText(newName, "GBK", "B"));
		} catch (MessagingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		try {
			mdp.setDataHandler(dataHandle);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return mdp;

	}

	private static class SmtpAuth extends Authenticator {

		private String user;// .;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;E:\workspace\jmail\src\javaMail\mail.jar;E:\workspace\jmail\src\javaMail\activation.jar

		private String password;

		public SmtpAuth() {
			super();
			//
		}

		public void setAccount(String user, String password) {
			//
			this.user = user;
			this.password = password;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user, password);
		}

	}

	private static String setContent(){
		StringBuilder builder = new StringBuilder();
		builder.append("<table BORDER=1>")//
		.append("<tr>")//
		.append("<th>hello</th><th>world</th>")//
		.append("</tr>")//
		.append("<tr>")//
		.append("<td>邮件发送</td><td>测试HTML格式</td>")//
		.append("</tr>")//
		.append("</table>");
		System.out.println(builder);
		return builder.toString();
	}
	
	public static void main(String[] args) {
		String from = "sc_yujinshui@126.com";
		String[] to = { "602570224@qq.com" };
		String user = "sc_yujinshui";
		String password = "SHUIJIAYOU";
		String subject = "邮箱发送测试";
		String content = setContent();

		// String newNames[] = { "remoteJIF" };
		// String smtpHost = "SMTP.126.com";
		String smtpHost = "smtp.126.com";
		boolean res = MailTool.sendEmail(from, to, user, password, subject, content, null, smtpHost);
		// boolean res = sendEmail(from, to, user, password, subject, content,
		// smtpHost);

		// boolean res = sendEmail(from, to, user, password, subject, content,
		// null, MailTool.CUSTOM, true);
		// String newName = "lulu.jpg";
		// boolean res = MailTool.sendEmail(from, to, user, password, subject,
		// content, filePath, newName , smtpHost);
		System.out.print("ok    " + res);
	}
}
