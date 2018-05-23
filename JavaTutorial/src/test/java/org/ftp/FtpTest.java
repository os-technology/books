package org.ftp;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: FtpTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/23下午3:59
 */

public class FtpTest {

    String ftpHost = "test-ftp.paymax.cc"; //ftp服务器地址
    int ftpPort = 21;//ftp服务员器端口号
    String ftpUserName = "hxb";//anonymous匿名用户登录，不需要密码。administrator指定用户登录
    String ftpPassword = "hxb@2018test";//指定用户密码
    String ftpPath = "/"; //ftp文件存放物理路径
    String filePath = "/"; //文件路径
    String fileName = "";//文件名称


    @Test
    public void test() throws Exception {
        filePath = "/Users/yujinshui/Desktop/待转存";
        fileName = "11.txt";
        FtpUtil.downloadFile(ftpHost, ftpUserName, ftpPassword, ftpPort,
                ftpPath, filePath, fileName);

//        filePath = "E:/upload";
//        fileName = "upload.txt";
//        FileInputStream input = new FileInputStream(new File(filePath + File.separatorChar + fileName));
//        FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName, input);
    }

}
