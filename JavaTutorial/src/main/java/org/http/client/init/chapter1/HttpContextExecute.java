package org.http.client.init.chapter1;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * 1.3 HttpClient执行上下文
 * 
 * @author yujinshui
 * @createTime 2016年7月27日 上午11:40:03
 */
public class HttpContextExecute {
	private static void executeContext() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();
		HttpGet httpget1 = new HttpGet("http://localhost:8080/");
		httpget1.setConfig(requestConfig);
		CloseableHttpResponse response1 = httpclient.execute(httpget1);
		try {
			HttpEntity entity1 = response1.getEntity();

		} finally {
			response1.close();
		}
		HttpGet httpget2 = new HttpGet("http://localhost:8081/nexus");
		CloseableHttpResponse response2 = httpclient.execute(httpget2);
		try {
			HttpEntity entity2 = response2.getEntity();
		} finally {
			response2.close();
		}
	}

	public static void main(String[] args) {
		try {
			executeContext();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("execute is ok.");

	}

}
