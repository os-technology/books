package org.chapter.databasic.http;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpTest {
	public void httpRequest1(String url) {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet(url);
		CloseableHttpResponse res = null;
		try {
			res = client.execute(get);
			System.out.println(res);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (res != null) {
				try {
					res.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HttpTest http = new HttpTest();
		String url = "http://www.baidu.com/";
		http.httpRequest1(url);

	}

}
