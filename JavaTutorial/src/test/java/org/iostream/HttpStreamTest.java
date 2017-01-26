package org.iostream;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yujinshui on 2017/1/12.
 */
public class HttpStreamTest {
    public static void downloadNet() throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL("http://www.paymax.cc/api/v1/statement/download?startTime=1483977600000&endTime=1484305398497&channelCategory=VAS&statementType=CERTIFICATION&Authorization=OAuth 6d30f3c50083dddf345e07e967e16ed2f40ddf8d0510ea85bc4d38b6d2864fe5");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("/Users/yujinshui/Desktop/1.csv");

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            downloadNet();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }



}
