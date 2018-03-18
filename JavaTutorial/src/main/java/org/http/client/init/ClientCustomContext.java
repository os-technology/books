package org.http.client.init;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

/**
 * 1.3 HttpClient执行上下文<br>
 * 这个例子演示了使用本地HTTP上下文填充自定义属性。
 * 
 * @author yujinshui
 * @createTime 2016年7月27日 上午11:57:31
 */
public class ClientCustomContext {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		 
			// Create a local instance of cookie store
			CookieStore cookieStore = new BasicCookieStore();
			// Create local HTTP context
			HttpClientContext localContext = HttpClientContext.create();
			// Bind custom cookie store to the local context(绑定定制cookie存储到本地上下文)
			localContext.setCookieStore(cookieStore);
			HttpGet httpget = new HttpGet("http://localhost:8081/nexus/#welcome");
			System.out.println("Executing request :" + httpget.getRequestLine());
			// Pass local context as a parameter
			CloseableHttpResponse response = httpclient.execute(httpget, localContext);

			try {
				System.out.println("----------------------");

				System.out.println(response.getStatusLine());
				List<Cookie> cookies = cookieStore.getCookies();
				for (int i = 0; i < cookies.size(); i++) {
					System.out.println("Local cookie:" + cookies.get(i));
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		 
	}

}
