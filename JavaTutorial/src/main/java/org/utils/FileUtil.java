package org.utils;


import org.logs.slf4j.LogPortal;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author code
 * @Title: FileUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/16下午5:20
 */
public class FileUtil {

    /**
     * 把文件流写入本地
     *
     * @param fileData
     * @param fileName
     */
    public static void write2Local(byte[] fileData, String path, String fileName) {
        InputStream in = new ByteArrayInputStream(fileData);
        File file = new File(path + fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        FileOutputStream fileout = null;
        try {
            fileout = new FileOutputStream(file);
            /**
             * 根据实际运行效果 设置缓冲区大小
             */
            byte[] buffer = new byte[1024];
            int ch = 0;
            while ((ch = in.read(buffer)) != -1) {
                fileout.write(buffer, 0, ch);
            }
            fileout.flush();
        } catch (Exception e) {
            LogPortal.error("获取文件时发生异常!错误信息是:{}",
                    e, e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (fileout != null) {
                    fileout.close();
                }
            } catch (IOException e) {
                LogPortal.error("关闭数据流时发生异常!错误信息是:{}",
                        e, e.getMessage());
            }

        }
        LogPortal.info("文件流写入成功。文件路径名是:[{}]", path + fileName);
    }


    /**
     * 保存至服务器数据
     *
     * @param data
     * @param pathName 文件名称，包含路径
     */
    public static void save2Local(String data, String pathName) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        File dir = new File(pathName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Path localFilePath = Paths.get(pathName);
        File localFile = localFilePath.toFile();
        if (localFile.exists()) {
            localFile.delete();
        }
        FileChannel fileChannel = null;
        fileChannel = FileChannel.open(localFilePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);
        fileChannel.transferFrom(Channels.newChannel(inputStream), 0, Long.MAX_VALUE);
        //关闭文件操作
        fileChannel.close();
        LogPortal.info("对账单数据文件流写入成功，路径：" + pathName);
    }


}
