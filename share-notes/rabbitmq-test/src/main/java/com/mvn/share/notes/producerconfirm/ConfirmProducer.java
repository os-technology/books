package com.mvn.share.notes.producerconfirm;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author code
 * @Title: RabbitmqClient
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/1611:19 PM
 */
public class ConfirmProducer {

    public static final String EXCHANGE_NAME = "ConfirmProducer";
    public static final String ROUTE_KEY = "shui";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitFactory.getRabbitConnection(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //开启发送者确认模式
        channel.confirmSelect();

        for (int i = 0; i < 2; i++) {
            String msg = "producer_confirm_" + i;
            channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, true, null, msg.getBytes());
            System.out.println("Send msg:[" + ROUTE_KEY + "]:" + msg);
            if (channel.waitForConfirms()) {
                System.out.println("Send success");
            } else {
                System.out.println("Send failure");
            }
        }

        RabbitFactory.close();
    }
}
