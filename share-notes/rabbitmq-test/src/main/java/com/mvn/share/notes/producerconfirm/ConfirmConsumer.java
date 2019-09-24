package com.mvn.share.notes.producerconfirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者——发送方确认模式
 *
 * @author code
 * @Title: ConfirmConsumer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/239:49 PM
 */
public class ConfirmConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        String queueName = ConfirmAsyncProducer.EXCHANGE_NAME;
        Channel channel = RabbitFactory.getRabbitConnection(ConfirmAsyncProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        channel.queueDeclare(queueName, false, false, false, null);

        channel.queueBind(queueName,
                ConfirmAsyncProducer.EXCHANGE_NAME,
                ConfirmAsyncProducer.ROUTE_KEY);

        System.out.println("[consumer] wait for msg ...");

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("consumer[" + queueName + "]:" + msg);
                //手动消息确认. 从id为0 的数据开始
                channel.basicAck(0,true);
            }
        };
        //true，自动确认，false，手动确认
        channel.basicConsume(queueName, true, defaultConsumer);

    }
}
