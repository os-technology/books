package com.mvn.share.notes.rejectmsg;

import com.mvn.share.notes.producerconfirm.RabbitFactory;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author code
 * @Title: RejectProducer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/272:08 PM
 */
public class RejectProducer {
    public final static String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitFactory.getRabbitConnection(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        for (int i = 0; i < 10; i++) {
            String msg = "reject msg " + (i + 1);
            channel.basicPublish(EXCHANGE_NAME, "error", null, msg.getBytes());
            System.out.println(" [x] Sent 'error':'"
                    + msg + "'");
        }
        RabbitFactory.close();
    }
}
