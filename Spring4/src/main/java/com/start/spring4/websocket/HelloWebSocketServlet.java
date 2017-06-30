package com.start.spring4.websocket;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import java.io.*;
import java.util.*;

import com.caucho.websocket.*;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HelloWebSocketServlet
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/6/16下午10:25
 */

public class HelloWebSocketServlet extends HttpServlet {
    private static final long serialVersionUID = -7355034669293882184L;

    private static Hashtable map_socket = new Hashtable(50);

    public void service(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name");

        WebSocketListener listener;
        listener = new HelloWebSocketListener();

        WebSocketServletRequest wsReq = (WebSocketServletRequest) request;
        WebSocketContext webSocketContext = wsReq.startWebSocket(listener);

        map_socket.put(name, webSocketContext);

    }

    public static Hashtable HashtablegetSockList() {
        return map_socket;
    }

}
