package org.mq.rocketmq;

/**
 * @author code
 * @Title: MQConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/11/14上午11:15
 */
public class MQConfig {
    private MQConfig() {

    }

//    public static final String host = "172.30.21.41:9876;172.30.21.42:9876";
//    public static final String host = "10.37.251.224:9876";
public static final String host = "127.0.0.1:9876";
//    public static final String host = "172.30.21.43:9876";

    public static final String group = "demo_group";
    public static final String topic = "demo_topic";
    public static final String tag = "demo_tag";
}
