/*
 * Project: pcap4jDemo
 * 
 * File Created at 2018��9��10��
 * 
 * Copyright 2016  bd_liang.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package org.http.libpcap;

import org.pcap4j.core.PcapAddress;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;

import java.util.List;

/**
 * @Type PcapNIfManager.java
 * @Desc 
 * @author bd_liang
 * @date 2018��9��10�� ����4:44:06
 * @version 
 */

public class PcapNIfManager {
    /**
     * 根据IP获取指定网卡设备
     * @param localHost 网卡IP
     *
     * @return 指定的设备对象
     */
    public static PcapNetworkInterface getCaptureNetworkInterface(String localHost) {
        List<PcapNetworkInterface> allDevs;
        try {
            // 获取全部的网卡设备列表
            allDevs = Pcaps.findAllDevs();

            for (PcapNetworkInterface networkInterface : allDevs) {
                List<PcapAddress> addresses = networkInterface.getAddresses();
                for (PcapAddress pcapAddress : addresses) {
                    // 获取网卡IP地址
                    String ip = pcapAddress.getAddress().getHostAddress();
                    if (ip != null && ip.contains(localHost)) {
                        // 返回指定的设备对象
                        return networkInterface;
                    }

                }
            }
        } catch (PcapNativeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018��9��10�� bd_liang create
 */
