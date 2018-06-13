package org.io.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * http://www.importnew.com/28021.html
 * socketchannel服务端
 *
 * @author yuijnshui@lxfintech.com
 * @Title: SocketServer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/12下午3:28
 */

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //监听8080端口进来的TCP链接
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while (true) {
            //这里会阻塞，直到有一个请求的连接进来
            SocketChannel socketChannel = serverSocketChannel.accept();

            SocketHandler handler = new SocketHandler(socketChannel);
            new Thread(handler).start();


        }
    }

}
