package com.mvn.share.notes;

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
public class RabbitmqClient {

    private static final String EXCHANGE_NAME="rabbit_log";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
// "guest"/"guest" by default, limited to localhost connections
        factory.setHost("127.0.0.1");
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        factory.setVirtualHost("/");
//        factory.setPort(5672);

        Connection conn = factory.newConnection();

        Channel channel = conn.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.DIRECT);



        //Thread.sleep(10000);
        channel.close();
        conn.close();
    }
}
