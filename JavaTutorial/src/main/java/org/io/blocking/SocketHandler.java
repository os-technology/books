package org.io.blocking;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SocketHandler
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/12下午3:38
 */

public class SocketHandler implements Runnable {

    private SocketChannel socketChannel;

    public SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            //将请求数据读入buffer中
            int num;

            while ((num = socketChannel.read(buffer)) > 0) {
                //读取buffer内容之前先flip一下
                buffer.flip();

                //提取buffer中的数据
                byte[] bytes = new byte[num];
                buffer.get(bytes);
                String re = new String(bytes,"UTF-8");
                System.out.println("收到请求："+re);

                //回应客户端
                ByteBuffer writeBuffer = ByteBuffer.wrap(("我已收到请求,请求内容为："+re).getBytes());
                socketChannel.write(writeBuffer);

                buffer.flip();

            }
        }catch (IOException e){
            IOUtils.closeQuietly(socketChannel);
        }
    }
}
