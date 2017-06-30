package org.mq.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import org.mq.rocketmq.beans.OrderDataSender;

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

    private static final String addr = "172.30.21.42:6380";
//    private static final String addr = "172.30.21.43:9876";
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("testProductGroup");

        producer.setNamesrvAddr(addr);
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
                    String value = "{\"lenovoOrderNo\":\"165\",\"bankName\":\"中国工商银行\",\"customerName\":\"熊超超\",\"idNo\":\"411528198812230037\",\"idType\":\"00\",\"interestAmt\":50.0,\"investAmt\":100.0,\"lenovoApplyTime\":\"2017-06-02 18:22:00\",\"mobile\":\"15225069737\",\"mobileInBank\":\"15225069737\",\"productItemCode\":\"xiaoxiongtest003\",\"purchaseCardNo\":\"6212260200082268836\"}";
                    Message msg = new Message("xdPrdOrderMsgTopic",// topic
                            "xdPrdOrderMsgTag",// tag
                            "rocketMQ-test",// key

                            serialize(getDataSender2("403"+i)));
//                                    serialize(value));
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

    private static String getDataSender(String num) {
        OrderDataSender orderDataSender = new OrderDataSender();
        orderDataSender.setProductItemCode("3234d95349ef43b9807f923fa85b251f");
        orderDataSender.setLenovoUserId(Integer.valueOf("1156789322"));//
//        orderDataSender.setLenovoUserId(Integer.valueOf("41"));//
        orderDataSender.setLenovoOrderNo(String.valueOf(num));//
        orderDataSender.setLenovoApplyTime(new Date());
        orderDataSender.setPurchaseCardNo("6227710702521923");
        orderDataSender.setInvestAmt(100.0);
        orderDataSender.setMobileInBank("13011138024");
        orderDataSender.setMobile("13011138024");
        orderDataSender.setIdType("00");
        orderDataSender.setIdNo("371083198809135033");
        orderDataSender.setCustomerName("于津水");
        orderDataSender.setBankName("中信银行");
        orderDataSender.setInterestAmt(50.0);
        return orderDataSender.toJSONString();
    }
    private static String getDataSender1(String num) {
        OrderDataSender orderDataSender = new OrderDataSender();
        orderDataSender.setProductItemCode("3234d95349ef43b9807f923fa85b251f");
//        orderDataSender.setLenovoUserId(Integer.valueOf("1156789322"));//
        orderDataSender.setLenovoUserId(Integer.valueOf("21"));//
        orderDataSender.setLenovoOrderNo(String.valueOf(num));//
        orderDataSender.setLenovoApplyTime(new Date());
        orderDataSender.setPurchaseCardNo("6212260200082268836");
        orderDataSender.setInvestAmt(200.0);
        orderDataSender.setMobileInBank("15225069737");
        orderDataSender.setMobile("15225069737");
        orderDataSender.setIdType("00");
        orderDataSender.setIdNo("411528198812230037");
        orderDataSender.setCustomerName("熊超超");
        orderDataSender.setBankName("中国工商银行");
        orderDataSender.setInterestAmt(50.0);
        return orderDataSender.toJSONString();
    }

    private static String getDataSender2(String num) {
        OrderDataSender orderDataSender = new OrderDataSender();
        orderDataSender.setProductItemCode("3234d95349ef43b9807f923fa85b251f");
//        orderDataSender.setLenovoUserId(Integer.valueOf("1156789322"));//
        orderDataSender.setLenovoUserId(Integer.valueOf("20"));//
        orderDataSender.setLenovoOrderNo(String.valueOf(num));//
        orderDataSender.setLenovoApplyTime(new Date());
        orderDataSender.setPurchaseCardNo("6227000011170644504");
        orderDataSender.setInvestAmt(100.0);
        orderDataSender.setMobileInBank("13436824634");
        orderDataSender.setMobile("13436824634");
        orderDataSender.setIdType("00");
        orderDataSender.setIdNo("130621198811182718");
        orderDataSender.setCustomerName("丁龙");
        orderDataSender.setBankName("中国建设银行");
        orderDataSender.setInterestAmt(50.0);
        return orderDataSender.toJSONString();
    }

}
