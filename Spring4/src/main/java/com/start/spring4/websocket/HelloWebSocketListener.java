package com.start.spring4.websocket;
import java.io.*;
import java.util.*;
import com.caucho.websocket.*;


/**
 * @author yuijnshui@lxfintech.com
 * @Title: HelloWebSocketListener
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/6/16下午11:04
 */

public class HelloWebSocketListener  extends AbstractWebSocketListener {

    @Override
    public void onStart(WebSocketContext context) throws IOException {
        System.out.println("【启动】HelloWebSocketListener" + new java.util.Date());
        PrintWriter out = context.startTextMessage();
        out.print("start ok");
        out.close();
    }

    public void onReadText(WebSocketContext webSocketContext, Reader reader)
            throws IOException {
        PrintWriter out = null;
        int ch;
        String text = "";
        while ((ch = reader.read()) >= 0) {
            text = text + (char) ch;
        }
        int id = webSocketContext.hashCode();

        Hashtable map = HelloWebSocketServlet.HashtablegetSockList();
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            WebSocketContext w = (WebSocketContext) entry.getValue();
            out = w.startTextMessage();
            out.print(id + ": [" + entry.getKey() + "]" + text);
            out.close();
        }
        reader.close();

    }

    public void onClose(WebSocketContext context) throws IOException {
        System.out.println("【关闭】HelloWebSocketListener" + new java.util.Date());
    }

    public void onDisconnect(WebSocketContext context) throws IOException {
        System.out.println("【断开连接】HelloWebSocketListener"
                + new java.util.Date());
        Hashtable map = HelloWebSocketServlet.HashtablegetSockList();
        map.remove(context.hashCode());
    }

}
