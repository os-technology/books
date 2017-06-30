package org.mq.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.io.*;
import java.util.List;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Consumer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/27下午3:05
 */

public class Consumer {

private static final String addr = "172.30.21.42:6380";
//private static final String addr = "172.30.21.43:9876";
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
                "ConsumerGroupName");
        consumer.setNamesrvAddr(addr);
//        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setInstanceName("Consumber");

        /**
         * 订阅指定topic下tags分别等于TagA或TagC或TagD
         */
        consumer.subscribe("xdPrdOrderMsgTopic", "xdPrdOrderMsgTag");
        consumer.subscribe("TopicTest1", "TagA || TagC || TagD");
        /**
         * 订阅指定topic下所有消息<br>
         * 注意：一个consumer对象可以订阅多个topic
         */
        consumer.subscribe("TopicTest2", "*");
        consumer.subscribe("TopicTest3", "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {

            /**
             * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
             */
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(Thread.currentThread().getName()
                        + " Receive New Messages: " + msgs.size());

                MessageExt msg = msgs.get(0);
                if (msg.getTopic().equals("TopicTest1")) {
                    // 执行TopicTest1的消费逻辑
                    if (msg.getTags() != null && msg.getTags().equals("TagA")) {
                        // 执行TagA的消费
                        System.out.println(new String(msg.getBody()));
                    } else if (msg.getTags() != null
                            && msg.getTags().equals("TagC")) {
                        // 执行TagC的消费
                    } else if (msg.getTags() != null
                            && msg.getTags().equals("TagD")) {
                        // 执行TagD的消费
                    }
                } else if (msg.getTopic().equals("TopicTest2")) {
                    System.out.println(new String(msg.getBody()));
                } else if (msg.getTopic().equals("xdPrdOrderMsgTopic")) {
//                    System.out.println(new String(msg.getBody()));
                    try {
                        Object obj = deSerialize(msg.getBody());
                        System.out.println(new String((byte[]) obj));
//                        System.out.println(new String(((byte[])deSerialize(msg.getBody()))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        /**
         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         */
        consumer.start();

        System.out.println("Consumer Started.");
    }


    public static byte[] getByte(Object list) {
        byte[] bt=null;
        ByteArrayOutputStream baos=new ByteArrayOutputStream();

        try{
            if(list!=null)
            {
                ObjectOutputStream  objos=new ObjectOutputStream(baos);
                objos.writeObject(list);
                bt=baos.toByteArray();
            }
        }catch(Exception e)
        {
            bt=(byte[])null;
            e.printStackTrace();

        }
        return bt;
    }


    /**
     * 反序列化
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
