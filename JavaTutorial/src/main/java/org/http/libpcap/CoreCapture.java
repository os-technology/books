/*
 * Project: pcap4jDemo
 * 
 * File Created at 2018��9��10��
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

import org.pcap4j.core.*;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.packet.DnsPacket;
import org.pcap4j.packet.DnsPacket.DnsHeader;
import org.pcap4j.packet.Packet;

import java.nio.file.Paths;

/**
 * @Type CoreCapture.java
 * @Desc
 * @author bd_liang
 * @date 2018年9月10日 下午4:56:23
 * @version
 */

public class CoreCapture extends Thread {

    /**
     * 抓包保存地址（jdk1.7）
     */
    private static final String DUMP_FILE = Paths.get("capture.pcap").toAbsolutePath().toString();

    /**
     * 抓包长度
     */
    private static final int SNAPLEN = 64 * 1024;
    /**
     * 读取超时设置
     */
    private static final int TIMEOUT = 10 * 1000;
    /**
     * 抓包句柄
     */
    private PcapHandle pcapHandle;

    /**
     * 保存本地 dumper
     */
    private PcapDumper dumper;

    /**
     *在线抓包以及保存至本地
     *
     * @return
     * @throws InterruptedException
     */
    private boolean captureAndDumpLive() throws InterruptedException {
        //
        PcapNetworkInterface nif = PcapNIfManager.getCaptureNetworkInterface("127.0.0.1");
        if (nif == null) {
            return false;
        }

        try {
            // 抓包
            pcapHandle = nif.openLive(SNAPLEN, PromiscuousMode.PROMISCUOUS, TIMEOUT);

            // 打开抓包数据写入文件
            dumper = pcapHandle.dumpOpen(DUMP_FILE);
            // 循环处理 -1 为持续抓包，直至中断退出,可以设定为正整数（抓包个数），
            pcapHandle.loop(-1, new CoreCaptureListener());
            //   也可以采用如下方式，进行循环抓包，
            /*
            while (true) {
                Packet packet = pcapHandle.getNextPacket();
                if (packet == null) {
                    continue;
                } else {
                    if (condition) {
                        break;
                    }
                }
            }*/

        } catch (PcapNativeException e) {
            e.printStackTrace();
            return false;
        } catch (NotOpenException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public void run() {
        try {
            captureAndDumpLive();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
        }
    }

    /**
     * 停止抓包
     */
    public void quit() {

        System.out.println("======================停止抓包================");
        if (pcapHandle != null) {
            if (dumper != null) {
                dumper.close();
            }
            try {
                if (pcapHandle.isOpen()) {
                    pcapHandle.breakLoop();
                }
            } catch (NotOpenException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pcapHandle.close();
        }

    }

    class CoreCaptureListener implements PacketListener {


        @Override
        public void gotPacket(PcapPacket packet) {
            // 解析DNS 数据信息
            if (packet.contains(DnsPacket.class)) {
                DnsHeader dnsHeader = packet.get(DnsPacket.class).getHeader();
                if (dnsHeader.isResponse()) {
                    dnsHeader.getAnswers().get(0).getName();
                } else {
                    dnsHeader.getQuestions();
                    // DNS 记录类型
                    System.out.println(dnsHeader.getQuestions().get(0).getQType());
                }
            }
            try {
                dumper.dump(packet);
            } catch (NotOpenException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

