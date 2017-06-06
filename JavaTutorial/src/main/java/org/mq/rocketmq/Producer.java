package org.mq.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Producer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/27下午3:01
 */

public class Producer {

    public static String getDateTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return sdf.format(date);
    }


    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("testProductGroup");

        producer.setNamesrvAddr("172.30.21.43:9876");
//        producer.setNamesrvAddr("127.0.0.1:9876");
//        producer.setNamesrvAddr("localhost:9876");
        producer.setInstanceName("Producer");
        producer.start();

        for (int i = 0; i < 1; i++) {
            try {
//                {
//                    Message msg = new Message("TopicTest1",// topic
//                            "TagA",// tag
//                            "OrderID001",// key
//                            ("Hello MetaQ = "+getDateTime()+" - "+i).getBytes());// body
//                    SendResult sendResult = producer.send(msg);
//                    System.out.println(sendResult);
//                }
                {
                    Message msg = new Message("xdPrdOrderMsgTopic",// topic
                            "xdPrdOrderMsgTag",// tag
                            "rocketMQ-test",// key
                            "{\"bankName\":\"中国工商银行\",\"cusomterName\":\"熊超超\",\"idNo\":\"411528198812230037\",\"idType\":\"00\",\"interestAmt\":50.0,\"investAmt\":100.0,\"lenovoApplyTime\":\"2017-06-02 18:22:00\",\"lenovoOrderNo\":\"176\",\"mobile\":\"15225069737\",\"mobileInBank\":\"15225069737\",\"productItemCode\":\"xiaoxiongtest003\",\"purchaseCardNo\":\"6212260200082268836\"}"
                                    .getBytes());
//                                    serialize("{\"bankName\":\"11\"}"));
//                            ("project JunitTest = "+getDateTime()+" - "+i).getBytes());// body
                    SendResult sendResult = producer.send(msg);
                    System.out.println(sendResult);
                }

//                {
//                    Message msg = new Message("TopicTest2",// topic
//                            "TagB",// tag
//                            "OrderID0034",// key
//                            ("Hello MetaQ-b = "+getDateTime()+" - "+i).getBytes());// body
//                    SendResult sendResult = producer.send(msg);
//                    System.out.println(sendResult);
//                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        producer.shutdown();
    }

    /**
     * 序列化操作
     *
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream bis = null;
        ObjectOutputStream os = null;
        byte[] byteArray = (byte[]) null;
        try {
            bis = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bis);
            os.writeObject(obj);
            os.flush();
            byteArray = bis.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeOutputStream(os, bis);
        }
        return byteArray;
    }

    private static void closeOutputStream(ObjectOutputStream os,
                                          ByteArrayOutputStream bis) throws IOException {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
