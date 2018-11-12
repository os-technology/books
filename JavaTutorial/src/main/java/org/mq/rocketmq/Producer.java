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

    private static final String addr = "172.30.21.41:9876;172.30.21.42:9876";

    //    private static final String addr = "127.0.0.1:9876";
//    private static final String addr = "172.30.21.43:9876";
    public static void main(String[] args) throws MQClientException, InterruptedException {
        //需要一个producer group名字作为构造方法的参数，这里为testProductGroup
        DefaultMQProducer producer = new DefaultMQProducer("testProductGroup");

        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
        producer.setNamesrvAddr(addr);
        //为避免程序启动的时候报错，添加此代码，可以让rocketMq自动创建topickey
        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
        producer.setInstanceName("Producer");
        producer.start();

        for (int i = 0; i < 1; i++) {
            try {
                for (int m = 0; m < 2000; m++) {
                    Message msg = new Message("mqtest_topic",// topic
                            "mqtest_tag",// tag
//                            "rocketMQ-test-" + m,// key

                            serialize(getDataSender2(m + "")));
                    SendResult sendResult = producer.send(msg);
                    System.out.println(sendResult);
                }


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
