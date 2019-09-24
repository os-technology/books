package com.mvn.share.notes.producerconfirm;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author code
 * @Title: RabbitFactory
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/242:23 PM
 */
public class RabbitFactory {
    static Connection conn;
    static Channel channel;

    public static Channel getRabbitConnection(String exchangeName, BuiltinExchangeType type) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        conn = factory.newConnection();

        channel = conn.createChannel();
        channel.exchangeDeclare(exchangeName, type);

        return channel;
    }

    public static void close() throws IOException, TimeoutException {
        if (channel != null) {
            channel.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
