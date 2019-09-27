/*
 * Project: pcap4jDemo
 * 
 * File Created at 2018年9月10日
 * 
 * Copyright 2016 bd_liang
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package org.http.libpcap;

/**
 * @Type App.java
 * @Desc 
 * @author bd_liang
 * @date 2018年9月10日 下午5:38:31
 * @version 
 */
/**
 * @author bd_liang
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CoreCapture coreCapture = new CoreCapture();
        coreCapture.start();
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        coreCapture.quit();
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018年9月10日 bd_liang creat
 */
