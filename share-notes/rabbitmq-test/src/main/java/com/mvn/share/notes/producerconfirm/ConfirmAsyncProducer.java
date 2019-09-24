package com.mvn.share.notes.producerconfirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者——异步监听模式
 *
 * @author code
 * @Title: RabbitmqClient
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/1611:19 PM
 */
public class ConfirmAsyncProducer {

    public static final String EXCHANGE_NAME = "ConfirmProducer_asyn";
    public static final String ROUTE_KEY = "ConfirmProducer_asyn_key";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitFactory.getRabbitConnection(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //开启发送者确认模式
        channel.confirmSelect();

        //添加发送者确认监听器
        channel.addConfirmListener(new ConfirmListener() {
            //成功
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                //deliveryTag:发送消息的ID号，默认从 1 开始计数
                //multiple:是否为批量确认机制，默认false，当消息发送到一定数量，会自动变为true(自动切换成批量确认)
                //基于性能的考虑
                System.out.println("success-ack:" + deliveryTag + ",multiple=" + multiple);
            }

            //失败
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("failure----NACK：" + deliveryTag + ",multiple=" + multiple);
            }
        });

        //添加失败通知

        channel.addReturnListener((ReturnListener) (replyCode, replyText, exchange, routingKey, properties, body) -> {
            String msg = new String(body);

            System.out.println("rabbitMq失败：routeKey=" + routingKey + "-" + msg);
        });

        String[] routeKey = {ROUTE_KEY, "mark"};
        for (int i = 0; i < 6; i++) {
//            String key = routeKey[i % 2];
            String key = ROUTE_KEY;
            String msg = "producer_confirm_" + i;
            channel.basicPublish(EXCHANGE_NAME, key, true, null, msg.getBytes());
            System.out.println("Send msg:[" + key + "]:" + msg);

        }
    }
}
