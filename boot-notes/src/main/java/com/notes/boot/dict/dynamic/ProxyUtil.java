package com.notes.boot.dict.dynamic;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author code
 * @Title: ProxyUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/57:43 PM
 */
public class ProxyUtil {

    public static void generateClassFile(Class clazz, String proxyName) {
        byte[] classFile = ProxyGenerator.generateProxyClass(
                proxyName, new Class[]{clazz});

        String paths = clazz.getResource(".").getPath();
        System.out.println(paths);
        FileOutputStream out = null;
        try {
            //将class文件保存至硬盘
            out = new FileOutputStream(paths + proxyName + ".class");
            out.write(classFile);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
