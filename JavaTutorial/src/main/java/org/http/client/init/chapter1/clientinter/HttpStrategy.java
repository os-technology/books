package org.http.client.init.chapter1.clientinter;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class HttpStrategy {

	private static void aliveStrategy(){
		ConnectionKeepAliveStrategy keepAliveStrategy = new DefaultConnectionKeepAliveStrategy(){
			
			public long getKeepAliveDuration(HttpResponse response,HttpContext context){
				long keepAlive  = super.getKeepAliveDuration(response, context);
				if(keepAlive==-1){
					keepAlive = 5000;
				}
				
				return keepAlive;
				
			}
		};
		
		CloseableHttpClient httpclient = HttpClients.custom().setKeepAliveStrategy(keepAliveStrategy).build();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
