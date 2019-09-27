package com.mvn.share.notes.rejectmsg;

import com.mvn.share.notes.producerconfirm.RabbitFactory;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author code
 * @Title: RejectRequeueConsumer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/273:03 PM
 */
public class RejectRequeueConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitFactory.getRabbitConnection(RejectProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = "reject";
        channel.queueDeclare(queueName, false, false, false, null);

        String routeKey = "error";
        //绑定，将队列和交换器通过路由键进行绑定
        channel.queueBind(queueName, RejectProducer.EXCHANGE_NAME, routeKey);


        System.out.println("waiting for message........");

        //声明一个消费者
        final Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                try {
                    String msg = new String(body);

                    System.out.println("Received msg [" + envelope.getRoutingKey() + "] "
                            + msg);

                    throw new RuntimeException("投递失败");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    channel.basicReject(envelope.getDeliveryTag(), true);
                }

            }
        };

        channel.basicConsume(queueName, false, consumer);

    }
}
