package org.mq.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.mq.rocketmq.beans.OrderDataSender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Producer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/27下午3:01
 */

public class QueueProducer {


    public static String getDateTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return sdf.format(date);
    }


    public static void main(String[] args) throws MQClientException, InterruptedException {
        //需要一个producer group名字作为构造方法的参数，这里为testProductGroup
        DefaultMQProducer producer = new DefaultMQProducer(MQConfig.group);

        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
        producer.setNamesrvAddr(MQConfig.host);
        //为避免程序启动的时候报错，添加此代码，可以让rocketMq自动创建topickey
        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
        producer.setInstanceName(UUID.randomUUID().toString());
        producer.start();

        try {
//            byte[] message = serialize(getDataSender2(""));

            for (int i = 0; i < 10000; i++) {
                byte[] message = serialize("信息发送：" + i);
                SendResult result = sendMsg(producer, message);
                System.out.println("发送次数：" + i + " - " + result.getSendStatus());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        TimeUnit.MILLISECONDS.sleep(1000);

        producer.shutdown();
    }

    private static SendResult sendMsg(DefaultMQProducer producer, byte[] message) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        Message msg = new Message(MQConfig.topic, MQConfig.tag, message);

        /**
         * msg：     消息内容
         * selector：MessageQueueSelector匿名类
         * arg：     代表队列的下标信息
         * 通过  public SendResult send(Message msg, MessageQueueSelector selector, Object arg)来指定发送消息到哪个队列
         */
        return producer.send(msg, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> list, Message msg, Object arg) {
                Integer id = (Integer) arg;
                return list.get(id);

            }
        }, 1);//1L：代表队列的下标。

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
