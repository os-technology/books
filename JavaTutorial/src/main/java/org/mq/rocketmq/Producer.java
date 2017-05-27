package org.mq.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

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

    public static String getDateTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return sdf.format(date);
    }


    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("testProductGroup");

        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("Producer");

        producer.start();

        for (int i = 0; i < 1000; i++) {
            try {
                {
                    Message msg = new Message("TopicTest1",// topic
                            "TagA",// tag
                            "OrderID001",// key
                            ("Hello MetaQ = "+getDateTime()+" - "+i).getBytes());// body
                    SendResult sendResult = producer.send(msg);
                    System.out.println(sendResult);
                }

                {
                    Message msg = new Message("TopicTest2",// topic
                            "TagB",// tag
                            "OrderID0034",// key
                            ("Hello MetaQ-b = "+getDateTime()+" - "+i).getBytes());// body
                    SendResult sendResult = producer.send(msg);
                    System.out.println(sendResult);
                }

                {
                    Message msg = new Message("TopicTest3",// topic
                            "TagC",// tag
                            "OrderID061",// key
                            ("Hello MetaQ - "+i).getBytes());// body
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
}
