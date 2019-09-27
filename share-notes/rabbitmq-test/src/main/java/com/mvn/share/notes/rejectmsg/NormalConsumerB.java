package com.mvn.share.notes.rejectmsg;

import com.mvn.share.notes.producerconfirm.RabbitFactory;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author code
 * @Title: NormalConsumerA
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/272:20 PM
 */
public class NormalConsumerB {

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
                String msg = new String(body);

                System.out.println("Received msg [" + envelope.getRoutingKey() + "] "
                        + msg);

                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };

        channel.basicConsume(queueName, false, consumer);


    }
}
