package org.ftp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: FtpUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/23下午2:57
 */

public class FtpUtil {

    private final static Log logger = LogFactory.getLog(FtpUtil.class);


    /**
     * 获取FTPClient对象
     *
     * @param ftpHost     FTP主机服务器
     * @param ftpUserName 登录用户名
     * @param ftpPassword 登录密码
     * @param ftpPort     FTP端口，默认21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
                                         String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.login(ftpUserName, ftpPassword);
            if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                logger.info("未连接到FTP，用户名或密码错误");
                ftpClient.disconnect();
            } else {
                logger.info("FTP连接成功");
            }
        } catch (SocketException e) {
            logger.error("FTP的IP地址可能错误，请正确配置。", e);
            e.printStackTrace();

        } catch (IOException e) {
            logger.error("FTP的端口错误,请正确配置。", e);
        }

        return ftpClient;
    }


    /**
     * 上传文件
     *
     * @param ftpHost     ftp服务器地址
     * @param ftpUserName anonymous匿名用户登录，不需要密码。administrator指定用户登录
     * @param ftpPassword 指定用户密码
     * @param ftpPort     ftp服务员器端口号
     * @param ftpPath     ftp文件存放物理路径
     * @param fileName    文件路径
     * @param inputStream 文件输入流，即从本地服务器读取文件的IO输入流
     */
    public static void uploadFile(String ftpHost, String ftpUserName,
                                  String ftpPassword, int ftpPort, String ftpPath,
                                  String fileName, InputStream inputStream) {
        FTPClient ftpClient = null;


        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.changeWorkingDirectory(ftpPath);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            fileName = new String(fileName.getBytes("GBK"), "UTF-8");
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            System.out.println("upload success!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void downloadFile(String ftpHost, String ftpUserName,
                                    String ftpPassword, int ftpPort, String ftpPath, String localPath,
                                    String fileName) {
        FTPClient ftpClient = null;

        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);

            File localFile = new File(localPath + File.separatorChar + fileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(fileName, os);
            os.close();
            ftpClient.logout();

        } catch (FileNotFoundException e) {
            logger.error("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            logger.error("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("文件读取错误。");
            e.printStackTrace();
        }
    }

}
