package org.mq.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Consumer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/27下午3:05
 */

public class QueueConsumer {

    /**
     * 当前例子是PushConsumer用法，使用方式给用户感觉是消息从RocketMQ服务器推到了应用客户端。<br>
     * 但是实际PushConsumer内部是使用长轮询Pull方式从MetaQ服务器拉消息，然后再回调用户Listener方法<br>
     */
    public static void main(String[] args) throws InterruptedException,
            MQClientException {
        /**
         * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br>
         * 注意：ConsumerGroupName需要由应用来保证唯一
         */
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                MQConfig.group);
        consumer.setNamesrvAddr(MQConfig.host);
        consumer.setInstanceName(UUID.randomUUID().toString());

        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);


        /**
         * 订阅指定topic下tags分别等于TagA或TagC或TagD
         */
//        consumer.subscribe("mqtest_topic", "mqtest_tag || TagC || TagD");
        consumer.subscribe(MQConfig.topic, MQConfig.tag);
        /**
         * 订阅指定topic下所有消息<br>
         * 注意：一个consumer对象可以订阅多个topic
         */
//        consumer.subscribe("TopicTest2", "*");
//        consumer.subscribe("TopicTest3", "*");
//        MessageListenerOrderly能够保证顺序消费，从图中我们也看到了期望的结果。图中的输出是只启动了一个消费者时的输出，看起来订单号还是混在一起，
//        但是每组订单号之间是有序的。因为消息发送时被分配到了三个队列（参见前面生产者输出日志），那么这三个队列的消息被这唯一消费者消费。

        consumer.registerMessageListener(new MessageListenerOrderly() {


            /**
             * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
             */
            @Override
            public ConsumeOrderlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeOrderlyContext context) {
//                System.out.println(Thread.currentThread().getName()
//                        + " Receive New Messages: " + msgs.toString());

//                MessageExt msg = msgs.get(0);

                for (MessageExt msg : msgs) {


                    if (msg.getTopic().equals(MQConfig.topic)) {
                        String obj = new String(msg.getBody());
                        System.out.println("输出结果：" + JSON.toJSONString(obj));
//                        try {
////                            Object obj = deSerialize(msg.getBody());
//
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        } catch (ClassNotFoundException e) {
//                            e.printStackTrace();
//                        }
                    }
                }

                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        /**
         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         */
        consumer.start();

        System.out.println("Consumer Started.");
    }


    public static byte[] getByte(Object list) {
        byte[] bt = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            if (list != null) {
                ObjectOutputStream objos = new ObjectOutputStream(baos);
                objos.writeObject(list);
                bt = baos.toByteArray();
            }
        } catch (Exception e) {
            bt = (byte[]) null;
            e.printStackTrace();

        }
        return bt;
    }


    /**
     * 反序列化
     *
     * @param byteArray
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deSerialize(byte[] byteArray) throws IOException,
            ClassNotFoundException {
        ByteArrayInputStream bos = null;
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            bos = new ByteArrayInputStream(byteArray);
            ois = new ObjectInputStream(bos);
            obj = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e) {

            throw e;
        } finally {
            closeInputStream(bos, ois);
        }
        return obj;
    }


    private static void closeInputStream(ByteArrayInputStream bos,
                                         ObjectInputStream ois) throws IOException {
        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                throw e;
            }
        }
        if (ois != null) {
            try {
                ois.close();
            } catch (IOException e) {
                throw e;
            }
        }
    }


}
