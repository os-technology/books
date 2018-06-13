package org.io.nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SelectorServer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/13上午9:28
 */

public class SelectorServer {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        //将其注册到Selector中，监听OP_ACCEPT事件
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        while (true){
            //需要不断地去调用select()方法获取最新的准备好的通道
            int readyChannels = selector.select();
            if (readyChannels==0){
                continue;
            }

            Set<SelectionKey> readyKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = readyKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                iterator.remove();

                if (key.isAcceptable()){
                    //有已经接受的心的服务端的连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                }
            }
        }


    }

}
