package org.http.client.init.chapter1;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.4 HTTP协议拦截器
 * 
 * @author yujinshui
 * @createTime 2016年7月30日 上午9:10:10
 */
public class HttpContextInterceptor {
	@Test
	public void httpStatus() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.custom().addInterceptorLast(new HttpRequestInterceptor() {

			@Override
			public void process(final HttpRequest request, final HttpContext context)
					throws HttpException, IOException {
				AtomicInteger count = (AtomicInteger) context.getAttribute("count");
				request.addHeader("count", Integer.toString(count.getAndIncrement()));

			}
		}).build();
		AtomicInteger count = new AtomicInteger(1);
		HttpClientContext localContext = HttpClientContext.create();
		localContext.setAttribute("count", count);
		HttpGet httpget = new HttpGet("http://localhost:8081/nexus");
		for (int i = 0; i < 10; i++) {
			CloseableHttpResponse response = httpclient.execute(httpget, localContext);
			HttpEntity entity = response.getEntity();
			response.close();
		}
	}

}
